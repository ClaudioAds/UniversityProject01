
package br.com.ifpb.dao;

import br.com.ifpb.controll.CalculaImc;
import br.com.ifpb.model.Pessoa;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author claudio
 */
public class TesteMain {

//    public static void main(String[] args) throws FileNotFoundException {
//
//        try {
//            FileReader file = new FileReader("src/main/java/arquivoTxt/Pessoa.txt");
//            BufferedReader br = new BufferedReader(file);
//
//            Pessoa pessoa = new Pessoa();
//            PessoaDaoTxt ptxt = new PessoaDaoTxt();
//            CalculaImc cl = new CalculaImc();
//
////        pessoa.setNome("Antonio");
////        pessoa.setCpf("123456789");
////        pessoa.setIdade(30);
////        pessoa.setAltura((float) 1.70);
////        pessoa.setPeso(72);
////
////        pessoa.setImc(cl.calculaImc(pessoa.getAltura(), pessoa.getPeso()));
////        pessoa.setStatus("Você está acima do Peso!");
////        
////        ptxt.adicionar(pessoa);
////         
//
//            String linha = new String();
//            //enquanto houver mais linhas
//            
//            
//            while (br.ready()) {
//                //lê a proxima linha
//                linha = br.readLine();
//                
//                System.out.println(linha);
//                if (linha != null && linha.isEmpty()) {
//                    //pessoas.add(linha);
//                }
//            }
//
//            
//
//            br.close();
//            file.close();
//
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Erro na Leitura");
//            ex.printStackTrace();
//
//        }
//
//    }
}
