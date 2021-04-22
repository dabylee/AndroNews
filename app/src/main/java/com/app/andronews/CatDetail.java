package com.app.andronews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.andronews.adapter.MyAdapter;
import com.app.andronews.retrofitconfig.GetJsonAll;
import com.app.andronews.retrofitconfig.RetrofitConfigToJson;
import com.app.andronews.retrofitjson.News;
import com.app.andronews.retrofitjson.NewsList;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatDetail extends AppCompatActivity {

    TextView judulcat;
    String kiriman1;

    GetJsonAll getJsonAll;
    List<News> newsC;
    String titleC;
    RecyclerView rec2;
    GridLayoutManager gm;
    MyAdapter adap2;
    SpinKitView spinKit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorydetail);

        //judulcat = findViewById(R.id.judulcat);
        rec2 = findViewById(R.id.recv2);
        gm = new GridLayoutManager(this, 1);
        rec2.setLayoutManager(gm);
        adap2 = new MyAdapter(this, newsC);
        spinKit = findViewById(R.id.spin_kit);

        kiriman1 = getIntent().getStringExtra("k6");
        //judulcat.setText(kiriman1);

        newsC = new ArrayList<>();
        getJsonAll = RetrofitConfigToJson.getResponses();

        tampilkancat(kiriman1);

    }

    private void tampilkancat(String category){
        getJsonAll.getNewslistCategory("id", category, "4fed3a8d8ad049c88f1e4ceb3adaf91b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {

                spinKit.setVisibility(View.VISIBLE);
                if (response.isSuccessful()){
                    spinKit.setVisibility(View.GONE);
                    newsC = response.body().getArticles();
                    //titleC = newsC.get(0).getTitle();

                    //Log.d("hasil", "cat=" + category + " " + titleC);
                    adap2 = new MyAdapter(getApplicationContext(), newsC);
                    rec2.setAdapter(adap2);
                    adap2.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal", "gagal") ;
            }
        });


    }

}
