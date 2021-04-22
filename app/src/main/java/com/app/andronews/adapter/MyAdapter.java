package com.app.andronews.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.app.andronews.DetailBerita;
import com.app.andronews.R;
import com.app.andronews.retrofitjson.News;
import com.app.andronews.retrofitjson.NewsList;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter  {

    private Context context;
    private List<News> newsLists;
    //private String img2;

    public MyAdapter(Context context, List<News> newsLists) {
        this.context = context;
        this.newsLists = newsLists;
    }

        class MyClassAdapter extends RecyclerView.ViewHolder{

            private ImageView img2;
            private TextView title2;
            private ImageLoader imgloader2;
            private LinearLayout click2;


            public MyClassAdapter(@NonNull View itemView) {
                super(itemView);

                img2 = itemView.findViewById(R.id.img1);
                title2 = itemView.findViewById(R.id.text1);
                imgloader2 = ImageLoader.getInstance();
                click2 = itemView.findViewById(R.id.click1);

            }
        }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news, parent, false);
        return new MyClassAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyClassAdapter) holder).title2.setText(newsLists.get(position).getTitle());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ((MyClassAdapter) holder).imgloader2.init(configuration);
        ((MyClassAdapter) holder).imgloader2.displayImage(newsLists.get(position).getUrltoimage(),
                ((MyClassAdapter) holder).img2);
        Log.d("testing", newsLists.get(position).getUrl());

        ((MyClassAdapter) holder).click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "click" + newsLists.get(position).getTitle(),Toast.LENGTH_LONG);
                Log.d("tesclick","click" + newsLists.get(position).getTitle());
                Intent intent1 = new Intent(context, DetailBerita.class);
                intent1.putExtra("url", newsLists.get(position).getUrl());
                intent1.putExtra("title", newsLists.get(position).getTitle());
                intent1.putExtra("urlToImage",newsLists.get(position).getUrltoimage());
                intent1.putExtra("content",newsLists.get(position).getContent());

                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsLists.size();
    }
}
