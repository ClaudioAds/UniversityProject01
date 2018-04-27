/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.dao;

import br.com.ifpb.controll.PessoaIF;
import br.com.ifpb.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class PessoaDao implements PessoaIF {

    Connection con;

    public PessoaDao() {
        con = Conexao.getConnection();
    }

    @Override
    public void adicionar(Pessoa pessoa) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pessoa (nome, cpf, idade, altura, peso, imc)VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setFloat(4, pessoa.getAltura());
            stmt.setFloat(5, pessoa.getPeso());
            stmt.setFloat(6, pessoa.calculaImc());

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
            stmt = con.prepareStatement("UPDATE INTO pessoa SET nome = ?, cpf = ?, idade = ?, altura = ?, peso = ?, imc = ? WHERE cpf = ?");

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setFloat(4, pessoa.getAltura());
            stmt.setFloat(5, pessoa.getPeso());
            stmt.setFloat(5, pessoa.getImc());

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
            stmt = con.prepareStatement("SELECT * FROM pessoa");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setAltura(rs.getFloat("altura"));
                pessoa.setPeso(rs.getFloat("peso"));
                pessoa.setImc(rs.getFloat("imc"));

                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setAltura(rs.getFloat("altura"));
                pessoa.setPeso(rs.getFloat("peso"));
                pessoa.setImc(rs.getFloat("imc"));
                
                pessoas.add(pessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return pessoas;

    }

}
