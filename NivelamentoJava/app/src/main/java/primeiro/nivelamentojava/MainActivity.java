package primeiro.nivelamentojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import primeiro.nivelamentojava.model.Cliente;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "NIVELAMENTO_JAVA_1";
    Cliente objCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCliente = new Cliente(
                "André",
                "email@email.com",
                "(31) 99110-9910",
                39,
                true);

        Log.i(TAG, "onCreate: objeto Cliente" + objCliente.toString());
    }
}