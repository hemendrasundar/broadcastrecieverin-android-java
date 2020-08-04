package com.hemendra.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(new BReciever(),intentFilter);
    }




    class BReciever extends BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){
                Toast.makeText(MainActivity.this,"airplane mode",Toast.LENGTH_LONG).show();
            }
            else if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(MainActivity.this,"charger connected",Toast.LENGTH_SHORT).show();
            }
            else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
                Toast.makeText(MainActivity.this,"charger disconnected",Toast.LENGTH_SHORT).show();
            }
            else if(intent.getAction() == Intent.ACTION_SCREEN_ON){
                Toast.makeText(MainActivity.this,"Screen on",Toast.LENGTH_SHORT).show();
            }else if(intent.getAction() == Intent.ACTION_SCREEN_OFF){
                Toast.makeText(MainActivity.this,"Screen off",Toast.LENGTH_SHORT).show();
            }

        }
    }
}