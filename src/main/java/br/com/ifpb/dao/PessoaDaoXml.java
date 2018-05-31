/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.dao;

import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.model.Pessoa;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author claudio
 */
public class PessoaDaoXml implements PessoaIF {

    private XStream xstream = new XStream(new DomDriver("UTF-8"));
    private List<Pessoa> pessoas;

    public PessoaDaoXml() {
        this.pessoas = new LinkedList<>();

        this.recuperarCentral();
    }

    @Override
    public void adicionar(Pessoa pessoa) throws SQLDataException {

        pessoas.add(pessoa);

        this.salvarCentral();
    }

    @Override
    public void remover(Pessoa pessoa) throws SQLDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Pessoa pessoa) throws SQLDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listar() {
        return pessoas;
    }

    @Override
    public List<Pessoa> buscaPorDesc(String desc) throws SQLDataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void salvarCentral() {
        File arquivo = new File("src/main/java/arquivoXml/Pessoa.xml");
        String xml = xstream.toXML(pessoas);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.print(xml);
            gravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recuperarCentral() {
        File arquivo = new File("src/main/java/arquivoXml/Pessoa.xml");
        if (arquivo.exists()) {
            try {
                FileInputStream r = new FileInputStream(arquivo);
                this.pessoas = (List<Pessoa>) xstream.fromXML(r);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
