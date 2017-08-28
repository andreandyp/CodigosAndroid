package io.github.andreandyp.aplicacion2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends Activity {
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        texto = (TextView) findViewById(R.id.texto);
        savedInstanceState = this.getIntent().getExtras();

        texto.setText("¡Hola "+savedInstanceState.getString("nombre")+"!");
    }
}
