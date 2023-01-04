package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appfairystories.adapter.TruyenAdapter;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Chuong;
import com.example.libs.Model.ChuongListResponse;
import com.example.libs.Model.SoReponse;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.TruyenListResponse;
import com.example.libs.Model.TruyenTheLoaiRep;
import com.example.libs.RetrofitClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    TextView txttacgia, txttinhtrang, txttheloai, txtNCN, txtNXB,txtmota,txttentruyen;
    ImageView imgHinh;
    ListView lischuong;
    public static Truyen truyen;
    List<Chuong> chuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txttacgia = findViewById(R.id.txtTacGia);
        txttinhtrang = findViewById(R.id.txtTinhTrang);
        txttheloai = findViewById(R.id.txtTheLoai);
        txtmota = findViewById(R.id.tvMoTa);
        txtNCN = findViewById(R.id.txtNCN);
        txtNXB = findViewById(R.id.tvNXB);
        txttentruyen = findViewById(R.id.txtTenTruyen);
        imgHinh = findViewById(R.id.imglink);
        lischuong = findViewById(R.id.listChuong);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");



        txttacgia.setText(truyen.getTacgia());
        txtNXB.setText(sdf.format(truyen.getNgaycapnhat()).toString());
        txtNCN.setText(sdf.format(truyen.getNgaycapnhat()).toString());
        txtmota.setText(truyen.getMota());
        Glide.with(this).load(truyen.getHinh()).into(imgHinh);
        txttentruyen.setText(truyen.getTentruyen());
        if(truyen.isTrangthai() == true)
        {
            txttinhtrang.setText("Hoàn thành");
        }
        else txttinhtrang.setText("Đang cập nhật");
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<TruyenTheLoaiRep> call = methods.getTheLoaiTruyen(truyen.getId());
        call.enqueue(new Callback<TruyenTheLoaiRep>() {
            @Override
            public void onResponse(Call<TruyenTheLoaiRep> call, Response<TruyenTheLoaiRep> response) {
                txttheloai.setText(String.valueOf(response.body().data));
            }

            @Override
            public void onFailure(Call<TruyenTheLoaiRep> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
        loadView();
    }
    public void loadView(){
        List<Chuong> roomList = new ArrayList<Chuong>();
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<ChuongListResponse> call = methods.listChuong(truyen.getId());
        call.enqueue(new Callback<ChuongListResponse>() {
            @Override
            public void onResponse(Call<ChuongListResponse> call, Response<ChuongListResponse> response) {
                chuong = response.body().data;
                for(int i = 0; i<response.body().data.size();i++){
                        roomList.add(response.body().data.get(i));
                }

                ArrayAdapter<Chuong> adapter = new ArrayAdapter<Chuong>(DetailActivity.this, android.R.layout.simple_list_item_1, roomList);
                lischuong.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ChuongListResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
        lischuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailActivity.this,ReadActivity.class);
                ReadActivity.listchuong=roomList;
                ReadActivity.truyen = truyen;
                ReadActivity.i = i;
                startActivity(intent);
            }
        });
    }

    public void veHome(View view) {
        Intent intent = new Intent(DetailActivity.this,Home.class);
        startActivity(intent);
    }

    public void gotoRead(View view) {
//        Intent intent = new Intent(DetailActivity.this,ReadActivity.class);
//        ReadActivity.truyen = truyen;
//        List<Chuong> roomList = new ArrayList<Chuong>();
//        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
//        Call<ChuongListResponse> call = methods.listChuong(truyen.getId());
//        call.enqueue(new Callback<ChuongListResponse>() {
//            @Override
//            public void onResponse(Call<ChuongListResponse> call, Response<ChuongListResponse> response) {
//                for(int i = 0; i<response.body().data.size();i++){
//                    roomList.add(response.body().data.get(i));
//                }
//            }
//            @Override
//            public void onFailure(Call<ChuongListResponse> call, Throwable t) {
//                Log.v("event", t.getMessage());
//            }
//        });
//        ReadActivity.listchuong = roomList;
//        ReadActivity.i =0;
//
//        startActivity(intent);
        ReadActivity.listchuong = chuong;
        Intent intent = new Intent(DetailActivity.this,ReadActivity.class);
        startActivity(intent);

    }
}