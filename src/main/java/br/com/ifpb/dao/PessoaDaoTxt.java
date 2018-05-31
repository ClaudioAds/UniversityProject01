package br.com.ifpb.dao;

import br.com.ifpb.interfaces.PessoaIF;
import br.com.ifpb.model.Pessoa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class PessoaDaoTxt implements PessoaIF {

    private File file;

    public PessoaDaoTxt() {
        file = new File("src/main/java/arquivoTxt/Pessoa.txt");
    }

    @Override
    public void adicionar(Pessoa pessoa) {

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter saida = new BufferedWriter(fw);

            saida.write("Nome: " + pessoa.getNome() + ", CPF: " + pessoa.getCpf()
                    + ", Idade: " + String.valueOf(pessoa.getIdade()) + ", Altura: "
                    + String.valueOf(pessoa.getAltura()) + ", Peso: "
                    + String.valueOf(pessoa.getPeso()) + ", IMC = "
                    + String.valueOf(pessoa.getImc()) + ", Status: " + pessoa.getStatus() + ";");

            saida.newLine();
            saida.close();
            fw.close();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Pessoa pessoa) {

        try {
            //inicia a leitura do arquivo txt
            FileReader buscar = new FileReader(file);
            BufferedReader br = new BufferedReader(buscar);

            //duas variãveis para percorer o arquivo e salvar os itens do mesmo em uma nova lista
            String linha = br.readLine();
            List<String> pessoasSalvas = new LinkedList<>();

            while (linha != null) {
                //Ao ler o arquivo, no campo CPF, e for igual ao passado será a pagado e 
                if (linha.equals(pessoa.getCpf()) == false) {
                    pessoasSalvas.add(linha);
                }
            }

            buscar.close();
            br.close();

            FileWriter fw = new FileWriter(file, true);
            fw.close();

            FileWriter fw2 = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw2);

            for (int i = 0; i > pessoasSalvas.size(); i++) {
                bw.write(pessoasSalvas.get(i));
                bw.newLine();
            }
            //encerra a esrita da nova lista de pessoas salvas e fecha a conexão
            bw.close();
            fw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> listar() {

        String linha = new String();

        if (file.exists()) {
            try {
                FileReader fr = new FileReader("src/main/java/arquivoTxt/Pessoa.txt");
                BufferedReader br = new BufferedReader(fr);

                //enquanto houver mais linhas
                while (br.ready()) {
                    //lê a proxima linha
                    linha = br.readLine();
                    System.out.println(linha);
                    if (linha != null && linha.isEmpty()) {
                        //pessoas.add(linha);
                    }
                }

                br.close();
                fr.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro na Leitura");
                ex.printStackTrace();

            }
        }
        return null;
    }

    @Override
    public List<Pessoa> buscaPorDesc(String desc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
