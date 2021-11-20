package arevalosalazar.cesar.appadivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PresentacionCesar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacionCesar);
    }

    public void onPulsame(View v){
        Intent i = new Intent(this, MainActivityCesar.class);
        startActivity(i);
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(contexto, R.string.i, duracion);
        t.show();
    }

    public void Salir(View v){
        finish();
    }
}