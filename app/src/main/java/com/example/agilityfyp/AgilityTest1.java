package com.example.agilityfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AgilityTest1 extends AppCompatActivity {

    ImageView image1, image2;
    private float xCoOrdinate, yCoOrdinate;

    PointF circle1Center = new PointF(100, 100); // Center of circle 1 at (100, 100)
    float circle1Radius = 50; // Radius of circle 1 as 50 pixels

    PointF circle2Center = new PointF(100, 100); // Center of circle 2 at (200, 200)
    float circle2Radius = 30; // Radius of circle 2 as 30 pixels


    //boolean collision = CircleCollisionDetector.areCirclesColliding(circle1Center, circle1Radius, circle2Center, circle2Radius);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agility_test1);

        image1 = findViewById(R.id.circle1);
        image2 = findViewById(R.id.circle2);


        image1.setOnTouchListener(new View.OnTouchListener() {
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

        image2.setOnTouchListener(new View.OnTouchListener() {
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


        Rect rect1 = new Rect();
        image1.getHitRect(rect1);

        Rect rect2 = new Rect();
        image2.getHitRect(rect2);

        if (Rect.intersects(rect1, rect2)) {
            // collision detected between imageView1 and imageView2
            // Add your code here to handle the collision
            Toast.makeText(this, "Collision detected", Toast.LENGTH_SHORT).show();
        } else {
            // no collision detected
        }

    }

    public Rect getHitRect(View child){
        Rect frame = new Rect();
        frame.left = child.getLeft();
        frame.right = child.getRight();
        frame.top = child.getTop();
        frame.bottom = child.getBottom();
        return frame;
    }
/*
    public boolean CheckCollision(ImageView circle1,ImageView circle2) {
        Rect R1=new Rect(circle1.getLeft(), circle1.getTop(), circle1.getRight(), circle1.getBottom());
        Rect R2=new Rect(circle2.getLeft(), circle2.getTop(), circle2.getRight(), circle2.getBottom());
        return R1.intersect(R2);
    }

    public static class CircleCollisionDetector {
        public static boolean areCirclesColliding(PointF circle1Center, float circle1Radius, PointF circle2Center, float circle2Radius) {
            // Calculate the distance between the centers of the two circles
            float distanceBetweenCenters = (float) Math.sqrt(Math.pow(circle2Center.x - circle1Center.x, 2) + Math.pow(circle2Center.y - circle1Center.y, 2));

            // Check if the distance between the centers is less than the sum of the radii
            return distanceBetweenCenters < circle1Radius + circle2Radius;
        }
    }

   public class MyView extends View
    {
        Paint paint = null;
        public MyView(Context context)
        {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int x = getWidth();
            int y = getHeight();
            int radius;
            radius = 100;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            // Use Color.parseColor to define HTML colors
            paint.setColor(Color.parseColor("#CD5C5C"));
            canvas.drawCircle(x / 2, y / 2, radius, paint);
        }
    }*/

}