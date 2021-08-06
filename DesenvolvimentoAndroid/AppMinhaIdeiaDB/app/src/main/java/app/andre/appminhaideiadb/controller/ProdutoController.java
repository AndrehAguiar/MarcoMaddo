package app.andre.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.andre.appminhaideiadb.api.AppUtil;
import app.andre.appminhaideiadb.datamodel.ProdutoDataModel;
import app.andre.appminhaideiadb.datasource.AppDataBase;
import app.andre.appminhaideiadb.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadosObjeto;

    public ProdutoController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ProdutoController: Conectado DB");
    }

    @Override
    public boolean incluir(Produto obj) {
        dadosObjeto = new ContentValues();
        dadosObjeto.put(ProdutoDataModel.NAME, obj.getNome());
        dadosObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return insert(ProdutoDataModel.TABLE, dadosObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {
        dadosObjeto = new ContentValues();
        dadosObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadosObjeto.put(ProdutoDataModel.NAME, obj.getNome());
        dadosObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());
        return update(ProdutoDataModel.TABLE, dadosObjeto);
    }

    @Override
    public boolean deletar(long id) {
        return deleteById(ProdutoDataModel.TABLE, id);
    }

    @Override
    public List<Produto> listar() {
        return findAllProdutos(ProdutoDataModel.TABLE);
    }

    @Override
    public Produto findById(long id) {
        return findProdutoById(ProdutoDataModel.TABLE, id);
    }

/*    @Override
    public Produto findById(long id) {
        dadosObjeto = new ContentValues();
        dadosObjeto.put(ProdutoDataModel.ID, id);
        return null;
    }*/
}
