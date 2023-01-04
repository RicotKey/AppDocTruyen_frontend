package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("event","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("event","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("event","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v("event","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("event","onResume");
    }


    public void Trangchu(View view) {
        Intent intent = new Intent(MainActivity.this,Home.class);
        startActivity(intent);
    }
    public void Login(View view) {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    public void formDetail(View view) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }

    public void gotoListen(View view) {
        Intent intent = new Intent(MainActivity.this,ListenActivity.class);
        startActivity(intent);
    }
}