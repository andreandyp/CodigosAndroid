package io.github.andreandyp.aplicacion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PrincipalActivity extends AppCompatActivity {

    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imagen = (ImageView) findViewById(R.id.imagen);
    }

    public void cambiarHora(View view){

        switch(view.getId()){
            case R.id.dia:
                imagen.setImageResource(R.drawable.dia);
                break;
            case R.id.tarde:
                imagen.setImageResource(R.drawable.tarde);
                break;
            case R.id.noche:
                imagen.setImageResource(R.drawable.noche);
                break;
        }
    }
}
