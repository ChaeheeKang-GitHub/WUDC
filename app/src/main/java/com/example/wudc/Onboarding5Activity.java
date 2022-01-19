package com.example.wudc;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Onboarding5Activity extends AppCompatActivity {

    ImageView profile;
    final int GET_GALLERY_IMAGE = 200;
    Uri selectedImageUri = null;
    EditText editName;
    TextView choice[] = new TextView[3];
    Integer choId[] = { R.id.cho1, R.id.cho2, R.id.cho3 };
    Integer max = 0;
    Integer selected = 0;
    TextView btnNext;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding5);

        profile = (ImageView) findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });

        editName = (EditText) findViewById(R.id.editName);

        for(int i = 0; i < choId.length; i++){
            final int index;
            index = i;
            choice[index] = (TextView) findViewById(choId[index]);

            choice[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!choice[index].isSelected()){    //항목이 선택되어있지않으면
                        if(max < 1){    //1개보다 적게 선택되어있으면
                            max++;
                            selected = index;
                        } else if (max == 1) {
                            choice[selected].setSelected(!choice[selected].isSelected());
                            choice[selected].setTextColor(Color.parseColor("#191D30"));
                            selected = index;
                        }
                        choice[index].setSelected(!choice[index].isSelected());
                        choice[index].setTextColor(Color.parseColor("#FFFFFF"));

                    } else {    //항목이 이미 선택되어있으면
                        max--;
                        choice[index].setSelected(!choice[index].isSelected());
                        choice[index].setTextColor(Color.parseColor("#191D30"));
                    }
                }
            });
        }

        btnNext = (TextView) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedImageUri != null){
                    Intent intent = new Intent(getApplicationContext(), Onboarding6Activity.class);
                    intent.putExtra("uri", selectedImageUri.toString());
                    intent.putExtra("name", editName.getText().toString());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), Onboarding6Activity.class);
                    intent.putExtra("uri", "");
                    intent.putExtra("name", editName.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            profile.setImageURI(selectedImageUri);
        }
    }
}
