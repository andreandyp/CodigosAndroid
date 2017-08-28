package me.andreandyp.p18estados;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
* André Michel Pozos Nieto 6IM8
* API Nivel 15
* Probado en un Moto E con Android 5.0 Lollipop
* Esta app guarda su estado al cambiar la orientacion del dispositivo
* */

public class P18Estados extends Activity implements
            SeekBar.OnSeekBarChangeListener,
            View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
        int personas,contador = 0;
        Button fecha,hora,aumentar;
        Calendar c;
        SimpleDateFormat fechaf,horaf;
        Date fechaConv;
        String fechas,horas,nump,npersonasf;
        EditText nombre;
        TextView npersonas,ndolares;
        SeekBar barrap;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_p18_estados);
            fecha = (Button) findViewById(R.id.fecha);
            hora = (Button) findViewById(R.id.hora);
            aumentar = (Button) findViewById(R.id.aumentar);
            barrap = (SeekBar) findViewById(R.id.barrapersonas);
            nombre = (EditText) findViewById(R.id.tnombre);
            npersonas = (TextView) findViewById(R.id.npersonas);
            ndolares = (TextView) findViewById(R.id.ndolares);
            npersonasf = npersonas.getText().toString();
            npersonas.setText("Personas: 1");

            fechaf = new SimpleDateFormat(fecha.getText().toString());
            horaf = new SimpleDateFormat("HH:mm");
            c = Calendar.getInstance();

            Date fechar = c.getTime();
            fechas = fechaf.format(fechar);
            fecha.setText(fechas);
            horas = horaf.format(fechar);
            hora.setText(horas);
            fecha.setOnClickListener(this);
            hora.setOnClickListener(this);
            barrap.setOnSeekBarChangeListener(this);
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            c = Calendar.getInstance();
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,month);
            c.set(Calendar.DAY_OF_MONTH,day);

            fechas = fechaf.format(c.getTime());
            fecha.setText(fechas);
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            nump = String.format(npersonasf,barrap.getProgress() + 1);
            personas = barrap.getProgress() + 1;
            npersonas.setText(nump);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onTimeSet(TimePicker view, int horac, int minutos) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, horac);
            calendar.set(Calendar.MINUTE, minutos);

            horas = horaf.format(calendar.getTime());
            hora.setText(horas);
        }

        @Override
        public void onClick(View v) {
            Calendar cal;
            int i = v.getId();
            switch (i){
                case R.id.fecha:
                    cal = parseCalendar(fecha.getText(), fechaf);
                    new DatePickerDialog(this, this, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
                            cal.get(Calendar.DAY_OF_MONTH)).show();
                    break;
                case R.id.hora:
                    cal = parseCalendar(hora.getText(), horaf);
                    new TimePickerDialog(this, this,cal.get(Calendar.HOUR_OF_DAY),
                            cal.get(Calendar.MINUTE), true).show();
                    break;
                case R.id.aumentar:
                    contador++;
                    ndolares.setText(Integer.toString(contador));
                    break;
                case R.id.reservar:
                    Intent envia = new Intent(this, Actividad2.class);
                    Bundle datos = new Bundle();
                    datos.putString("nombre", nombre.getText().toString());
                    datos.putInt("personas", personas);
                    datos.putInt("dolares", contador);
                    datos.putString("fecha", fechas);
                    datos.putString("hora", horas);
                    envia.putExtras(datos);
                    finish();
                    startActivity(envia);
                    break;
            }
        }
        private Calendar parseCalendar(CharSequence text,
                                       SimpleDateFormat fechaFormat2) {
            try {
                fechaConv = fechaFormat2.parse(text.toString());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaConv);
            return calendario;
        }
    @Override
    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        Toast.makeText(this, "Guardar", Toast.LENGTH_SHORT).show();
        estado.putString("nombre", nombre.getText().toString());
        estado.putInt("personas", personas);
        estado.putInt("dolares", contador);
        estado.putString("fecha", fechas);
        estado.putString("hora", horas);
    }

    @Override
    protected void onRestoreInstanceState(Bundle hestado) {
        super.onRestoreInstanceState(hestado);
        Toast.makeText(this, "Restaurar", Toast.LENGTH_SHORT).show();
        nombre.setText(hestado.getString("nombre"));
        barrap.setProgress(hestado.getInt("personas"));
        nump = String.format(npersonasf,hestado.getInt("personas"));
        npersonas.setText(nump);
        ndolares.setText(Integer.toString(hestado.getInt("dolares")));
        fecha.setText(hestado.getString("fecha"));
        hora.setText(hestado.getString("hora"));
    }
}
