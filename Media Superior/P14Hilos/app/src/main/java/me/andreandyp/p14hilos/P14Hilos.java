package me.andreandyp.p14hilos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/*
* André Michel Pozos Nieto 6IM8
* API Nivel 16
* Probado en Moto E Lollipop 5.0.2
* El programa calcula el numero de Fibonacci segun una posicion
* */

public class P14Hilos extends Activity {
    TextView resultado;
    EditText numero;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p14_hilos);
        resultado = (TextView) findViewById(R.id.resultado);
    }
    public void calcular(View v){
        numero = (EditText) findViewById(R.id.numero);
        n = Integer.parseInt(numero.getText().toString());
        hilo h = new hilo();
        h.execute(n);
    }
class hilo extends AsyncTask<Integer,Integer,Integer>{
    ProgressDialog progreso;
    int ntotal;
    @Override
    protected void onPreExecute() {
        progreso = new ProgressDialog(P14Hilos.this);
        progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progreso.setMessage("Calculando...");
        progreso.setCancelable(false);
        progreso.setMax(n);
        progreso.setProgress(0);
        progreso.show();
    }
    @Override
    protected Integer doInBackground(Integer... n) {
        int n1 = 1,n2 = 0,n3 = 0,i;
        for(i = 1; i <= n[0]; ++i){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            SystemClock.sleep(500);
            publishProgress(i);
            }
        ntotal = n3;
        return ntotal;
        }
    @Override
    protected void onProgressUpdate(Integer... h){
        progreso.setProgress(h[0]);
        }
    @Override
    protected void onPostExecute(Integer ntotal) {
        progreso.dismiss();
        resultado.append("\n"+ntotal);
        }
    }
}