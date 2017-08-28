package me.andreandyp.p22permisos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Datos extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);
        Toast.makeText(this, "Obteniendo tu información", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Enviandola a los servidores de Google", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Vendiendola a anunciantes", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Creando publicidad personalizada", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Listo", Toast.LENGTH_SHORT).show();
    }
}
