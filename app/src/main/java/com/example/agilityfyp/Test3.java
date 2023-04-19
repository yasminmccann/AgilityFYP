package com.example.agilityfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Test3 extends AppCompatActivity {

    ImageView img1, img2;
    private float xCoOrdinate, yCoOrdinate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        //onWindowFocusChanged(true);

        //img1=(ImageView) findViewById(R.id.imageView1);
        //img2=(ImageView) findViewById(R.id.imageView2);
        AddEvents();

        img1 = (ImageView) findViewById(R.id.imageView1);
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    public void AddEvents() {
        Rect r1 = new Rect();
        img1.getHitRect(r1);
        Rect r2 = new Rect();
        img2.getHitRect(r2);
        if (Rect.intersects(r1, r2)) {
            Toast.makeText(this, "intersected", Toast.LENGTH_LONG).show();
        }
    }
}