package com.example.revesion.Threads;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.example.revesion.R;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadActivity extends AppCompatActivity {
    com.example.revesion.databinding.ActivityThreadBinding binding;
    boolean iswhite=true;
    //القيمة الي بينتهي عندها timer
    private static final int TARGET_NUMBER = 5;
    private static final long DELAY_MILLIS = 1000; // الفاصل الزمني بالميلي ثانية
    private int counter = 0;
    private Handler handler = new Handler();
    private ProgressBar progressBar;

    private int progressValue = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= com.example.revesion.databinding.ActivityThreadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressBar = findViewById(R.id.progressBar);

        // Start a background task to update progress

        binding.btnCounter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startCounter();
                new UpdateProgressTask().execute();
//                Thread thread=new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                       if (finalI<=15){
//                           finalI++;
//                           runOnUiThread(new Runnable() {
//                               @Override
//                               public void run() {
//                                   binding.tvCounter.setText(String.valueOf(finalI));
//                               }
//                           });
//                       }
//
//
//
//
//
//
//                    }
//                });
//                thread.start();
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
    private void startCounter() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (counter < TARGET_NUMBER) {
                    counter++;
                    binding.tvCounter.setText("Counter: " + counter);
                    handler.postDelayed(this, DELAY_MILLIS);
                }
            }
        }, DELAY_MILLIS);
    }
    private class UpdateProgressTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            while (progressValue > 0) {
                progressValue--;
                publishProgress();  // Update progress
                try {
                    Thread.sleep(1000); // Simulate some work being done
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressBar.setProgress(progressValue);
        }
    }
}