package io.github.andreandyp.aplicacion3;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    private AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ImageView img = (ImageView) findViewById(R.id.animacion);
        img.setBackgroundResource(R.drawable.imagenes);
        animacion = (AnimationDrawable) img.getBackground();
        animacion.start();
    }

    public void alternarBaile(View view){
        Switch sw = (Switch) findViewById(R.id.bailar);
        if(sw.isChecked()){
            animacion.start();
        }else{
            animacion.stop();
        }
    }
}
