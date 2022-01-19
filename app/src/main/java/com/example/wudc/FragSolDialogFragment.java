package com.example.wudc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class FragSolDialogFragment extends DialogFragment implements View.OnClickListener {

    public static final String TAG_EVENT_DIALOG = "dialog_event";
    public FragSolDialogFragment() {}
    public static FragSolDialogFragment getInstance() {
        FragSolDialogFragment fragsoldial = new FragSolDialogFragment();
        return fragsoldial;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sol_dialog, container);
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
