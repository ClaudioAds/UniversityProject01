/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.factory;

import br.com.ifpb.interfaces.PessoaIF;

/**
 *
 * @author Claudio
 */
public interface DaoFactoryIf {

    public PessoaIF criaPessoaDaoPG();

    public PessoaIF criaPessoaDaoTxt();

    public PessoaIF criaPessoaDaoMySql();

    public PessoaIF criaPessoaDaoXml();

}
