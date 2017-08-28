package me.andreandyp.p26servicios;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class Localizacion extends Service {
    NotificationManager nm;
    Criteria cr;
    LocationManager lm;
    Location ubicacion;
    @Override
    public void onCreate(){
        cr = new Criteria();
        cr.setAccuracy(Criteria.ACCURACY_COARSE);
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        ubicacion = lm.getLastKnownLocation(lm.getBestProvider(cr, true));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intenc, int flags, int idArranque) {
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this);
        notif.setContentTitle("Ubicandote...");
        notif.setContentText("Estas en...");
        notif.setSubText("Estas en: " + ubicacion.toString());
        notif.setWhen(System.currentTimeMillis());
        notif.setSmallIcon(R.drawable.abc_btn_check_material);
        PendingIntent intencionPendiente = PendingIntent.getActivity(
                this, 0, new Intent(this, P26Servicios.class), 0);
        notif.setContentIntent(intencionPendiente);
        nm.notify(1, notif.build());
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        nm.cancel(1);
        Toast.makeText(this, "Se detuvo el servicio",Toast.LENGTH_SHORT).show();
    }
}
