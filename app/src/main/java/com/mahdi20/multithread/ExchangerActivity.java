package com.mahdi20.multithread;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class ExchangerActivity extends AppCompatActivity {

    private Exchanger<String> exchanger;
    private TextView textView;
    private StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchanger);

        textView = findViewById(R.id.textView);
        exchanger = new Exchanger<>();
        buffer = new StringBuffer();

        Thread thread1 = new Thread(() -> {

            try {
                String msg = exchanger.exchange("Mahdi");
                Log.i("ZZZZZZZ", "thread1: msg: " + msg);
                buffer.append("\n thread1: msg: " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setTextView();


        });
        thread1.start();


        Thread thread2 = new Thread(() -> {

            try {
                String msg = exchanger.exchange("Ali");
                Log.i("ZZZZZZZ", "thread2: msg: " + msg);
                buffer.append("\n thread2: msg: " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            setTextView();

        });
        thread2.start();


    }

    private void setTextView() {
        runOnUiThread(() -> textView.setText(buffer));
    }


}
