package com.example.wudc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CloserActivity extends AppCompatActivity {

    ImageView nav_mediation, nav_record, nav_closer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closer);

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
