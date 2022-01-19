package com.example.wudc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecListViewActivity extends AppCompatActivity {
    final String TAG = RecListViewActivity.class.getSimpleName();

    private ListView listview = null;
   // private ListAdapter listAdapter;

    ListViewAdapter listAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_main);


        listview = (ListView) findViewById(R.id.listview);
        listAdapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        listAdapter.addItem(new RecItem("1단계", "명상하기", "명상, 의외의 발견! 심푸미들을 위해 준비된 솔루션이에요"));
        listAdapter.addItem(new RecItem("2단계", "업무 외 시간 가지기", "업무에 과도한 집중은 번아웃의 지름길! 일이 주는 자극에 더 이상 속지 마세요"));
        listAdapter.addItem(new RecItem("3단계", "그림자와 친해지기","그림자와 조화를 이룬 자아는... 자다가도 떡을 먹는다? 나만 아는 그림자 부수기"));
        listAdapter.addItem(new RecItem("4단계", "변화 되짚기", "wow! 끝내 버리시는 당신은 유노우윤호? 고생한 만큼 오늘은 나를 더 쉽게 돌아볼 수 있을 거예요"));
        listAdapter.addItem(new RecItem("5단계", "등등", "등등"));
        listAdapter.addItem(new RecItem("6단계", "등등","등등"));
        listAdapter.addItem(new RecItem("7단계", "등등","등등"));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(listAdapter);
    }
    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<RecItem> items = new ArrayList<>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(RecItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final RecItem recItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.reclistview_list_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            TextView tv_des = (TextView) convertView.findViewById(R.id.tv_des);
            
            tv_num.setText(recItem.getNum());
            tv_name.setText(recItem.getName());
            tv_des.setText(recItem.getDes());
            Log.d(TAG, "getView() - [ "+position+" ] "+recItem.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "단계 : "+recItem.getNum()+" "+" 솔루션 : "+recItem.getName()+" "+" 내용 : "+recItem.getDes(), Toast.LENGTH_SHORT).show();
                    // 페이지 넘어가기
                    /*Intent intent = new Intent(getApplicationContext(), 넘어갈액티비티명.class);
                    startActivity(intent);*/


                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

}
