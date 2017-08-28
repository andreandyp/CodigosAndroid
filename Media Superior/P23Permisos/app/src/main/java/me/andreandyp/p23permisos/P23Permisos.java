package me.andreandyp.p23permisos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/*
* André Michel Pozos Nieto 6IM8
* API Nivel 15
* Probado en un Moto E con Android 5.0 Lollipop
* Esta app sirve para abrir otra que necesita permisos especiales
* */
public class P23Permisos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p23_permisos);
    }
    public void abrir(View v){
        Button b = (Button) findViewById(R.id.abrir);
        if(v == b){
            Intent accion = new Intent();
            accion.setClassName("me.andreandyp.p22permisos","me.andreandyp.p22permisos.Datos");
            startActivity(accion);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_p23_permisos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
