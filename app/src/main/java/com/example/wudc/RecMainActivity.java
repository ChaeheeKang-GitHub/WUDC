package com.example.wudc;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecMainActivity extends AppCompatActivity {


    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_main);

        //데이터 준비
        items = new ArrayList<String>();
        items.add("명상으로 마음 다스리기");
        items.add("잠자기 전 명상하기");
        items.add("심리 도서 정독하기");
        items.add("명상으로 마음 다스리기");


    }




}
