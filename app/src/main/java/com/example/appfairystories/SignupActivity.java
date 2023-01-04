package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.ResponseBase;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.User;
import com.example.libs.Model.UserResponse;
import com.example.libs.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    EditText txtten, txtmk, txtnlmk,txtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtten = findViewById(R.id.txtten);
        txtmk = findViewById(R.id.txtPassword);
        txtnlmk = findViewById(R.id.txtRePassword);
        txtemail = findViewById(R.id.txtEmail);
    }


    public void gotoDangKy(View view) {
        User newUser = new User();
        newUser.setTenuser(txtten.getText().toString());
        newUser.setEmail(txtemail.getText().toString());
        newUser.setHinh("https://i.truyenvua.com/ebook/190x247/dai-vuong-tha-mang_1576200425.jpg?gf=hdfgdfg&mobile=2");
        if(txtmk.getText().toString().equals(txtnlmk.getText().toString())){
            newUser.setMatkhau(txtmk.getText().toString());
        }
        newUser.setTrangthai(true);
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<UserResponse> call = methods.insertUser(newUser);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(SignupActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
    }

    public void gotoDangNhap(View view) {
        Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}