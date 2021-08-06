package app.andre.appminhaideiadb.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.andre.appminhaideiadb.R;
import app.andre.appminhaideiadb.api.AppUtil;
import app.andre.appminhaideiadb.controller.ClienteController;
import app.andre.appminhaideiadb.controller.ProdutoController;
import app.andre.appminhaideiadb.model.Cliente;
import app.andre.appminhaideiadb.model.Produto;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente objCliente;
    Cliente objCliente1;

    ProdutoController produtoController;
    Produto objProduto;
    Produto objProduto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(AppUtil.TAG, "onCreate: Rodando...");

        clienteController = new ClienteController(getApplicationContext());
        produtoController = new ProdutoController(getApplicationContext());

        objCliente = new Cliente("André", "andre@email.com");
        objCliente1 = new Cliente("Augusto", "augusto@email.com");
        if (clienteController.incluir(objCliente) && clienteController.incluir(objCliente1)) {
            Toast.makeText(MainActivity.this, "Cliente " +
                    objCliente.getNome() + ", inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "Cliente " +
                    objCliente.getNome() + ", não foi inserido com sucesso!", Toast.LENGTH_SHORT).show();
        }

        objProduto = new Produto("HD 1TB SSD", "DELL");
        objProduto1 = new Produto("HD 1TB SSD", "Samsung");
        if (produtoController.incluir(objProduto) && produtoController.incluir(objProduto1) ) {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", inserido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", não foi inserido com sucesso!", Toast.LENGTH_SHORT).show();
        }

        clienteController.listar();
        produtoController.listar();

        Log.d(AppUtil.TAG, "onCreate: Alterando o objCliente de ===> " +
                objCliente.getNome() + " <==> " + objCliente.getEmail());
        objCliente.setId(1L);
        objCliente.setNome("André Aguiar");
        objCliente.setEmail("andreaguiar@email.com");
        Log.d(AppUtil.TAG, "onCreate: Alterando o objCliente para ===> "
                + objCliente.getNome() + " <==> " + objCliente.getEmail());

        Log.d(AppUtil.TAG, "onCreate: Alterando o objProduto de ===> " +
                objProduto.getNome() + " <==> " + objProduto.getFornecedor());
        objProduto.setId(1L);
        objProduto.setNome("HD 500GB SSD");
        objProduto.setFornecedor("SAMSUNG");
        Log.d(AppUtil.TAG, "onCreate: Alterando o objProduto para ===> " +
                objProduto.getNome() + " <==> " + objProduto.getFornecedor());

        if (clienteController.alterar(objCliente)) {
            Toast.makeText(MainActivity.this, "Produto " +
                    objCliente.getNome() + ", alterado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Produto " +
                    objCliente.getNome() + ", não foi alterado com sucesso!", Toast.LENGTH_SHORT).show();
        }

        if (produtoController.alterar(objProduto)) {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", alterado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", não foi alterado com sucesso!", Toast.LENGTH_SHORT).show();
        }

        clienteController.findById(1L);
        produtoController.findById(1L);

        if (clienteController.deletar(1L)) {
            Toast.makeText(MainActivity.this, "Cliente " +
                    objCliente.getNome() + ", removido com sucesso!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "Cliente " +
                    objCliente.getNome() + ", não foi removido com sucesso!", Toast.LENGTH_SHORT).show();
        }

        if (produtoController.deletar(1L)) {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", removido com sucesso!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(MainActivity.this, "Produto " +
                    objProduto.getNome() + ", não foi removido com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }
}