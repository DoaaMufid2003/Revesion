package com.example.revesion.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.revesion.R;
import com.example.revesion.databinding.ActivityThreadBinding;

public class ThreadActivity extends AppCompatActivity {
    ActivityThreadBinding binding;
    boolean iswhite=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityThreadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCounter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 10000000000l; i++) {
                            int finalI = i;
                            if (finalI%6000==0){

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        binding.tvCounter.setText(String.valueOf(finalI));
                                    }
                                });
                            }
                        }
                    }
                });
                thread.start();
            }
        });
        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iswhite){
                    binding.getRoot().setBackgroundColor(Color.parseColor("#DC42F6"));
                    iswhite=false;

                }else {
                    binding.getRoot().setBackgroundColor(Color.parseColor("#FFFFFF"));
                    iswhite=true;
                }
            }
        });


    }
}