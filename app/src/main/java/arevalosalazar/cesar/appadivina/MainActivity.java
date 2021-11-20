package arevalosalazar.cesar.appadivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*private final static String STATE_NUM_ELEGIDO = "numeroOculto";
    private final static String STATE_NUM_INTENTOS= "numintentos";
    private static final String STATE_MENSAJE = "tInicio";*/

    EditText et;
    TextView tInicio;
    int numjugado;
    int numintentos = 5;
    int numeroOculto;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.vaj);
        b.setVisibility(View.INVISIBLE);
        NumOculto();
        Button btn = findViewById(R.id.vaj);
        btn.setVisibility(View.INVISIBLE);
        tInicio = findViewById(R.id.texto1);
        et = findViewById(R.id.editTextTextPersonName);
        /*
        if (savedInstanceState==null){
            jugar();
        }else{
            numeroOculto= savedInstanceState.getInt(STATE_NUM_ELEGIDO);
            numintentos = savedInstanceState.getInt(STATE_NUM_INTENTOS);
            if (numeroOculto==-1){
                FinalDePartida();
            }else{
                tInicio.setText(savedInstanceState.getString((STATE_MENSAJE)));
                actualizarIntentos();
            }
        }*/
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

    /*@Override
    public void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);
        estado.putInt(STATE_NUM_ELEGIDO,numjugado);
        estado.putInt(STATE_NUM_INTENTOS, numintentos);
        estado.putString(STATE_MENSAJE, String.valueOf(tInicio));
    }*/

    private void actualizarIntentos() {
        String mensaje;
        mensaje = getResources().getQuantityString(R.plurals.intentos, numintentos, numintentos);
        /*TextView tv;
        tv = findViewById(R.id.numIntentos);
        tv.setText(mensaje);*/
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto,mensaje,duracion);
        toast.show();
    }

    public void Probar(View v) {
        String mensaje;
        String mensajef;

        if (TextUtils.isEmpty(et.getText())) {
            Context contexto1 = getApplicationContext();
            int duracion = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(contexto1, R.string.vacio,duracion);
            toast.show();
        }else{

            numjugado = Integer.parseInt(et.getText().toString());
            if (numjugado > 0 && numjugado < 101) {
                if (numjugado < numeroOculto) {
                    et.setText("");
                    mensaje = getResources().getString(R.string.mayor);
                    mensajef = String.format(mensaje, numjugado);
                    numintentos--;
                } else if (numjugado > numeroOculto) {
                    et.setText("");
                    mensaje = getResources().getString(R.string.menor);
                    mensajef = String.format(mensaje, numjugado);
                    numintentos--;
                } else {
                    mensajef = getResources().getString(R.string.acertado);
                    FinalDePartida();
                }

                if (numintentos == 0 && numeroOculto != numjugado) {
                    mensaje = getResources().getString(R.string.Perder);
                    mensajef = String.format(mensaje, numeroOculto);
                    tInicio.setText(mensajef);
                    FinalDePartida();
                } else if (numintentos == 0 && numeroOculto == numjugado) {
                    mensajef = getResources().getString(R.string.acertado);
                    FinalDePartida();
                }
                tInicio = (TextView) findViewById(R.id.texto1);
                tInicio.setText(mensajef);
                actualizarIntentos();
            } else {
                et.setText("");
                Context contexto = getApplicationContext();
                int duracion = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(contexto, R.string.rango, duracion);
                t.show();
            }
        }


    }


    private void FinalDePartida() {

        View bJugarDeNuevo = findViewById(R.id.vaj);
        bJugarDeNuevo.setVisibility(View.VISIBLE);
        View v = findViewById(R.id.editTextTextPersonName);
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