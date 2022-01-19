package com.example.wudc;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    int pos;
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton mediBtn;
        ImageView playBtn;
        TextView mentText;
        int i = 0;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            mediBtn = (ImageButton) itemView.findViewById(R.id.mediBtn);
            playBtn=(ImageView) itemView.findViewById(R.id.playBtn);
            mentText=(TextView) itemView.findViewById(R.id.mediText);

            mediBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 1 - i;

                    RecyclerViewItem item = mList.get(pos);


                    if (i==0){
                        mentText.setVisibility(View.INVISIBLE);
                        playBtn.setVisibility(View.INVISIBLE);

                        if(item.getType() == 0) {
                            mediBtn.setImageResource(R.drawable.medi_bg);
                        }
                        else {
                            mediBtn.setImageResource(R.drawable.medi_btn2);

                        }

                    }else{   // 명상이미지를 클릭했을때
                        mediBtn.setImageResource(R.drawable.box);
                        //관련 문구와 버튼이 보여진다
                        mentText.setVisibility(View.VISIBLE);
                        playBtn.setVisibility(View.VISIBLE);

                    }

                }
            });
        }
    }

    private ArrayList<RecyclerViewItem> mList = null;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> mList) {
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
            holder.mediBtn.setImageResource(R.drawable.medi_bg);
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
