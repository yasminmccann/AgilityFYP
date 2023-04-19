package com.example.agilityfyp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Ref;

public class ExampleActivity extends AppCompatActivity {

    ImageView circle1, circle2;
    private float xCoOrdinate, yCoOrdinate;
    //score
    private TextView score = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        //Check that the bitmap added to circle1 is the object, not the image
        circle1 = (ImageView) findViewById(R.id.image1);
        circle2 = (ImageView) findViewById(R.id.image2);
        //createBitMap1();
        //checkCollison();

        //createBitMap2();

        circle1.setOnTouchListener(new View.OnTouchListener() {
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

        circle2.setOnTouchListener(new View.OnTouchListener() {
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

    }

   /* private void createBitMap1() {
        Bitmap bitMap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);  //creates bmp
        bitMap = bitMap.copy(bitMap.getConfig(), true);     //lets bmp to be mutable
        Canvas canvas = new Canvas(bitMap);                 //draw a canvas in defined bmp

        Paint paint = new Paint();
        // smooths
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        Region reg = new Region();
        Path pathA = new Path();
        //paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
        //canvas.drawRect(50, 50, 50, 50, paint);
        //canvas.clipPath(mPath, Region.Op.INTERSECT);
        pathA.addCircle(200, 200, 150, Path.Direction.CW);
        Path pathB = new Path();
        pathB.addCircle(200, 200, 150, Path.Direction.CW);
        canvas.clipPath(pathA);
        canvas.clipPath(pathB, Region.Op.INTERSECT);
        canvas.drawCircle(200, 200, 150, paint);
        circle1.setImageBitmap(bitMap);
        circle2.setImageBitmap(bitMap);

        circle1.buildDrawingCache();
        Bitmap bplay1 = circle1.getDrawingCache();
        circle2.buildDrawingCache();
        Bitmap bbrick1 = circle2.getDrawingCache();

        int w1 = bplay1.getWidth();
        int h1 = bplay1.getHeight();
        int w2 = bbrick1.getWidth();
        int h2 = bbrick1.getHeight();
    }

    public void checkCollison() {
        Rect myViewRect = new Rect();
        circle1.getHitRect(myViewRect);

        Rect otherViewRect1 = new Rect();
        circle2.getHitRect(otherViewRect1);

        if (Rect.intersects(myViewRect, otherViewRect1)) {
            // Intersects otherView1
            //Log.v(this, "Intersected");
            Toast.makeText(this, "Intersected", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No Intersection", Toast.LENGTH_SHORT).show();
        }
    }
*/

          //  points++; //You dont need findView Textview score for that exists in OnCreate Method
          //  this.score.setText("Score:" + points);


        // Location holder
        /*final int[] loc = new int[2];

        circle1.getLocationInWindow(loc);
        final Rect rc1 = new Rect(loc[0], loc[1],
                loc[0] + circle1.getWidth(), loc[1] + circle1.getHeight());

        circle2.getLocationInWindow(loc);
        final Rect rc2 = new Rect(loc[0], loc[1],
                loc[0] + circle2.getWidth(), loc[1] + circle2.getHeight());

        if (Rect.intersects(rc1,rc2)) {
            Log.d(TAG, "Intersected");
            Toast.makeText(this, "Intersected!", Toast.LENGTH_SHORT).show();
        } else {
            Log.d(TAG, "NOT Intersected");
            Toast.makeText(this, "Not Intersected!", Toast.LENGTH_SHORT).show();
        }
*/




    /*public class MyView extends View {
        public MyView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int xCircle1 = getWidth();
            int yCircle1 = getHeight();
            int radiusCircle1;
            radiusCircle1 = 100;
            Paint circle1 = new Paint();
            circle1.setStyle(Paint.Style.FILL);
            circle1.setColor(Color.WHITE);
            canvas.drawPaint(circle1);
            circle1.setColor(Color.parseColor("#0ED6B9"));
            canvas.drawCircle(xCircle1/2, yCircle1/2, radiusCircle1, circle1);

            int xCircle2 = getWidth();
            int yCircle2 = getHeight();
            int radiusCircle2;
            radiusCircle2 = 100;
            Paint circle2 = new Paint();
            circle2.setStyle(Paint.Style.FILL);
            circle2.setColor(Color.WHITE);
            canvas.drawPaint(circle2);
            circle2.setColor(Color.parseColor("#0ED6B9"));
            canvas.drawCircle(xCircle2/2, yCircle2/2, radiusCircle2, circle2);





        }
    }*/
