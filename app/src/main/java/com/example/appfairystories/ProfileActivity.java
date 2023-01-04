package com.example.appfairystories;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.User;
import com.example.libs.Model.UserResponse;
import com.example.libs.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    public static User user;
    EditText txtTen, txtEmail, txtPw;
    ImageView imgHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtTen = findViewById(R.id.txtTen);
        txtEmail = findViewById(R.id.txtEmail);
        txtPw = findViewById(R.id.tvPw);
        imgHinh = findViewById(R.id.imglink);

        txtTen.setText(user.getTenuser());
        txtEmail.setText(user.getEmail());
        txtPw.setText(user.getMatkhau());
        Glide.with(this).load(user.getHinh()).into(imgHinh);
    }

    public void gotoUd(View view) {
        User newUser = new User();
        newUser.setTenuser(txtTen.getText().toString());
        newUser.setHinh(imgHinh.toString());
        newUser.setEmail(txtEmail.getText().toString());
        newUser.setMatkhau(txtPw.getText().toString());
        newUser.setTrangthai(true);
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<UserResponse> call = methods.updateUser(user.getId(),newUser);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
                Toast.makeText(ProfileActivity.this, "Lưu thay đổi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileActivity.this,Home.class);
                Home.user = user;
                startActivity(intent);
            }
        });
    }

    public void gotoHome(View view) {
        Intent intent = new Intent(ProfileActivity.this,Home.class);
        Home.user = user;
        startActivity(intent);
    }

    public void gotologin(View view) {
        Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}