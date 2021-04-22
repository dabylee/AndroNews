package com.app.andronews.Fragmentku;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.andronews.CatDetail;
import com.app.andronews.R;

public class fragmentCategory extends Fragment {

    View view;
    TextView c1, c2, c3, c4, c5, c6;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fcategory,container, false);


        c1 = view.findViewById(R.id.cat1);
        c2 = view.findViewById(R.id.cat2);
        c3 = view.findViewById(R.id.cat3);
        c4 = view.findViewById(R.id.cat4);
        c5 = view.findViewById(R.id.cat5);
        c6 = view.findViewById(R.id.cat6);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "business");
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "entertainment");
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "health");
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "science");
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "sport");
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getContext(), CatDetail.class);
                intent.putExtra("k6", "technology");
                startActivity(intent);
            }
        });
        return view;
    }
}
