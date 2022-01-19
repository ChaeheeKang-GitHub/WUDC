package com.example.wudc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FragSolDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_EVENT_DIALOG = "dialog_event";
    public FragSolDialogFragment() {}
    public static FragSolDialogFragment getInstance() {
        FragSolDialogFragment fragsoldial = new FragSolDialogFragment();
        return fragsoldial;
    }

    TextView choice[] = new TextView[3];
    Integer choId[] = { R.id.btn_ac, R.id.btn_se, R.id.btn_up };
    Integer max = 0;
    Integer selected = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sol_dialog, container);
        TextView mConfrimBtn = (TextView) view.findViewById(R.id.btnSample);
//        Button mConfrimBtn = (Button) view.findViewById(R.id.btnSample);
        mConfrimBtn.setOnClickListener(this);
        setCancelable(false);

        for(int i = 0; i < choId.length; i++){
            final int index;
            index = i;
            choice[index] = (TextView) view.findViewById(choId[index]);

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


        return view;
    }

    @Override
    public void onClick(View view) {
        dismiss();

    }

}
