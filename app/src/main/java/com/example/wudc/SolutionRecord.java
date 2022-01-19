package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

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
                        .setTitle("알람 팝업")
                        .setMessage("팝업 창의 내용입니다.\n\n TEST!!")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                            }
                        })
                        .show(); // 팝업창 보여줌
                break;
        }
    }
}

