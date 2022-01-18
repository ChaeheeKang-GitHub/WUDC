package com.example.wudc;

import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediation);

        firstInit();

        for(int i=0;i<5;i++){
            addItem("iconName");    //*여기로 버튼 이름 전달해서 버튼 별로 이미지 변경 필요
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));   //가로 리사이클


    }

    public void firstInit() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mList = new ArrayList<>();


    }

    public void addItem(String btnName) {
        RecyclerViewItem item = new RecyclerViewItem();

        item.setBtnName(btnName);

        mList.add(item);
    }

}
