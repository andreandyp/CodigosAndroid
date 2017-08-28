package me.andreandyp.p11animaciones;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/*
* André Michel Pozos Nieto 6IM8
* API Nivel 15
* Probado en un Moto E Android 4.4.4
* La app hace varios efectos sobre un texto
* */
public class P11Animaciones extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p11_animaciones);
        TextView texto = (TextView)findViewById(R.id.hue);
        Animation efecto = AnimationUtils.loadAnimation(this, R.anim.animacion);
        texto.startAnimation(efecto);
    }
}
