package com.example.revesion.BroadCast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.example.revesion.databinding.ActivityMain4Binding;

public class Main4Activity extends AppCompatActivity {
ActivityMain4Binding binding;
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        receiver=new MyReceiver();
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_LOW));
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
