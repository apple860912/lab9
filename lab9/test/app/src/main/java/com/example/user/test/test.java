package com.example.user.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class test extends AppCompatActivity {

    private Button btn_start;
    private TextView run_time;
    private BroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn_start=(Button) findViewById(R.id.send);
        run_time=(TextView) findViewById(R.id.message);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(test.this,MyService.class);
                startService(i);
                Toast.makeText(test.this,"啟動成功",Toast.LENGTH_SHORT).show();
            }
        });
        myBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle mybundle = intent.getExtras();
                int myInt = mybundle.getInt("background_service");
            run_time.setText("後台service執行了"+myInt+"秒");
            }
        };
        IntentFilter intentFilter = new IntentFilter("MyMessage");
        registerReceiver(myBroadcastReceiver,intentFilter);
    }
}
