package com.example.wudc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragUserFragment extends Fragment {

    TextView nameTextView, solDayTextView;

    Button btnweek;
    Button btnsol;

    private Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public FragUserFragment(){

    }

    public void setText(String nametext, String soldaytext){
        nameTextView.setText(nametext);
        solDayTextView.setText(soldaytext);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.frag_user_layout,container,false);

        nameTextView = view.findViewById(R.id.name);
        solDayTextView = view.findViewById(R.id.sol_day);

        btnweek = view.findViewById(R.id.btn_weekChange);
        btnweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, " 주기변경 ", Toast.LENGTH_SHORT).show();
                FragWeekDialogFragment f = FragWeekDialogFragment.getInstance();
                f.show(getChildFragmentManager(), FragWeekDialogFragment.TAG_EVENT_DIALOG);
            }
        });

        btnsol = view.findViewById(R.id.btn_solChange);
        btnsol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, " 솔루션변경 ", Toast.LENGTH_SHORT).show();
                FragSolDialogFragment f = FragSolDialogFragment.getInstance();
                f.show(getChildFragmentManager(), FragSolDialogFragment.TAG_EVENT_DIALOG);
               }
        });

        ImageView imguser = (ImageView)view.findViewById(R.id.image_user);

        return view;
    }

}
