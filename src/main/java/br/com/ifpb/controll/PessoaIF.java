/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.controll;

import br.com.ifpb.model.Pessoa;
import java.util.List;

/**
 *
 * @author claudio
 */
public interface PessoaIF {
 
    public void adicionar(Pessoa pessoa);
    
    public void remover(Pessoa pessoa);
    
    public void alterar(Pessoa pessoa);
    
    public List<Pessoa> listar();
}
