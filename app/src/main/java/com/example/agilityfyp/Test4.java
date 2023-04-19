package com.example.agilityfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Test4 extends AppCompatActivity {

    //Screen size
    private int screenWidth;
    private int screenHeight;

    //Image Views
    private ImageView circle1;
    private ImageView circle2;

    //Position
    private float circle1X;
    private float circle1Y;
    private float cirlce2X;
    private float circle2Y;

    //Initalize class
    private Handler handler = new Handler();
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);

        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);

        //Get screen size
        WindowManager wm = getWindowManager();
        Display dis = wm.getDefaultDisplay();
        Point size = new Point();
        dis.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //move to out of screen
        circle1.setX(-80.0f);
        circle1.setY(-80.0f);
        circle2.setX(-80.0f);
        circle2.setY(screenHeight + 80.0f);

        //start the timer
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
    }

    public void changePos(){
        //up
        circle1Y -= 10;
        if(circle1.getY() + circle1.getHeight() < 0){
            circle1X = (float)Math.floor(Math.random() * (screenWidth - circle1.getWidth()));
            circle1Y = screenHeight + 100.0f;
        }

        circle1.setX(circle1X);
        circle1.setY(circle1Y);

        //down
        circle2Y += 10;
        if(circle2.getY() > screenHeight){
            cirlce2X = (float)Math.floor(Math.random() * (screenWidth - circle2.getWidth()));
            circle2Y = -100.0f;
        }

        circle2.setX(cirlce2X);
        circle2.setY(circle2Y);
    }
}