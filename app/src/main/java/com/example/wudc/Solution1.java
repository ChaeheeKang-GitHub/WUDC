package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.TextView;

public class Solution1 extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    ImageView nav_mediation, nav_record, nav_closer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution1);

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.solution1);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;

        TextView button = (TextView) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SolutionRecord.class);
                startActivity(intent);
            }
        });

        //하단 네비게이션
        nav_mediation = (ImageView) findViewById(R.id.nav_mediation);
        nav_record = (ImageView) findViewById(R.id.nav_record);
        nav_closer = (ImageView) findViewById(R.id.nav_closer) ;

        nav_mediation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MediationActivity.class);
                startActivity(intent);
            }
        });
        nav_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecListViewActivity.class);
                startActivity(intent);
            }
        });
        nav_closer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CloserActivity.class);
                startActivity(intent);
            }
        });
    }

}