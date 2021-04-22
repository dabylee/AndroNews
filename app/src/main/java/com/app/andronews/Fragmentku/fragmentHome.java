package com.app.andronews.Fragmentku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.andronews.R;
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

public class fragmentHome extends Fragment {

        GetJsonAll getJsonAll;
        List<News> newsList;

        String title1, desc1;
        RecyclerView rec_v1;
        MyAdapter adapku;
        GridLayoutManager gm;

        View view;
        SpinKitView spinkit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fhome, container, false);
        spinkit = view.findViewById(R.id.spin_kit);
        rec_v1 = view.findViewById(R.id.recv1);

        gm = new GridLayoutManager(getContext(), 2);
        rec_v1.setLayoutManager(gm);
        newsList = new ArrayList<>();
        adapku = new MyAdapter(getContext(), newsList);
        rec_v1.setAdapter(adapku);

        getJsonAll = RetrofitConfigToJson.getResponses();

        getJsonAll.getNewsList("id", "4fed3a8d8ad049c88f1e4ceb3adaf91b").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("berhasil",response+"");

                spinkit.setVisibility(View.VISIBLE);
                if (response.isSuccessful()){

                    spinkit.setVisibility(View.GONE);
                    newsList = response.body().getArticles();
                    title1 = newsList.get(1).getTitle();
                    desc1 =  newsList.get(1).getDesc();

                    Log.d("hasil","judul: "+title1+"");
                    Log.d("hasil","desc : "+desc1+"");

                    adapku = new MyAdapter(getContext(), newsList);
                    rec_v1.setAdapter(adapku);
                    adapku.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("gagal",t+"");
            }
        });


        return view;
    }


}
