package com.example.agilityfyp;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

public class DuaFragment extends Fragment implements View.OnTouchListener{
    ImageView fear;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_test2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createAllImage();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                fear.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                fear.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                fear.getDrawable().clearColorFilter();
                fear.invalidate();
                break;
        }
        return true;
    }

    void createAllImage() {
        fear=(ImageView)getView().findViewById(R.id.ball);
        fear.setOnTouchListener(this);
    }
}
