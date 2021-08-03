package br.com.andre.model;

public class Estudante extends Pessoa {

    private int ra;
    private String curso;

    public Estudante(String nome, String telefone, String email, int ra, String curso) {
        super(nome, telefone, email);
        this.ra = ra;
        this.curso = curso;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String falarIdioma() {
        return "Uai, esse trem é bom mesmo sô!";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEstudante{" +
                "ra=" + ra +
                ", curso='" + curso + '\'' +
                '}';
    }
}
