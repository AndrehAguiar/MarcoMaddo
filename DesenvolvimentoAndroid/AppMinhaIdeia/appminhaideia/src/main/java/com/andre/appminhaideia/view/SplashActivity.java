package com.andre.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.andre.appminhaideia.R;
import com.andre.appminhaideia.controller.ClienteController;
import com.andre.appminhaideia.core.AppUtil;
import com.andre.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 3;

    TextView txtAppVersion;

    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada...");
        clienteController = new ClienteController();
        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.aplicationVersion());
        trocarTela();
    }

    private void trocarTela() {

        Log.d(AppUtil.TAG, "trocarTela: Mudando de tela...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Cliente objCliente = new Cliente(
                        "André",
                        "andre@email.com",
                        "31 99999-9999",
                        39,
                        true
                );

                Log.d(AppUtil.TAG, "trocarTelas: Esperando um tempo...");

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                startActivity(trocarDeTela.putExtras(bundle));
                finish();
            }
        }, tempoDeEspera);

    }
}