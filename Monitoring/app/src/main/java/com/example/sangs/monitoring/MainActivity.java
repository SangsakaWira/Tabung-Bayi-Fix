package com.example.sangs.monitoring;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private Emitter.Listener data = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject data =  (JSONObject) args[0];
            final String data_1;
            try{
                data_1 = data.getString("suhu");
                Log.d("Suhu",data_1);
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                        try {
                            while (!isInterrupted()){
                                Thread.sleep(4000);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mTextview.setText(data_1);
                                    }
                                });
                            }

                        }catch (InterruptedException e){

                        }
                    }
                };
                thread.start();
            }
            catch (JSONException e){
                return;
            }
        }

    };
    private TextView mTextview;

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("https://thawing-citadel-35451.herokuapp.com/");
//              mSocket = IO.socket("http://192.168.0.17:3000");
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextview = (TextView) findViewById(R.id.data);
        mSocket.connect();
        mSocket.on("data", data);
//        Log.d("Data",data.toString());
    }


}
