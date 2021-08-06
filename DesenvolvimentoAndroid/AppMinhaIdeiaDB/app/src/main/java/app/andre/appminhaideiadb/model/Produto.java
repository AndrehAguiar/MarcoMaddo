package app.andre.appminhaideiadb.model;

import android.util.Log;

import app.andre.appminhaideiadb.controller.ICrud;

public class Produto {

    private long id;
    private String nome;
    private String fornecedor;

    public Produto() {
    }

    public Produto(String nome, String fornecedor) {
        this.nome = nome;
        this.fornecedor = fornecedor;
    }

    public Produto(long id, String nome, String fornecedor) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                '}';
    }
}
