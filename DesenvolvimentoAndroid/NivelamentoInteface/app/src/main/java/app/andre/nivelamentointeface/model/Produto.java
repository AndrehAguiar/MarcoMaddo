package app.andre.nivelamentointeface.model;

import android.util.Log;

import app.andre.nivelamentointeface.repository.ICrud;

public class Produto implements ICrud {

    private static final String TAG = "CRUD";
    private String nome;
    private String fornecedor;

    public Produto(String nome, String fornecedor) {
        this.nome = nome;
        this.fornecedor = fornecedor;
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
    public void incluir() {
        Log.i(TAG, "incluir: Produto" +
                getNome());
    }

    @Override
    public void alterar() {
        Log.i(TAG, "alterar: Produto");
    }

    @Override
    public void deletar() {
        Log.i(TAG, "deletar: Produto");
    }

    @Override
    public void listar() {
        Log.i(TAG, "listar: Produto");
    }
}
