package app.andre.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.andre.appminhaideiadb.api.AppUtil;
import app.andre.appminhaideiadb.datamodel.ClienteDataModel;
import app.andre.appminhaideiadb.datasource.AppDataBase;
import app.andre.appminhaideiadb.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadosObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado DB");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadosObjeto = new ContentValues();
        dadosObjeto.put(ClienteDataModel.NAME, obj.getNome());
        dadosObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        return insert(ClienteDataModel.TABLE, dadosObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadosObjeto = new ContentValues();
        dadosObjeto.put(ClienteDataModel.ID, obj.getId());
        dadosObjeto.put(ClienteDataModel.NAME, obj.getNome());
        dadosObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        return update(ClienteDataModel.TABLE, dadosObjeto);
    }

    @Override
    public boolean deletar(long id) {
        return deleteById(ClienteDataModel.TABLE, id);
    }

    @Override
    public List<Cliente> listar() {
        return findAllClientes(ClienteDataModel.TABLE);
    }

    @Override
    public Cliente findById(long id) {
        return findClienteById(ClienteDataModel.TABLE, id);
    }
}
