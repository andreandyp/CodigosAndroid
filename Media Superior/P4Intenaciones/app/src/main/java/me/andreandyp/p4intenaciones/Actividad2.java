package me.andreandyp.p4intenaciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2 extends Activity{
    String nombre,fecha,hora;
    int personas;
    protected void onCreate(Bundle sIS) {
        super.onCreate(sIS);
        setContentView(R.layout.actividad2);

        TextView hue = (TextView) findViewById(R.id.texto);
        sIS = this.getIntent().getExtras();
        nombre = sIS.getString("nombre");
        personas = sIS.getInt("personas");
        fecha = sIS.getString("fecha");
        hora = sIS.getString("hora");
        hue.setText("Nombre: "+nombre+"\n"+
                    "Personas: "+personas+"\n"+
                    "Fecha: "+fecha+"\t"+"Hora: "+hora);
    }
    public void volver(View v) {
        Button hue = (Button) findViewById(R.id.btn);
        if(v == hue) {
            Intent envia = new Intent(this, Reservas.class);
            finish();
            startActivity(envia);
        }
    }
}
