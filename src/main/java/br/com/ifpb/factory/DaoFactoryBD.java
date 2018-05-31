/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.factory;

import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.dao.PessoaDaoMySql;
import br.com.ifpb.dao.PessoaDaoPG;
import br.com.ifpb.dao.PessoaDaoTxt;
import br.com.ifpb.dao.PessoaDaoXml;

/**
 *
 * @author Claudio
 */
public class DaoFactoryBD implements DaoFactoryIf {
    
    public PessoaIF criar(String opcao){
        switch(opcao){
            case "PG":
                return new PessoaDaoPG();
            case "MySql":
                return new PessoaDaoMySql();
        }
        return null;
    }


    @Override
    public PessoaIF criaPessoaDaoPG() {
        return new PessoaDaoPG();
    }

    @Override
    public PessoaIF criaPessoaDaoTxt() {
        return new PessoaDaoTxt();
    }

    @Override
    public PessoaIF criaPessoaDaoMySql() {
        return new PessoaDaoMySql();
    }

    @Override
    public PessoaIF criaPessoaDaoXml() {
        return new PessoaDaoXml();
    }

}
