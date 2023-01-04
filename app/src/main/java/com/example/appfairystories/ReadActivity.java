package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.libs.Model.Chuong;
import com.example.libs.Model.Truyen;

import java.util.List;

public class ReadActivity extends AppCompatActivity {
    public static List<Chuong> listchuong;
    public static int i = 0;
    TextView txtnoidung, txtchuong;
    Button btnluichuong, btntienchuong;
    public static Truyen truyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Chuong chuong = listchuong.get(i);
        txtchuong = findViewById(R.id.txtChuong);
        txtnoidung = findViewById(R.id.txtnoidung);
        btnluichuong = findViewById(R.id.btnPre);
        btntienchuong = findViewById(R.id.btnNext);
        txtchuong.setText(chuong.toString());
        txtnoidung.setText(chuong.getNoidung());
        if (i==0){
            btnluichuong.setVisibility(View.INVISIBLE);
        }

        if (i==listchuong.size()-1){
            btntienchuong.setVisibility(View.INVISIBLE);
        }
    }

    public void gotoChapTrc(View view) {
        i=i-1;
        if (i==0){
            btnluichuong.setVisibility(View.INVISIBLE);
        }
        else{
            btntienchuong.setVisibility(View.VISIBLE);
        }
        Chuong chuong = listchuong.get(i);
        txtchuong.setText(chuong.toString());
        txtnoidung.setText(chuong.getNoidung());
    }

    public void gotoChapSau(View view) {
        i=i+1;
        if (i==listchuong.size()-1){
            btntienchuong.setVisibility(View.INVISIBLE);
        }
        else{
            btnluichuong.setVisibility(View.VISIBLE);
        }
        Chuong chuong = listchuong.get(i);
        txtchuong.setText(chuong.toString());
        txtnoidung.setText(chuong.getNoidung());
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

    public void gotoHome(View view) {
        Intent intent = new Intent(ReadActivity.this,Home.class);
        startActivity(intent);
    }

    public void gotoListen(View view) {
      ListenActivity.chuong = listchuong.get(i);
        Intent intent = new Intent(ReadActivity.this, ListenActivity.class);
        startActivity(intent);
    }

    public void gotoChapter(View view) {
        Intent intent = new Intent(ReadActivity.this, ChapterActivity.class);
        ChapterActivity.listchuong = listchuong;
        startActivity(intent);
    }
}