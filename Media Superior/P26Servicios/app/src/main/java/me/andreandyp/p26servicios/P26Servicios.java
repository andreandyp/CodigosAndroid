package me.andreandyp.p26servicios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
/*
* André Michel Pozos Nieto 6IM8
* API NIvel 15
* Probado en Moto E con Android 5.0 Lollipop
* Obtiene la ubicación y manda notificacion
* */
public class P26Servicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p26_servicios);
        startService(new Intent(P26Servicios.this,Localizacion.class));
    }
    public void onClick(View v){
        Button b = (Button) findViewById(R.id.detener);
        if(v == b)
            stopService(new Intent(P26Servicios.this,Localizacion.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_p26_servicios, menu);
        return true;
    }
}
