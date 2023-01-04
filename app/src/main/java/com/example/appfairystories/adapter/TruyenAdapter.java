package com.example.appfairystories.adapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.appfairystories.R;
import com.example.libs.Interfaces.Methods;
import com.example.libs.Model.SoReponse;
import com.example.libs.Model.Truyen;
import com.example.libs.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruyenAdapter extends ArrayAdapter<Truyen>{

    private Context ct;
    private ArrayList<Truyen> arr;
    public TruyenAdapter(Context context, int resource, List<Truyen> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }

        if (arr.size()>0){
            TextView tenTenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenChapter = convertView.findViewById(R.id.txvChapter);
            ImageView tenLink = convertView.findViewById(R.id.imglink);
            Truyen truyen = this.arr.get(position);
            Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
            Call<SoReponse> call = methods.countChuong(truyen.getId());
            call.enqueue(new Callback<SoReponse>() {
                @Override
                public void onResponse(Call<SoReponse> call, Response<SoReponse> response) {
                    tenChapter.setText("Chap "+String.valueOf(response.body().data));
                }

                @Override
                public void onFailure(Call<SoReponse> call, Throwable t) {
                    Log.v("event", t.getMessage());
                }
            });


            tenTenTruyen.setText(truyen.getTentruyen());
            Glide.with(this.ct).load(truyen.getHinh()).into(tenLink);
        }
        return convertView;
    }
}
