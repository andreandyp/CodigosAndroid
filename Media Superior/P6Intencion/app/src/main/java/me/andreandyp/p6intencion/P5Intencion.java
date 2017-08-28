package me.andreandyp.p6intencion;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/*
* André Michel Pozos Nieto 6IM8
* API Nivel 15
* Probado en un Moto E con Android 4.4.4
* Version 1.0
* La app incluye todas las mejoras requeridas: uso de StreetView e intencion de email
* */

public class P5Intencion extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p5_intencion);
    }
    public void boton(View v){
        int i = v.getId();
        Intent accion;
        switch(i){
            case R.id.web:
                accion = new Intent(Intent.ACTION_VIEW, Uri.parse("http://andreandyp.me"));
                startActivity(accion);
                break;
            case R.id.llamar:
                accion = new Intent(Intent.ACTION_CALL, Uri.parse("tel:56242000"));
                startActivity(accion);
                break;
            case R.id.gmaps:
                Uri uri = Uri.parse("google.streetview:cbll=19.453659,-99.175298&cbp=1,90,,0,1.0&mz=20");
                accion = new Intent(Intent.ACTION_VIEW,uri);
                accion.setPackage("com.google.android.apps.maps");
                startActivity(accion);
                break;
            case R.id.foto:
                accion = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(accion);
                break;
            case R.id.correo:
                accion = new Intent(Intent.ACTION_SENDTO);
                accion.setData(Uri.parse("mailto:"));
                accion.putExtra(Intent.EXTRA_EMAIL, new String[] {"andreandyp@outlook.com"});
                accion.putExtra(Intent.EXTRA_TEXT, "Huehuehue");
                accion.putExtra(Intent.EXTRA_SUBJECT, "Prueba");
                startActivity(accion);
                break;
        }
    }
}
