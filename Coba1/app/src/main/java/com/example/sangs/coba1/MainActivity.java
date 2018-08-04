package com.example.sangs.coba1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.os.AsyncTask;
import android.widget.TextView;
//import com.ubidots.*;
//import com.ubidots.ApiClient;
//import com.ubidots.Variable;
import android.widget.Button;
import android.widget.SeekBar;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.AsyncHttpResponseHandler;
//import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar_suhu;
    private SeekBar seekBar_kelembapan;
    private TextView realtime_suhu;
    private TextView realtime_kelembapan;
    private Button button_suhu;
    private Button button_kelembapan;
    private TextView setpoint_suhu;
    private TextView setpoint_kelembapan;
    private TextView nilai_suhu;
    private TextView nilai_kelembapan;

//    private static final String BATTERY_LEVEL = "level";
//
//    private BroadcastReceiver mBatteryReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            int level = intent.getIntExtra(BATTERY_LEVEL, 0);
//
//            realtime_suhu.setText(Integer.toString(level) + "%");
//            new ApiUbidots().execute(level);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar_suhu = (SeekBar) findViewById(R.id.seekBar_suhu);
        seekBar_kelembapan = (SeekBar) findViewById(R.id.seekbar_kelembapan);
        realtime_kelembapan = (TextView) findViewById(R.id.realtime_kelembapan);
        realtime_suhu = (TextView) findViewById(R.id.realtime_suhu);
        button_suhu = (Button) findViewById(R.id.button_suhu);
        button_kelembapan = (Button) findViewById(R.id.button_kelembapan);
        setpoint_suhu = (TextView) findViewById(R.id.setpoint_suhu);
        setpoint_kelembapan = (TextView) findViewById(R.id.setpoint_kelembapan);
        nilai_suhu = (TextView) findViewById(R.id.nilai_suhu);
        nilai_kelembapan = (TextView) findViewById(R.id.nilai_kelebapan);

        seekBar_kelembapan.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nilai_kelembapan.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar_suhu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nilai_suhu.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

//    public void startURL(String URL) {
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(URL, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
//
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        registerReceiver(mBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//    }
//
//    @Override
//    protected void onStop() {
//        unregisterReceiver(mBatteryReceiver);
//        super.onStop();
//    }
//
//    public class ApiUbidots extends AsyncTask<Integer, Void, Void> {
//        private final String API_KEY = "e8811b8cb3c7d4e0c53bd9f3ca89d84e4845a407";
//        private final String VARIABLE_ID = "59958b59c03f977f6155f4ac";
//
//        @Override
//        protected Void doInBackground(Integer... params) {
//            ApiClient apiClient = new ApiClient(API_KEY);
//            Variable batteryLevel = apiClient.getVariable(VARIABLE_ID);
//
//            batteryLevel.saveValue(params[0]);
//            return null;
//        }
//    }
}
