package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SolutionRecord extends AppCompatActivity implements View.OnClickListener {

    TextView choice[] = new TextView[13];
    Integer choId[] = {R.id.cho1, R.id.cho2, R.id.cho3, R.id.cho4, R.id.cho5, R.id.cho6, R.id.cho7, R.id.cho8, R.id.cho9, R.id.cho10,
            R.id.cho11, R.id.cho12, R.id.cho13};
    ImageView nav_mediation, nav_record, nav_closer;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsave:
                new AlertDialog.Builder(this)
                        .setTitle("기록 저장")
                        .setMessage("저장되었습니다.")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                            }

                            ;
                        })
                        .show(); // 팝업창 보여줌
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_record);

        for (int i = 0; i < choId.length; i++) {
            final int index;
            index = i;
            choice[index] = (TextView) findViewById(choId[index]);

            choice[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!choice[index].isSelected()) {    //항목이 선택되어있지않으면
                        choice[index].setSelected(!choice[index].isSelected());
                        choice[index].setTextColor(Color.parseColor("#FFFFFF"));
                    } else {    //항목이 이미 선택되어있으면
                        choice[index].setSelected(!choice[index].isSelected());
                        choice[index].setTextColor(Color.parseColor("#191D30"));
                    }
                }
            });

            findViewById(R.id.btnsave).setOnClickListener(this);

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
}

