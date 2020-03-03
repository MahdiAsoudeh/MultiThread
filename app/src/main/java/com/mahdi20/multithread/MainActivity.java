package com.mahdi20.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Semaphore;

public class MainActivity extends AppCompatActivity {


    private Button semaphorButton;
    private Button countDownLatchButton;
    private Button exchangerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        semaphorButton = findViewById(R.id.semaphorButton);
        countDownLatchButton = findViewById(R.id.countDownLatchButton);
        exchangerButton = findViewById(R.id.exchangerButton);


        semaphorButton.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), SemaphorActivity.class);
            startActivity(intent);

        });


        countDownLatchButton.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), LatchActivity.class);
            startActivity(intent);

        });


        exchangerButton.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), ExchangerActivity.class);
            startActivity(intent);

        });

    }


}
