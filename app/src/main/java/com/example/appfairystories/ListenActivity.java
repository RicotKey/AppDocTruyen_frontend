package com.example.appfairystories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.Chuong;
import com.example.libs.Model.Message;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListenActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    int index = 1;
    public static Chuong chuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
    }
    private Void getAudio(String text){

        List<String>  listString = listChuoi(chuong.getNoidung());
        Methods methods = RetrofitClient.getRetrofitInstanceAudio().create(Methods.class);
        Call<Message> call = methods.SendText(text.replace("\r"," "));
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                try {
                    playAudio(ListenActivity.this,response.body().async);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            mp.release();
                            if(index<listString.size())
                            {
                                getAudio(listString.get(index));
                                index++;
                            }


                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.v("event", t.getMessage());
            }

        });

        return null;
    }
    private void playAudio(Context context, String url) throws Exception {

        mediaPlayer = MediaPlayer.create(context, Uri.parse(url));
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mediaPlayer.start();

    }
    private void releaseMediaPlayer()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        List<String>  listString = listChuoi(chuong.getNoidung());
        getAudio(listString.get(0));




    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    public static List<String> listChuoi(String chuoi){
        List<String> listChuoi = new ArrayList<>();
        char[] arrayList = chuoi.toCharArray();
        int begin = 0;
        int end = 500;
        if(arrayList.length<500)
        {
            listChuoi.add(chuoi);
        }
        else {
            for (int i = begin;i<arrayList.length/500;i++)
            {
                listChuoi.add(chuoi.substring(begin,end));
                begin = end;
                end = end+500;
            }
            listChuoi.add(chuoi.substring(begin,arrayList.length));
        }

        return listChuoi;
    }

    public void pauseAction(View v) {
        mediaPlayer.pause();
    }
    public void playAction(View v) {
        mediaPlayer.start();
    }
    public void stopAction(View v) {
        mediaPlayer.stop();
    }

}