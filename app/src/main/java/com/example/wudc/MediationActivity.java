package com.example.wudc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MediationActivity extends AppCompatActivity {
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediation);

        ImageView mediation_img = findViewById(R.id.mediation_img);
        mediation_img.setImageResource(R.drawable.medi1);

        ImageView play_btn=findViewById(R.id.play_btn);
        play_btn.setImageResource(R.drawable.play_btn);
        play_btn.setVisibility(View.INVISIBLE);

        TextView mentText=findViewById(R.id.mentText);
        mentText.setVisibility(View.INVISIBLE);

        mediation_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=1-i;


                if (i==0){
                    mediation_img.setImageResource(R.drawable.medi1);
                    mentText.setVisibility(View.INVISIBLE);
                // 명상이미지를 클릭했을때
                }else{
                    mediation_img.setImageResource(R.drawable.dog2);
                    //관련 문구와 버튼이 보여진다
                    mentText.setVisibility(View.VISIBLE);
                    play_btn.setVisibility(View.VISIBLE);

                }
            }
        });
    }


}
