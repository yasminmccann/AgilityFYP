package com.example.agilityfyp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Circle extends View {

    Paint circle1, circle2;

    float xCircleOne, yCircleOne, xCircleTwo, yCircleTwo;

    int radiusCircleOne = 100;
    int radiusCircleTwo = 50;

    public Circle(Context context) {
        super(context);

        init();
    }

    private void init() {
        circle1 = new Paint();
        circle2 = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        //Paint paint1 = new Paint();

        //cirlce 1
        int x = getWidth();
        int y = getHeight();
        int radius = 100;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);

        canvas.drawPaint(paint);

        paint.setColor(Color.parseColor("#CD5C5C"));

        canvas.drawCircle(x/2, y/2, radius,paint);

       /* //rectangle
        paint.setColor(Color.parseColor("#FF0000"));

        canvas.drawRect(100,50,300,300,paint);
*/

        //cirlce 2
        /*int x1 = getWidth();
        int y1 = getHeight();
        int radius1= 100;

        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.GREEN);

        canvas.drawPaint(paint1);

        paint1.setColor(Color.parseColor("fff-fff"));

        canvas.drawCircle(x1/2, y1/2, radius1,paint1);*/


    }
}




