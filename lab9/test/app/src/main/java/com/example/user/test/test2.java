package com.example.user.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class test2 extends Service {

    public IBinder onBind(Intent intent) {
        return null;
    }

        public void onCreate() {
        new Thread(){

            boolean flag = true;
            int count =0;

            @Override
            public  void run(){
                while (flag){

                    Intent i = new Intent("MyMessage");
                    i.putExtra("background_service",count);
                    sendBroadcast(i);
                    count++;
                    try{
                        Thread.sleep(1000);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }


        }.start();
    }





}
