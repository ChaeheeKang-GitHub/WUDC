package com.example.wudc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FragWeekDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_EVENT_DIALOG = "dialog_event";
    public FragWeekDialogFragment() {}
    public static FragWeekDialogFragment getInstance() {
        FragWeekDialogFragment fragweekdial = new FragWeekDialogFragment();
        return fragweekdial;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_dialog, container);
        ImageButton mConfrimBtn = (ImageButton) view.findViewById(R.id.btnSample);
//        Button mConfrimBtn = (Button) view.findViewById(R.id.btnSample);
        mConfrimBtn.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        dismiss();

    }

}
