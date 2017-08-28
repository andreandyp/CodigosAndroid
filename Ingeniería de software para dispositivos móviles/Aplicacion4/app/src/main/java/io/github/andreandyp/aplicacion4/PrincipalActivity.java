package io.github.andreandyp.aplicacion4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class PrincipalActivity extends Activity {
    private RatingBar estrellas;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        estrellas = (RatingBar) findViewById(R.id.estrellas);
        resultado = (TextView) findViewById(R.id.resultado);

        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                medirAutoestima();
            }
        });
    }

    public void medirAutoestima(){
        float calif = estrellas.getRating();
        if(calif < 2.5){
            resultado.setText("Mañana será un día mejor \uD83D\uDE14");
        } else if(calif >= 2.5 && calif <= 4.0){
            resultado.setText("Puedes mejorar \uD83D\uDE09");
        } else{
            resultado.setText("¡Excelente, felicidades! \uD83D\uDE01");
        }
    }
}
