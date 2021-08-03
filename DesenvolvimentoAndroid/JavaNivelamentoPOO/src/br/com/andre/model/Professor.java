package br.com.andre.model;

public class Professor extends Pessoa {

    private String titulo;

    public Professor(String nome, String telefone, String email, String titulo) {
        super(nome, telefone, email);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String falarIdioma() {
        return "Oxe, mas num é que funciona mesmo?!";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nProfessor{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
