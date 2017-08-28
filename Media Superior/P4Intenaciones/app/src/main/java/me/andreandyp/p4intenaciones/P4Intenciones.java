package me.andreandyp.p4intenaciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
* André Michel Pozos Nieto 6IM8
* Nivel de API 15
* Probado en un Moto E con Android 4.4.4
* La aplicación la hice desde el principio. En terminos de funcionalidad es lo mismo, solo agregue el inicio de sesion
* */

public class P4Intenciones extends Activity{
    EditText usuario,clave;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4_intenciones);
        usuario = (EditText) findViewById(R.id.usuarioet);
        clave = (EditText) findViewById(R.id.claveet);
    }
    public void hue(View v){
        String usuarios, claves;
        Button entrado = (Button) findViewById(R.id.entrar);
        if(v == entrado) {
            usuarios = usuario.getText().toString();
            claves = clave.getText().toString();
            if (usuarios.equals("hue") && claves.equals("huehuehue")) {
                Intent envia = new Intent(this, Reservas.class);
                finish();
                startActivity(envia);
            } else {
                usuario.setText("");
                clave.setText("");
            }
        }
    }
}
