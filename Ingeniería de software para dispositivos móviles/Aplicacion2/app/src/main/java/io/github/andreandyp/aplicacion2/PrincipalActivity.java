package io.github.andreandyp.aplicacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        texto = (EditText) findViewById(R.id.texto);
    }

    public void ponerNombre(View view){
        String nombre = "";
        nombre = texto.getText().toString();

        Intent saludar = new Intent(this,SaludoActivity.class);
        Bundle datos = new Bundle();
        datos.putString("nombre",nombre);
        saludar.putExtras(datos);
        finish();
        startActivity(saludar);
    }
}
