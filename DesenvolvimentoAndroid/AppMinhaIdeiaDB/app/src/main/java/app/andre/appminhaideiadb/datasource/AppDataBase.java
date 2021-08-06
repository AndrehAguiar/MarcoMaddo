package app.andre.appminhaideiadb.datasource;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.andre.appminhaideiadb.api.AppUtil;
import app.andre.appminhaideiadb.datamodel.ClienteDataModel;
import app.andre.appminhaideiadb.datamodel.ProdutoDataModel;
import app.andre.appminhaideiadb.model.Cliente;
import app.andre.appminhaideiadb.model.Produto;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando o Banco de Dados");
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.createTable());
        Log.d(AppUtil.TAG, "onCreate: Table client created...\n" +
                ClienteDataModel.createTable());

        db.execSQL(ProdutoDataModel.createTable());
        Log.d(AppUtil.TAG, "onCreate: Table product created...\n" +
                ProdutoDataModel.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean insert(String table, ContentValues data) {
        boolean result = false;

        try {
            db = getWritableDatabase();
            result = db.insert(table, null, data) > 0;
            if (result)
                Log.i(AppUtil.TAG, "insert: Dados inseridos com sucesso na tabela ===> " + table);
            return result;

        } catch (Exception e) {
            Log.e(AppUtil.TAG, "insert: Erro ao inserir os dados na tabela ===> " +
                    table + "\n===>" + e.getMessage());
            return result;
        }
    }

    public boolean update(String table, ContentValues data) {
        boolean result = false;

        try {
            db = getWritableDatabase();
            result = db.update(table, data, "id=?", new String[]{String.valueOf(data.get("id"))}) > 0;
            if (result)
                Log.i(AppUtil.TAG, "update: Dados alterados com sucesso na tabela ===> " + table);
            return result;

        } catch (Exception e) {
            Log.e(AppUtil.TAG, "update: Erro ao alterar os dados na tabela ===> " +
                    table + "\n===>" + e.getMessage());
            return result;
        }
    }

    public boolean deleteById(String table, long id) {
        boolean result = false;

        try {
            db = getWritableDatabase();
            result = db.delete(table, "id = ?", new String[]{String.valueOf(id)}) > 0;
            if (result)
                Log.i(AppUtil.TAG, "delete: Dados deletados com sucesso na tabela ===> " + table);
            return result;

        } catch (Exception e) {
            Log.e(AppUtil.TAG, "delete: Erro ao deletar os dados na tabela ===> " +
                    table + "\n===>" + e.getMessage());
            return result;
        }
    }

    @SuppressLint({"Range", "Recycle"})
    public List<Cliente> findAllClientes(String table) {

        Cursor cursor;
        Cliente obj;

        List<Cliente> clienteList = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        db = getReadableDatabase();
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                obj = new Cliente(cursor.getLong(cursor.getColumnIndex(ClienteDataModel.ID)),
                        cursor.getString(cursor.getColumnIndex(ClienteDataModel.NAME)),
                        cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL))
                );
                clienteList.add(obj);
                Log.i(AppUtil.TAG, "findAllClientes: " + obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return clienteList;
    }

    @SuppressLint({"Range", "Recycle"})
    public Cliente findClienteById(String table, long id) {

        Cursor cursor;
        Cliente obj = new Cliente();
        String sql = "SELECT * FROM " + table + " WHERE id = " + id;

        db = getReadableDatabase();
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            obj.setId(cursor.getLong(cursor.getColumnIndex(ClienteDataModel.ID)));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NAME)));
            obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
        }
        Log.i(AppUtil.TAG, "findClienteById: " + obj);
        cursor.close();
        return obj;
    }

    @SuppressLint({"Range", "Recycle"})
    public List<Produto> findAllProdutos(String table) {

        Cursor cursor;
        Produto obj;

        List<Produto> produtoList = new ArrayList<>();
        String sql = "SELECT * FROM " + table;

        db = getReadableDatabase();
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                obj = new Produto(cursor.getLong(cursor.getColumnIndex(ProdutoDataModel.ID)),
                        cursor.getString(cursor.getColumnIndex(ProdutoDataModel.NAME)),
                        cursor.getString(cursor.getColumnIndex(ProdutoDataModel.FORNECEDOR))
                );
                produtoList.add(obj);
                Log.i(AppUtil.TAG, "findAllProdutos: " + obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return produtoList;
    }

    @SuppressLint({"Range", "Recycle"})
    public Produto findProdutoById(String table, long id) {

        Cursor cursor;
        Produto obj = new Produto();
        String sql = "SELECT * FROM " + table + " WHERE id = " + id;

        db = getReadableDatabase();
        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            obj.setId(cursor.getLong(cursor.getColumnIndex(ProdutoDataModel.ID)));
            obj.setNome(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.NAME)));
            obj.setFornecedor(cursor.getString(cursor.getColumnIndex(ProdutoDataModel.FORNECEDOR)));
        }
        cursor.close();
        Log.i(AppUtil.TAG, "findProdutoById: " + obj);
        return obj;
    }

}
