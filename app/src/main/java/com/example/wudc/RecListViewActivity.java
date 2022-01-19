package com.example.wudc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecListViewActivity extends AppCompatActivity {

    TextView btnweek;
    TextView btnsol;
    ImageView nav_mediation, nav_record, nav_closer;

    final String TAG = RecListViewActivity.class.getSimpleName();

    private ListView listview = null;
   // private ListAdapter listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_main);

        btnweek = (TextView)findViewById(R.id.btn_weekChange);
        btnweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragWeekDialogFragment f = FragWeekDialogFragment.getInstance();
                f.show(getSupportFragmentManager(), FragWeekDialogFragment.TAG_EVENT_DIALOG);
            }
        });

        btnsol = (TextView)findViewById(R.id.btn_solChange);
        btnsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragSolDialogFragment f = FragSolDialogFragment.getInstance();
                f.show(getSupportFragmentManager(), FragSolDialogFragment.TAG_EVENT_DIALOG);
            }
        });

        //사각 이미지뷰 클릭 시 이동
        ImageView step1=findViewById(R.id.step1);
        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecListViewActivity.this,Solution1.class);
                startActivity(intent);
            }
        });
        ImageView step2=findViewById(R.id.step2);
        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecListViewActivity.this,Solution2.class);
                startActivity(intent);
            }
        });
        ImageView step3=findViewById(R.id.step3);
        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecListViewActivity.this,Solution3.class);
                startActivity(intent);
            }
        });
        ImageView step4=findViewById(R.id.step4);
        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecListViewActivity.this,Solution4.class);
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
