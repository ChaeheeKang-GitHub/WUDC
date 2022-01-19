package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

public class SolutionRecord extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_record);

        findViewById(R.id.btnsave).setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsave:
                new AlertDialog.Builder(this)
                        .setTitle("기록 저장")
                        .setMessage("저장되었습니다.")
                        .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                            };
                        })
                        .show(); // 팝업창 보여줌
                break;
        }
    }




}

