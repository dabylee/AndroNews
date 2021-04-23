package com.app.andronews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.app.andronews.Fragmentku.fragmentAbout;
import com.app.andronews.Fragmentku.fragmentCategory;
import com.app.andronews.Fragmentku.fragmentHome;
import com.app.andronews.adapter.MyAdapter;
import com.app.andronews.retrofitconfig.GetJsonAll;
import com.app.andronews.retrofitconfig.RetrofitConfigToJson;
import com.app.andronews.retrofitjson.News;
import com.app.andronews.retrofitjson.NewsList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bttm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttm = findViewById(R.id.bnview);
        bttm.setOnNavigationItemSelectedListener(this);

        fragmentClick(new fragmentHome());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int userID = item.getItemId();
        Fragment fragmentt = null;
        switch (userID){
            case R.id.menuhome:
                fragmentt = new fragmentHome();
                break;
            case R.id.menucat:
                fragmentt = new fragmentCategory();
                break;
            case R.id.menuabout:
                fragmentt = new fragmentAbout();
                break;

        }

        return fragmentClick(fragmentt);
    }

    private boolean fragmentClick(Fragment fragment) {

        if (fragment != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragment).commit();

        }
        return false;

    }
}