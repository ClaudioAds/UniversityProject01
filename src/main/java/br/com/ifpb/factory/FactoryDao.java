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
 * @author claudio
 */
public class FactoryDao {
    
    public PessoaIF criarDao(String tipo){
        
        switch(tipo){
            case "PG":
                return new PessoaDaoPG();
            
            case  "TXT":
                return new PessoaDaoTxt();
            
            case  "MYSQL":
                return new PessoaDaoMySql();
            
            case  "XML":
                return new PessoaDaoXml();
                
            default :
                return null;
        }
        
    }
    
    
    
}
