/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.interfaces;

import br.com.ifpb.model.Pessoa;
import java.sql.SQLDataException;
import java.util.List;

/**
 *
 * @author claudio
 */
public interface PessoaIF {
 
    public void adicionar(Pessoa pessoa) throws SQLDataException;
    
    public void remover(Pessoa pessoa) throws SQLDataException;
    
    public void alterar(Pessoa pessoa) throws SQLDataException;
    
    public List<Pessoa> listar();
    
    public List<Pessoa> buscaPorDesc(String desc) throws SQLDataException;
}
