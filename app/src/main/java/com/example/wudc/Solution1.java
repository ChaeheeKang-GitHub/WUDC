package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Solution1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution1);

        Button btnmemo = (Button) findViewById(R.id.btnmemo);
        btnmemo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SolutionRecord.class);
                startActivity(intent);
            }
        });


    }


    }
