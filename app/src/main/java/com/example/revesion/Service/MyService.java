package com.example.revesion.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.revesion.Notification.NotificationActivity;
import com.example.revesion.R;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    player=MediaPlayer.create(this, R.raw.corect_answer);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("channel1","channelt", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService( NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        Intent intent1=new Intent(this,MyService.class);
        intent1.setAction("stop");
        PendingIntent pi=PendingIntent.getService(getBaseContext(),0,intent1,0);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"channel1");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text");
        builder.setPriority(Notification.PRIORITY_DEFAULT);

        builder.addAction(R.drawable.ic_launcher_foreground,"Action",pi);
        startForeground(1, builder.build());
//        if (intent.getAction()!=null){
//            if (intent.getAction().equals("stop")){
//                stopSelf();
//            }
//        }
        player.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}