package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.libs.Model.Chuong;
import com.example.libs.Model.Truyen;

import java.util.List;

public class ChapterActivity extends AppCompatActivity {
    public static List<Chuong> listchuong;
    ListView lischuong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        ArrayAdapter<Chuong> adapter = new ArrayAdapter<Chuong>(ChapterActivity.this, android.R.layout.simple_list_item_1, listchuong);
        lischuong = findViewById(R.id.lsChuong);
        lischuong.setAdapter(adapter);
        lischuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChapterActivity.this,ReadActivity.class);
                ReadActivity.listchuong= listchuong;
                ReadActivity.i = i;
                startActivity(intent);
            }
        });
    }

    public void gotoDetail(View view) {
        Intent intent = new Intent(ChapterActivity.this,DetailActivity.class);
        startActivity(intent);
    }

}