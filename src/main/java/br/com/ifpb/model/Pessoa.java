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
public class Pessoa {

    private String nome, cpf;
    private int idade;
    private float altura, peso, imc;
    private String status;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, int idade, float altura, float peso, float imc, String status) {
        this.nome = null;
        this.cpf = null;
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
        this.imc = 0;
        this.status = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
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

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", altura=" + altura + ", peso=" + peso + ", imc=" + imc + ", status=" + status + '}';
    }

    public float calculaImc() {

        imc = peso / (altura * altura);

        if (imc < 18.5) {
            setStatus("*** Abaixo do Peso ***");
        } else if (imc >= 18.5 && imc <= 24.99) {
            setStatus("*** Peso Ideal ***");
        } else {
            setStatus("*** Acima do Peso ***");
        }

        return imc;
    }

}
