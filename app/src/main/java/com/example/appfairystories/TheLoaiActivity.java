package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appfairystories.adapter.TruyenAdapter;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.TruyenListResponse;
import com.example.libs.Model.TruyenTheLoaiReponse;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheLoaiActivity extends AppCompatActivity {
    public static TruyenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
    }

    public void gotokiemhiep(View view) {
        Intent intent = new Intent(TheLoaiActivity.this,Home.class);
        startActivity(intent);
        List<Truyen> roomList = new ArrayList<Truyen>();
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<TruyenTheLoaiReponse> call = methods.getTruyenTheloai(Long.valueOf(1));
        call.enqueue(new Callback<TruyenTheLoaiReponse>() {
            @Override
            public void onResponse(Call<TruyenTheLoaiReponse> call, Response<TruyenTheLoaiReponse> response) {
                for(int i = 0; i<response.body().data.size();i++){
                    roomList.add(response.body().data.get(i));
                }
                adapter = new TruyenAdapter(TheLoaiActivity.this, 0, roomList);
            }

            @Override
            public void onFailure(Call<TruyenTheLoaiReponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
    }
}