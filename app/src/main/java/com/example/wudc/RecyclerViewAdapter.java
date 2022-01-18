package com.example.wudc;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
//    private View medi;


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton mediBtn;
        ImageView play_btn;
        TextView mentText;
        int i = 0;

//        LayoutInflater inflater= getLayoutInflater();
//        View header = inflater.inflate(R.layout.activity_mediation,null);


        public ViewHolder(@NonNull View itemView) {
            super(itemView);




            mediBtn = (ImageButton) itemView.findViewById(R.id.mediBtn);

            play_btn=(ImageView) itemView.findViewById(R.id.play_btn);
//            play_btn.setImageResource(R.drawable.play_btn);
//            play_btn.setVisibility(View.INVISIBLE);

            mentText=(TextView) itemView.findViewById(R.id.mentText);
//            mentText.setVisibility(View.INVISIBLE);



            mediBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = 1 - i;


                    if (i==0){
                        mediBtn.setImageResource(R.drawable.medi_bg);
//                        mentText.setText("");
                        mentText.setVisibility(View.INVISIBLE);

                    }else{   // 명상이미지를 클릭했을때
                        mediBtn.setImageResource(R.drawable.ic_launcher_background);
                        //관련 문구와 버튼이 보여진다
//                        mentText.setText("자신의 부족함을 마음 어쩌고");
//                        play_btn.setImageResource(R.drawable.play_btn);
                        mentText.setVisibility(View.INVISIBLE);
                        play_btn.setVisibility(View.INVISIBLE);

                    }
//                    mediBtn.setImageResource(R.drawable.ic_launcher_background);
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
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewItem item = mList.get(position);

        holder.mediBtn.setImageResource(R.drawable.medi_bg);   // 사진 없어서 기본 파일로 이미지 띄움
    }



    @Override
    public int getItemCount() {
        return mList.size();
    }


}
