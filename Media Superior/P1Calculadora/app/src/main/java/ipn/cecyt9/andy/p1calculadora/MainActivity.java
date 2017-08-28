package ipn.cecyt9.andy.p1calculadora;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /*
    *André Michel Pozos Nieto
    * Esta es una calculadora simple
    * incluye operaciones basicas y operaciones exponenciales
    * Fue probado en un Moto E (Android 4.4.4)
    * API nivel 14 (Android 4.0 Ice Cream Sandwich)
    *Version 1.1
    * Tiene un error: no se puede sacar la raiz con solo pulsar un numero y darle al boton de raiz
    * Es necesario insertar otro numero y luego darle al igual
    * Tambien tiene otro error: Despues de darle al igual y pulsar otro numero, se concatena con el resultado
    * */
    int num1 = 0,num2 = 0;
    double resultado;
    String op;
    boolean hue;
    //En este metodo se obtiene el valor del boton
    //Hue es una variable para evitar que la aplicacion tenga una excepcion
    public void clickbtn(View v){
        TextView tv = (TextView) findViewById(R.id.pantalla);
        if(hue) {
            tv.setText("");
            hue = false;
        }
        int id = v.getId();
        Button btn = (Button) findViewById(id);
        String n = btn.getText().toString();
        tv.setText(tv.getText()+n);
    }
    //Se obtiene el operador que se presiono
    public void operador(View v){
        int id = v.getId();
        Button btn = (Button) findViewById(id);
        op = btn.getText().toString();
        TextView tv = (TextView) findViewById(R.id.pantalla);
        num1 = Integer.parseInt(tv.getText().toString());
        hue = true;
    }
    //Se hace la operacion. En caso de que se intente dividir entre 0, el resultado sera 0 para evitar excepciones
    public void result(View v){
        TextView tv = (TextView) findViewById(R.id.pantalla) ;
        num2 = Integer.parseInt(tv.getText().toString());
        switch (op){
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "x":
                resultado = num1 * num2;
                break;
            case "/":
                if(num2 != 0)
                    resultado = num1/num2;
                else
                    resultado = 0;
                break;
            case "%":
                resultado = num1 % num2;
                break;
            case "x^n":
                resultado = Math.pow(num1,num2);
                break;
            case "raiz":
                resultado = Math.sqrt(num1);
                break;
        }
        tv.setText(Double.toString(resultado));
    }
    //Metodo para borrar los valores y lo que se muestra en el resultado
    public void borrar(View v){
        num1 = 0;
        num2 = 0;
        TextView tv = (TextView) findViewById(R.id.pantalla);
        tv.setText("");
    }
}
