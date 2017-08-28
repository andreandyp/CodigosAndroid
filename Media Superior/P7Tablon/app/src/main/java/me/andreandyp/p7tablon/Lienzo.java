package me.andreandyp.p7tablon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class Lienzo extends View {
    Paint p = new Paint();
    public Lienzo(Context context){
        super(context);
    }
    public void onDraw(Canvas canvas){
        int color = Color.rgb(255, 153, 51);
        p.setColor(color);
        canvas.drawRect(10, 10, getRight() - 10, getBottom() - 10, p);
        color = Color.rgb(255,0,0);
        p.setColor(color);
        p.setStrokeWidth(3);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(150,150,50,p);
        canvas.drawCircle(getRight() - 150,150,50,p);

        color = Color.rgb(70,130,180);
        p.setColor(color);
        RectF r = new RectF(100,250,getRight()-100,getBottom()-200);
        canvas.drawOval(r,p);
        color = Color.rgb(255, 153, 51);
        p.setColor(color);
        canvas.drawArc(r,160,220,true,p);
    }
}
