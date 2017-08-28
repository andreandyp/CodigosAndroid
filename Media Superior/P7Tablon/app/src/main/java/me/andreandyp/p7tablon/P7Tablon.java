package me.andreandyp.p7tablon;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

/*
* André Michel Pozos Nieto 6IM8
* Version 1.0 API Nivel 15
* Probado en Moto E Android 4.4.4
* El programa es un dibujo de tablon
* */
public class P7Tablon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lienzo l = new Lienzo(this);
        l.setBackgroundColor(Color.WHITE);
        setContentView(l);
    }
}
