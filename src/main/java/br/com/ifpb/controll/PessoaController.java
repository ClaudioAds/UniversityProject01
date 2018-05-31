/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.controll;

import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.factory.FactoryDao;
import br.com.ifpb.dao.PessoaDaoPG;
import br.com.ifpb.model.Pessoa;
import br.com.ifpb.view.JanelaCadastrarPessoa;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author claudio
 */
public class PessoaController {

    private Pessoa pessoa;
    private PessoaIF pessoaDaoIf;
    private PessoaDaoPG pessoaDao;
    private List<Pessoa> pessoas;
    private FactoryDao factoryDao = new FactoryDao();

    private JanelaCadastrarPessoa janelaCadastraPessoa;

    public PessoaController(JanelaCadastrarPessoa jf) {

        pessoaDao = new PessoaDaoPG();
        pessoa = new Pessoa();
        janelaCadastraPessoa = jf;

    }

    public void botaoCadastrarBanco(String nome, String cpf, String idade, String altura, String peso) {

        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setIdade(Integer.parseInt(idade));
        pessoa.setAltura(Float.parseFloat(altura));
        pessoa.setPeso(Float.parseFloat(peso));

        pessoaDao.adicionar(pessoa);
    }

    public void botaoExcluirBanco() {

        if (janelaCadastraPessoa.getjTPessoas().getSelectedRow() != -1) {

            PessoaDaoPG pessoaDao = new PessoaDaoPG();

            pessoa.setCpf((String) janelaCadastraPessoa.getjTPessoas().getValueAt(janelaCadastraPessoa.getjTPessoas().getSelectedRow(), 0));

            pessoaDao.remover(pessoa);

        }
    }

    public void botaoAtualizarBanco(String nome, String cpf, String idade, String altura, String peso) {

        pessoa.setNome(janelaCadastraPessoa.getTxtNome().getText());
        pessoa.setCpf(janelaCadastraPessoa.getTxtCpf().getText());
        pessoa.setIdade(Integer.parseInt(janelaCadastraPessoa.getTxtIdade().getText()));
        pessoa.setAltura(Float.parseFloat(janelaCadastraPessoa.getTxtAltura().getText()));
        pessoa.setPeso(Float.parseFloat(janelaCadastraPessoa.getTxtPeso().getText()));

        pessoaDao.alterar(pessoa);

    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) janelaCadastraPessoa.getjTPessoas().getModel();
        modelo.setNumRows(0);

        PessoaDaoPG pessoaDao = new PessoaDaoPG();
        
        for (Pessoa pessoa : pessoaDao.listar()) {

            modelo.addRow(new Object[]{
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getIdade(),
                pessoa.getAltura(),
                pessoa.getPeso(),
                pessoa.calculaImc(),
                pessoa.getStatus()
            });
        }

    }

    public void readJTableForDesc(String desc) {

        DefaultTableModel modelo = (DefaultTableModel) janelaCadastraPessoa.getjTPessoas().getModel();
        modelo.setNumRows(0);
        PessoaDaoPG pessoaDao = new PessoaDaoPG();

        for (Pessoa pessoa : pessoaDao.buscaPorDesc(desc)) {

            modelo.addRow(new Object[]{
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getIdade(),
                pessoa.getAltura(),
                pessoa.getPeso(),
                pessoa.calculaImc(),
                pessoa.getStatus()
            });

        }

    }
    
//    public void comboBox(String opcao){
//        RadioButton radio = new RadioButton();
//        JComboBox comboBox = new JComboBox();
//        
//        
//        if(radio.isSelected() == false){
//            comboBox.set
//        }
//            
//        }
    

}
