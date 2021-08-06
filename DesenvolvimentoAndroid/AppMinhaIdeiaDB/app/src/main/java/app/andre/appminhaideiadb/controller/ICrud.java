package app.andre.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {

    public boolean incluir(T obj);

    public boolean alterar(T obj);

    public boolean deletar(long id);

    public List<T> listar();

    public T findById(long id);

}
