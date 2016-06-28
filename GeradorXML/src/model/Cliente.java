/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luiz.buris
 */
public class Cliente {

    private String nome;
    private String endereco;
    private InformacaoClient infoClient;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public InformacaoClient getInfoClient() {
        return infoClient;
    }

    public void setInfoClient(InformacaoClient infoClient) {
        this.infoClient = infoClient;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", endereco=" + endereco + ", infoClient=" + infoClient + '}';
    }

}
