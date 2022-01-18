package com.example.wudc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView choice[] = new TextView[6];
    Integer choId[] = { R.id.cho1, R.id.cho2, R.id.cho3, R.id.cho4, R.id.cho5, R.id.cho6 };
    Integer max = 0;
    ImageView btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < choId.length; i++){
            final int index;
            index = i;
            choice[index] = (TextView) findViewById(choId[index]);

            choice[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!choice[index].isSelected()){    //항목이 선택되어있지않으면
                        if(max < 2){    //2개보다 적게 선택되어있으면
                            max++;
                            choice[index].setSelected(!choice[index].isSelected());
                            choice[index].setTextColor(Color.parseColor("#FFFFFF"));
                        }

                    } else {    //항목이 이미 선택되어있으면
                        max--;
                        choice[index].setSelected(!choice[index].isSelected());
                        choice[index].setTextColor(Color.parseColor("#191D30"));
                    }
                }
            });
        }

        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Onboarding2Activity.class);
                startActivity(intent);
            }
        });
    }
}