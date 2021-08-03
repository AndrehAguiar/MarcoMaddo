package com.andre.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.andre.appminhaideia.R;
import com.andre.appminhaideia.core.AppUtil;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: Tela Principal carregada...");

        Bundle bundle = getIntent().getExtras();

        Log.d(AppUtil.TAG, "onCreate: Nome  =====>>> " + bundle.getString("nome"));
        Log.d(AppUtil.TAG, "onCreate: Email =====>>> " + bundle.getString("email"));

        txtNome = findViewById(R.id.textClienteNome);
        txtNome.setText(String.format("Bem vindo, %s!!!", bundle.getString("nome")));
    }
}