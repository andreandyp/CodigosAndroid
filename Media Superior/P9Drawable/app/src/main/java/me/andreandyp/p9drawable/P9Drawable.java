package me.andreandyp.p9drawable;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

/*
* André Michel Pozos Nieto 6IM8
* API nivel 15
* Probado en un Moto E con Android 4.4.4
* Es una animacion del famoso personaje Crash Bandicoot haciendo su baile
* Son 12 transiciones y 1 archivo extra para que se vea mejor
* */

public class P9Drawable extends Activity {
    AnimationDrawable animacion;
    protected void onCreate (Bundle sIS){
        super.onCreate(sIS);
        animacion = (AnimationDrawable)getResources().getDrawable(R.drawable.p9drawable);
        ImageView vista = new ImageView(this);
        vista.setBackgroundColor(Color.BLACK);
        vista.setImageDrawable(animacion);
        setContentView(vista);
    }
}
