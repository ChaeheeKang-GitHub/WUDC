package com.example.wudc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MediationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<RecyclerViewItem> mList;  //버튼리스트
    private RecyclerViewAdapter mRecyclerViewAdapter;
//    private Context mContext;

    ImageView choice[] = new ImageView[7];
    Integer choId[] = { R.id.mon_cb,R.id.tue_cb,R.id.wed_cb,R.id.thu_cb,R.id.fri_cb,R.id.sat_cb,R.id.sun_cb };
    boolean week_option[]= {false,false,false,false,false,false,false};

    ImageView nav_mediation, nav_record, nav_closer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediation);

        firstInit();

        for(int i=0;i<2;i++){
            addItem(i);    //*여기로 버튼 이름 전달해서 버튼 별로 이미지 변경 필요
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(this, mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));   //가로 리사이클


        //요일별 체크박스 구현
        for(int i = 0; i < choId.length; i++){
            final int index;
            index = i;
            choice[index] = (ImageView) findViewById(choId[index]);

            choice[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(week_option[index]){    //항목이 선택되어있지않으면
                        choice[index].setImageResource(R.drawable.unchecked);
                        week_option[index]=false;

                    } else {    //항목이 이미 선택되어있으면
                        choice[index].setImageResource(R.drawable.checked);
                        week_option[index]=true;
                    }
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
//                    //기록하기 액티비티와 연결해주세요
                    Intent intent = new Intent(getApplicationContext(), RecListViewActivity.class);
                    startActivity(intent);
                }
            });
            nav_closer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }

    }

    public void firstInit() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mList = new ArrayList<>();


    }

    public void addItem(int type) {
        RecyclerViewItem item = new RecyclerViewItem();

        item.setType(type);

        mList.add(item);
    }


}
