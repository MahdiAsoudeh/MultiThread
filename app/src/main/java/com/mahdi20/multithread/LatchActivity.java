package com.mahdi20.multithread;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class LatchActivity extends AppCompatActivity {

    private CountDownLatch latch;
    private TextView textView;
    private Button startButton;
    private StringBuffer buffer;
    private final int COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latch);

        textView = findViewById(R.id.textView);
        startButton = findViewById(R.id.startButton);
        buffer = new StringBuffer();
        latch = new CountDownLatch(COUNT);

        startButton.setOnClickListener(v -> {

            scan();
            compress();
            send();

        });


    }

    private void scan() {

        new Thread(() -> {
            setTextView("\n started scan");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setTextView("\n finished scan");
            latch.countDown();
        }).start();

    }

    private void compress() {

        new Thread(() -> {
            setTextView("\n started compress");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setTextView("\n finished compress");
            latch.countDown();
        }).start();

    }

    private void send() {

        new Thread(() -> {
            setTextView("\n started send");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setTextView("\n finished send");
        }).start();

    }


    private void setTextView(String str) {
        buffer.append(str);
        runOnUiThread(() -> {
            textView.setText(buffer);
        });
    }
}