package primeiro.cliente.cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class TelaSplashActivity extends AppCompatActivity {

    private static final String TAG = "PRIMEIRO_CLIENTE";
    int tempoDeEspera = 1000 * 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        Log.d(TAG, "\n=========>>>>>>>>> onCreated: Tela Splash carregada...");

        trocarTela();
    }

    private void trocarTela() {

        Log.d(TAG, "\n=========>>>>>>>>> onCreated: Mudando de tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "\n=========>>>>>>>>> onCreated: Tela Splash aguardando...");

                Intent trocarDeTela = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}