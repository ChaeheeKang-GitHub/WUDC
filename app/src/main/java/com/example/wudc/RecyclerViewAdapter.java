package com.example.wudc;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context mContext;
    int pos;
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton mediBtn;
        ImageView playBtn;
        //TextView mentText;
        MediaPlayer m;
        int i = 0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            mediBtn = (ImageButton) itemView.findViewById(R.id.mediBtn);
            playBtn=(ImageView) itemView.findViewById(R.id.playBtn);
           // mentText=(TextView) itemView.findViewById(R.id.mediText);
            MediaPlayer m1 = MediaPlayer.create(itemView.getContext(), R.raw.music1);

            mediBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 1 - i;

                    RecyclerViewItem item = mList.get(pos);


                    if (i==0){
                        //mentText.setVisibility(View.INVISIBLE);
                        playBtn.setVisibility(View.INVISIBLE);

                        if(item.getType() == 0) {
                            mediBtn.setImageResource(R.drawable.medi_btn1);
                        }
                        else {
                            mediBtn.setImageResource(R.drawable.medi_btn2);

                        }

                    }else{   // 명상이미지를 클릭했을때
//                        mediBtn.setImageResource(R.drawable.medi_btn1_blackground);
                        //관련 문구와 버튼이 보여진다
                        //mentText.setVisibility(View.VISIBLE);
                        if(item.getType() == 0) {
                            mediBtn.setImageResource(R.drawable.medi1_bg);
                        }
                        else {
                            mediBtn.setImageResource(R.drawable.medi2_bg);

                        }
                        playBtn.setVisibility(View.VISIBLE);

                    }

                }
            });

            playBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //i = 1 - i;

                    RecyclerViewItem item = mList.get(pos);

/*
                    if(item.getType() == 0) {
                        m = MediaPlayer.create(mContext, R.raw.music1);
                    }
                    else {
                        m = MediaPlayer.create(mContext, R.raw.music2);
                    }
*/
                    if(m1.isPlaying()){
                        //pause아이콘 필요
                        playBtn.setImageResource(R.drawable.pause_btn);
                        m1.pause();
                    }else{
                        m1.seekTo(0);
                        playBtn.setImageResource(R.drawable.play_btn);
                        m1.start();
                    }

                }

            });
        }
    }

    private ArrayList<RecyclerViewItem> mList = null;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem> mList) {
        mContext = context;
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        pos = position;
        RecyclerViewItem item = mList.get(position);
        pos = position;

        if(item.getType() == 0) {
            holder.mediBtn.setImageResource(R.drawable.medi_btn1);


        }
        else {
            holder.mediBtn.setImageResource(R.drawable.medi_btn2);

        }


    }





    @Override
    public int getItemCount() {
        return mList.size();
    }


}
