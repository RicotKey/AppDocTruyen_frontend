package com.example.libs.Interfaces;
import com.example.libs.Model.ChuongListResponse;
import com.example.libs.Model.Message;
import com.example.libs.Model.ResponseBase;
import com.example.libs.Model.SoReponse;
import com.example.libs.Model.TheLoaiListResponse;
import com.example.libs.Model.Truyen;
import com.example.libs.Model.TruyenListResponse;
import com.example.libs.Model.TruyenTheLoaiRep;
import com.example.libs.Model.TruyenTheLoaiReponse;
import com.example.libs.Model.User;
import com.example.libs.Model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Methods {
    @GET("api/v1/Truyen")
    Call<TruyenListResponse> getTruyenList();
    @POST("api/v1/Truyen/insert")
    Call<ResponseBase> insertTruyen(@Body Truyen tr);
    @DELETE("api/v1/Truyen/{id}")
    Call<ResponseBase> deleteProduct(@Path("id") Long id);
    @PUT("api/v1/Truyen/{id}")
    Call<TruyenListResponse> updateTruyen(@Body Truyen tr);
    @GET("/api/v1/Chuong/dem/{id}")
    Call<SoReponse> countChuong(@Path("id") Long id);
    @GET("/api/v1/User")
    Call<UserResponse> getUser();
    @PUT("api/v1/User/{id}")
    Call<UserResponse> updateUser(@Path("id") Long id ,@Body User u);
    @GET("api/v1/TheLoai")
    Call<TheLoaiListResponse> getTheloaiList();
    @GET("/api/v1/TruyenTheLoai/{idtheloai}")
    Call<TruyenTheLoaiReponse> getTruyenTheloai(@Path("id")Long id);
    @GET("/api/v1/TruyenTheLoai/Tim/{id}")
    Call<TruyenTheLoaiRep> getTheLoaiTruyen(@Path("id")Long id);
    @POST("api/v1/User/insert")
    Call<UserResponse> insertUser(@Body User r);
    public static String speed = "0";
    public static String voice = "linhsan";
    @GET("/api/v1/Chuong/{id}")
    Call<ChuongListResponse> listChuong(@Path("id") Long id);
    @Headers({"api_key: bL8BR1SKeV6GnmspUCoQCp1fCzPghLRN","voice:"+voice,"speed:"+speed})
    @POST("hmi/tts/v5")
    Call<Message> SendText(@Body String text);
}