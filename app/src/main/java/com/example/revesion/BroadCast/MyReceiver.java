package com.example.revesion.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context, "low battary", Toast.LENGTH_SHORT).show();
        }else {
        int i= Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0);
            if (i==0){
                Toast.makeText(context, "  OFF  ", Toast.LENGTH_SHORT).show();
            }else
            Toast.makeText(context, " ON ", Toast.LENGTH_SHORT).show();
            //هاي من غيرها ولا عمرو رح يدخل ع thread

        }
        PendingResult pendingResult = goAsync();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    //بعد  ما تخلص العمليات الي في thread خلص سكر Async
                    pendingResult.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}