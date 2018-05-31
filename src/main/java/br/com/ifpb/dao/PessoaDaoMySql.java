/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.dao;

import br.com.ifpb.connection.ConexaoMySql;
import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class PessoaDaoMySql implements PessoaIF {

    Connection con;

    public PessoaDaoMySql() {
        con = ConexaoMySql.getConnection();
    }

    @Override
    public void adicionar(Pessoa pessoa) throws SQLDataException {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Pessoa (nome, cpf, idade, altura, peso, imc, status)VALUES(?, ?, ?, ?, ?, ?, ?)");
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
            ConexaoMySql.closeConnection(con, stmt);
        }
    }

    @Override
    public void remover(Pessoa pessoa) throws SQLDataException {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Pessoa WHERE cpf = ?");
            stmt.setString(1, pessoa.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConexaoMySql.closeConnection(con, stmt);
        }
    }

    @Override
    public void alterar(Pessoa pessoa) throws SQLDataException {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE INTO Pessoa SET nome = ?, cpf = ?, idade = ?, altura = ?, peso = ? WHERE cpf = ?");

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
            ConexaoMySql.closeConnection(con, stmt);
        }
    }

    @Override
    public List<Pessoa> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa order by nome");
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
            ConexaoMySql.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

    @Override
    public List<Pessoa> buscaPorDesc(String desc) throws SQLDataException {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa WHERE nome LIKE ?");
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
            ConexaoMySql.closeConnection(con, stmt, rs);
        }

        return pessoas;
    }

}
