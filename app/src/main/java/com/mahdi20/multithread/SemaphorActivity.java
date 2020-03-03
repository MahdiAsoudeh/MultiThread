package com.mahdi20.multithread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Semaphore;

public class SemaphorActivity extends AppCompatActivity {

    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private ProgressBar progressBar4;
    private ProgressBar progressBar5;
    private EditText editText;
    private Button button;

    private Semaphore semaphore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaphor);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
        progressBar5 = findViewById(R.id.progressBar5);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


        button.setOnClickListener(v -> {

            progressBar1.setProgress(0);
            progressBar2.setProgress(0);
            progressBar3.setProgress(0);
            progressBar4.setProgress(0);
            progressBar5.setProgress(0);

            if (editText.getText().toString().equals("")) {
                Toast.makeText(SemaphorActivity.this, "count is empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int count = Integer.parseInt(editText.getText().toString());

            if (count < 1 || count > 5) {
                Toast.makeText(SemaphorActivity.this, "count= 1 ta 5", Toast.LENGTH_SHORT).show();
                return;
            }

            semaphore = new Semaphore(count);

            thread1();
            thread2();
            thread3();
            thread4();
            thread5();


        });

    }


    private void thread1() {

        final Thread thread = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 100; i++) {
                progressBar1.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            semaphore.release();
        });
        thread.start();

    }

    private void thread2() {

        final Thread thread = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 100; i++) {
                progressBar2.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            semaphore.release();
        });
        thread.start();

    }

    private void thread3() {

        final Thread thread = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 100; i++) {
                progressBar3.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            semaphore.release();
        });
        thread.start();

    }

    private void thread4() {

        final Thread thread = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 100; i++) {
                progressBar4.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            semaphore.release();
        });
        thread.start();

    }

    private void thread5() {

        final Thread thread = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 100; i++) {
                progressBar5.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            semaphore.release();
        });
        thread.start();

    }


}
