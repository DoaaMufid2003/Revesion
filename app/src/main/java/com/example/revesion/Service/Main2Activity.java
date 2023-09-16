package com.example.revesion.Service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.revesion.R;
import com.example.revesion.databinding.ActivityMain2Binding;
import com.example.revesion.databinding.ActivityMainBinding;

public class Main2Activity extends AppCompatActivity {
ActivityMain2Binding binding;
boolean isplay=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MyService.class);
               if (!isplay){
                   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                       startForegroundService(intent);
                   }else {
                       ContextCompat.startForegroundService(getBaseContext(),intent);
                   }
                   binding.btnPlay.setText("Stop");
                   isplay=true;
               }
               else {
                   stopService(intent);
                   binding.btnPlay.setText("play");
                   isplay=false;
               }
            }
        });
    }
}