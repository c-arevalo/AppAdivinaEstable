package arevalosalazar.cesar.appadivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tInicio;
    int numjugado;
    int numintentos = 5;
    int numeroOculto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumOculto();
        Button btn = findViewById(R.id.vaj);
        btn.setVisibility(View.INVISIBLE);
        et = findViewById(R.id.editTextTextPersonName);
        tInicio = findViewById(R.id.texto1);
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i == keyEvent.KEYCODE_ENTER)) {
                    return true;
                } else return false;
            }
        });
        actualizarIntentos();

    }

    private void actualizarIntentos() {
        String mensaje;
        mensaje = getResources().getQuantityString(R.plurals.intentos, numintentos, numintentos);
        TextView tv;
        tv = findViewById(R.id.numIntentos);
        tv.setText(mensaje);
    }

    public void Probar(View v) {
        String mensaje;
        String mensajef = "";
        for (int i = 5; i > 0; i--) {
            numjugado = Integer.parseInt(et.getText().toString());
            if (numjugado < numeroOculto) {
                mensaje = getResources().getString(R.string.mayor);
                mensajef = String.format(mensaje, numjugado);
                numintentos--;
            } else if (numjugado > numeroOculto) {
                mensaje = getResources().getString(R.string.menor);
                mensajef = String.format(mensaje, numjugado);
                numintentos--;
            } else {
                mensajef = getResources().getString(R.string.acertado);
            }

            if (numintentos == 0 && numeroOculto != numjugado) {
                mensaje = getResources().getString(R.string.Perder);
                mensajef = String.format(mensaje, numeroOculto);
                tInicio.setText(mensajef);
            }
        }
        tInicio = (TextView) findViewById(R.id.texto1);
        tInicio.setText(mensajef);
        actualizarIntentos();

    }

    private void FinalDePartida() {
        View bJugarDeNuevo = findViewById(R.id.vaj);
        bJugarDeNuevo.setVisibility(View.VISIBLE);
        View v = findViewById(R.id.texto1);
        v.setVisibility(View.INVISIBLE);
        v = findViewById(R.id.editTextTextPersonName);
        v.setVisibility(View.INVISIBLE);
        v = findViewById(R.id.button);
        v.setVisibility(View.INVISIBLE);
        v = findViewById(R.id.textView3);
        v.setVisibility(View.INVISIBLE);
        v = findViewById(R.id.numIntentos);
        v.setVisibility(View.INVISIBLE);


    }

    public void NumOculto() {
        Random dado = new Random();
        numeroOculto = dado.nextInt(100) + 1;
        numintentos = 5;
        actualizarIntentos();
    }

    public void jugar(View v) {
        NumOculto();
        View bJugarDeNuevo = findViewById(R.id.vaj);
        bJugarDeNuevo.setVisibility(View.INVISIBLE);
        v = findViewById(R.id.texto1);
        v.setVisibility(View.VISIBLE);
        v = findViewById(R.id.editTextTextPersonName);
        v.setVisibility(View.VISIBLE);
        v = findViewById(R.id.button);
        v.setVisibility(View.VISIBLE);
        v = findViewById(R.id.textView3);
        v.setVisibility(View.VISIBLE);
        v = findViewById(R.id.numIntentos);
        v.setVisibility(View.VISIBLE);

        tInicio.setText(R.string.adivina);

    }
}