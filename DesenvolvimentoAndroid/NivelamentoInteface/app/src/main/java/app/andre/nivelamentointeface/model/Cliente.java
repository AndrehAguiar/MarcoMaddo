package app.andre.nivelamentointeface.model;

import android.util.Log;

import app.andre.nivelamentointeface.repository.ICrud;

public class Cliente implements ICrud {

    private static final String TAG = "CRUD";
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        Log.i(TAG, "incluir: Cliente" +
                getNome());

    }

    @Override
    public void alterar() {
        Log.i(TAG, "alterar: Cliente");
    }

    @Override
    public void deletar() {
        Log.i(TAG, "deletar: Cliente");
    }

    @Override
    public void listar() {
        Log.i(TAG, "listar: Cliente");
    }
}
