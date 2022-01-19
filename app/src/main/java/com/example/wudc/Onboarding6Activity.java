package com.example.wudc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Onboarding6Activity extends AppCompatActivity {

    ImageView profile;
    TextView textTitle, btnNext;
    String name, uriStr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding6);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        uriStr = intent.getStringExtra("uri");

        profile = (ImageView) findViewById(R.id.profile);
        if(uriStr.length() > 0){
            profile.setImageURI(Uri.parse(uriStr));
        }

        textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setText(name + textTitle.getText().toString());

        btnNext = (TextView) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MediationActivity.class);
                startActivity(intent);
            }
        });

    }
}
