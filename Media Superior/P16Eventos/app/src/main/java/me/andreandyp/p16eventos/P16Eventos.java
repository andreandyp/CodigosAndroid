package me.andreandyp.p16eventos;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/*
* André Michel Pozos Nieto 6IM8
* API Nivel 15
* Probado en Moto E con Android 5.0 Lollipop
* La aplicacion permite dibujar circulos a pantalla completa
* */
public class P16Eventos extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpecialView plantilla = new SpecialView(this);
        setContentView(plantilla);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    class SpecialView extends View {
        float x = -25;
        float y = -25;
        Path pa = new Path();
        Paint p = new Paint();
        boolean borrador = false;
        String texto = "Dibuja algo";
        public SpecialView(Context context){
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas){
            int c = Color.rgb(70,130,180);
            canvas.drawColor(Color.YELLOW);
            p.setColor(c);
            pa.addCircle(x, y, 25, Path.Direction.CW);
            canvas.drawPath(pa, p);
            p.setColor(Color.BLACK);
            p.setTextSize(30);
            canvas.drawText(texto,90,90, p);

        }
        @Override
        public boolean onTouchEvent(MotionEvent me) {
            x = me.getX();
            y = me.getY();
            invalidate();
            return true;
        }
    }
}