/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.controll;

/**
 *
 * @author claudio
 */
public class CalculaImc {

    private double imc;
    private String status;

    public CalculaImc() {
    }

    public CalculaImc(double imc, String status) {
        this.imc = 0;
        this.status = null;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //###################################################################
    public double calculaImc(double altura, double peso) {

        imc = peso / (altura * altura);

        return imc;
    }

    public double calculaImcEstadosU(double altura, double peso) {
        double libras = 0;
        double polegadas =0;
        
        //1 Kg = 2,2036 Libras (lb) 158,65 ------ 
        //1 M = 0,0254 Polegadas (pl) 0,4318 ---- 0,18645124
        
        libras = peso * 2.2046;
        polegadas = altura * 39.3701;
        
        imc = libras * 703 / (polegadas * polegadas);
        

        return imc;
    }

    public double calculaImcEspanha(double altura, double peso) {

        imc = peso / (altura * altura);

        return imc;
    }

}
