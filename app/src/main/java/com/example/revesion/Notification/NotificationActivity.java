package com.example.revesion.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.revesion.R;
import com.example.revesion.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {
ActivityNotificationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel channel=new NotificationChannel("channel1","channel", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager=getSystemService( NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }
                   NotificationCompat.Builder builder=new NotificationCompat.Builder(getBaseContext(),"channel1");
                   builder.setSmallIcon(R.drawable.ic_launcher_background);
                   builder.setContentTitle("Notification Title");
                   builder.setContentText("Notification Text");
                Intent intent=new Intent(getBaseContext(),NotificationActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getBaseContext(),0,intent,0);
                builder.addAction(R.drawable.ic_launcher_foreground,"Action",pi);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getBaseContext());
                managerCompat.notify(1,builder.build());


            }
        });

    }
}