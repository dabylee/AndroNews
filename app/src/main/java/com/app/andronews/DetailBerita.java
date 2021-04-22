package com.app.andronews;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DetailBerita extends AppCompatActivity {

    String title, image, content, url3a;
    TextView title_3;
    ImageView image_3;
    WebView web_3;
    ImageLoaderConfiguration conf;
    ImageLoader loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_berita);
        title = getIntent().getStringExtra("title");
        title_3 = findViewById(R.id.text3);
        image_3 = findViewById(R.id.image3);
        web_3 = findViewById(R.id.web3);

        //Log.d("tes get", title);
        loader = ImageLoader.getInstance();
        url3a = getIntent().getStringExtra("url");
/*        image = getIntent().getStringExtra("urlToImage");
        content = getIntent().getStringExtra("content");

        title_3.setText(title);
        conf = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        loader.init(conf);
        loader.displayImage(image, image_3);

        web_3.loadData(content, "text/html", "utf8");
        web_3.setWebViewClient(new WebViewClient());*/
            Log.d("hasil url",url3a+"");
            web_3.loadUrl(url3a);
            web_3.setWebViewClient(new WebViewClient());
    }
}
