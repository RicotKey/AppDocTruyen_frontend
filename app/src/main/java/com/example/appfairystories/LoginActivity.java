package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appfairystories.adapter.TruyenAdapter;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.TruyenListResponse;
import com.example.libs.Model.User;
import com.example.libs.Model.UserResponse;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText txttenuser, txtmatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Login(View view) {
        txttenuser = findViewById(R.id.lbUserName);
        txtmatkhau = findViewById(R.id.et_password);

        List<User> userList = new ArrayList<User>();

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<UserResponse> call = methods.getUser();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                int flag = 0;
                for(int i = 0; i<response.body().data.size();i++){
                    if(txttenuser.getText().toString().equals(response.body().data.get(i).getTenuser()) && txtmatkhau.getText().toString().equals(response.body().data.get(i).getMatkhau())){
                        Intent intent = new Intent(LoginActivity.this,Home.class);
                        Home.user = response.body().data.get(i);
                        startActivity(intent);
                        flag = 1;
                    }
                }
                if(flag == 0){
                    Toast.makeText(LoginActivity.this, "Mật khẩu hoặc tài khoản sai", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("event", t.getMessage());
            }
        });
    }

    public void gotoSignup(View view) {
        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}