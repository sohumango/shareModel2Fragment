package com.urobot.sharemodel2fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReceiverFragment extends Fragment {
    TextView tv_msg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_receiver, container, false);
        final SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        tv_msg = (TextView) view.findViewById(R.id.tv_receiver);
        model.getMessage().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                tv_msg.setText(o.toString());
            }
        });
        return  view;
    }
}
