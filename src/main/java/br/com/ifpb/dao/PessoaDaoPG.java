package br.com.ifpb.dao;

import br.com.ifpb.connection.Conexao;
import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class PessoaDaoPG implements PessoaIF {

    Connection con;

    public PessoaDaoPG() {
        con = Conexao.getConnection();
    }

    @Override
    public void adicionar(Pessoa pessoa) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pessoa (nome, cpf, idade, altura, peso, imc, status)VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setFloat(4, pessoa.getAltura());
            stmt.setFloat(5, pessoa.getPeso());
            stmt.setFloat(6, pessoa.calculaImc());
            stmt.setString(7, pessoa.getStatus());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    @Override
    public void remover(Pessoa pessoa) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM pessoa WHERE cpf = ?");
            stmt.setString(1, pessoa.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    @Override
    public void alterar(Pessoa pessoa) {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE INTO pessoa SET nome = ?, cpf = ?, idade = ?, altura = ?, peso = ? WHERE cpf = ?");

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setFloat(4, pessoa.getAltura());
            stmt.setFloat(5, pessoa.getPeso());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);

        }
    }

    @Override
    public List<Pessoa> listar() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa order by nome");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setAltura(rs.getFloat("altura"));
                pessoa.setPeso(rs.getFloat("peso"));
                pessoa.setImc(rs.getFloat("imc"));
                pessoa.setStatus(rs.getString("status"));

                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoPG.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }
    

    public List<Pessoa> buscaPorDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setAltura(rs.getFloat("altura"));
                pessoa.setPeso(rs.getFloat("peso"));
                pessoa.setImc(rs.getFloat("imc"));
                pessoa.setStatus(rs.getString("status"));

                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoPG.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return pessoas;

    }

    public void getPessoas() {

        ResultSet rs = null;
        PreparedStatement pstm = null;
        Statement statment = null;

        try {
            statment = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pstm.executeQuery("SELECT * FROM pessoa order by nome");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na leitura");
        }

    }

    public ResultSet primeiroRegistro() {
        ResultSet result = null;

        try {
            result.first();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoPG.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
