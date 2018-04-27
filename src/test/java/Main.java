
import br.com.ifpb.model.CalculaImc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author claudio
 */
public class Main {
    
    public static void main(String[] args) {
        float imc = 0;
        String resultado;
        
        CalculaImc calcula = new CalculaImc();
        
        imc = calcula.calculaImc(72, (float) 1.72);
        resultado = String.valueOf(imc);
        
        System.out.println(resultado);
    }
    
}
