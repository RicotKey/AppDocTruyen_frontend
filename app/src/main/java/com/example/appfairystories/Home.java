package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.appfairystories.adapter.TruyenAdapter;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.TruyenListResponse;
import com.example.libs.Model.User;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
GridView gdvDSTRuyen;
GridView gdvDSTruyenMoi;
TruyenAdapter adapter;
TextView lbhot,lbnew;
EditText txtTimkiem;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gdvDSTRuyen = findViewById(R.id.gdvDSTruyen);
        gdvDSTruyenMoi = findViewById(R.id.gdvDSTruyenMoi);;
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    void loadData(){
        List<Truyen> roomList = new ArrayList<Truyen>();
        List<Truyen> roomList2 = new ArrayList<Truyen>();
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<TruyenListResponse> call = methods.getTruyenList();
        call.enqueue(new Callback<TruyenListResponse>() {
            @Override
            public void onResponse(Call<TruyenListResponse> call, Response<TruyenListResponse> response) {
                for(int i = 0; i<response.body().data.size();i++){
                    roomList.add(response.body().data.get(i));
                }
                adapter = new TruyenAdapter(Home.this, 0, roomList);
                gdvDSTRuyen.setAdapter(adapter);
                gdvDSTruyenMoi.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TruyenListResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
        gdvDSTRuyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home.this,DetailActivity.class);
                DetailActivity.truyen=roomList.get(i);
                startActivity(intent);
            }
        });
    }
    public void btnSearch(View view) {
        lbnew = findViewById(R.id.lbNew);
        lbnew.setVisibility(view.INVISIBLE);
        gdvDSTruyenMoi.setVisibility(view.INVISIBLE);
        gdvDSTRuyen.setMinimumHeight(700);
        lbhot = findViewById(R.id.lbHot);
        lbhot.setText("KẾT QUẢ TÌM ĐƯỢC");
        txtTimkiem = findViewById(R.id.txtTimkiem);
        List<Truyen> roomList = new ArrayList<Truyen>();
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<TruyenListResponse> call = methods.getTruyenList();
        call.enqueue(new Callback<TruyenListResponse>() {
            @Override
            public void onResponse(Call<TruyenListResponse> call, Response<TruyenListResponse> response) {
                for(int i = 0; i<response.body().data.size();i++){
                    if(response.body().data.get(i).getTentruyen().toUpperCase().contains(txtTimkiem.getText().toString().toUpperCase())){
                        roomList.add(response.body().data.get(i));
                        System.out.print(response.body().data.get(i).getTentruyen());
                    }
                }

                adapter = new TruyenAdapter(Home.this, 0, roomList);
                gdvDSTRuyen.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TruyenListResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });

        gdvDSTRuyen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home.this,DetailActivity.class);
                DetailActivity.truyen=roomList.get(i);
                startActivity(intent);
            }
        });
    }

    public void gotoProfile(View view) {
        Intent intent = new Intent(Home.this,ProfileActivity.class);
        ProfileActivity.user = user;
        startActivity(intent);
    }


    public void gotoTheloai(View view) {
        Intent intent = new Intent(Home.this,TheLoaiActivity.class);
        startActivity(intent);
    }
}