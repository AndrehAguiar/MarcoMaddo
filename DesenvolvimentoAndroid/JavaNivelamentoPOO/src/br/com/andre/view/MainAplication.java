package br.com.andre.view;

import br.com.andre.model.Estudante;
import br.com.andre.model.Pessoa;
import br.com.andre.model.Professor;

public class MainAplication {
    public static void main(String[] args) {
        Pessoa objPessoa = new Pessoa(
                "Augusto",
                "31 99999-9999",
                "pessoa@email.com"
        );
        Estudante objEstudante = new Estudante(
                "Aguiar",
                "31 99999-9999",
                "estudante@email.com",
                123,
                "Android Studio"
        );
        Professor objProfessor = new Professor(
                "André",
                "31 99999-9999",
                "professor@email.com",
                "Mestre"
        );

        System.out.println(objPessoa + "\n" + objPessoa.falarIdioma() + "\n");
        System.out.println(objEstudante + "\n" + objEstudante.falarIdioma() + "\n");
        System.out.println(objProfessor + "\n" + objProfessor.falarIdioma() + "\n");
    }
}
