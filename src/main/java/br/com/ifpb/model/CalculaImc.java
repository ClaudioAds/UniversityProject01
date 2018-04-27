/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.model;

/**
 *
 * @author claudio
 */
public class CalculaImc {

    public float calculaImc(float peso, float altura) {
        float imc = 0;

        imc = peso / (altura * altura);

        return imc;
    }

    public float calculaImc2() {
        float peso = 0;
        float altura = 0;
        float imc = 0;

        imc = peso / (altura * altura);

        return imc;
    }

}
