package com.example.agilityfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Test2 extends AppCompatActivity {


    private float xCoOrdinate, yCoOrdinate, x1CoOrd, y1CoOrd;
    //ImageView circle1, circle2;

    TextView textView;

    //Screen size
    private int screenWidth;
    private int screenHeight;

    //Image Views
    private ImageView circle1;
    private ImageView circle2;

    //Position
    private float circle1X;
    private float circle1R;
    private float cirlce2X;
    private float circle2R;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        textView = findViewById (R.id.timer);
        runCountdown();
       // CheckCollision();


        ImageView circle1 = (ImageView) findViewById(R.id.ball);
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

        ImageView circle2 = (ImageView) findViewById(R.id.net);
        circle2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        x1CoOrd = view.getX() - event.getRawX();
                        y1CoOrd = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + x1CoOrd).y(event.getRawY() + y1CoOrd).setDuration(0).start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

       /* Rect myViewRect = new Rect();
        circle1.getDrawingRect(myViewRect);

        Rect otherViewRect1 = new Rect();
        circle2.getDrawingRect(otherViewRect1);


        if (Rect.intersects(myViewRect, otherViewRect1)) {
            Toast.makeText(this, "Intersected", Toast.LENGTH_LONG).show();
        }*/

        //CheckCollision();
        //intersects(circle1,circle2);
       // cTimer = (TextView) findViewById(R.id.timer);

    }

    private void runCountdown() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView cTimer = findViewById(R.id.timer);
                cTimer.setText("Timer: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                TextView cTimer = findViewById(R.id.timer);
                cTimer.setText("Done!");
            }
        }.start();

    }

    /*public void collision() {
        float radii = circle1.
    }*/

    public double getDistance() {
    float a = circle2.getY() - circle1.getY();
    float b = circle2.getX() - circle1.getX();
    return Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    }

/*    public boolean intersects(ImageView circle1, ImageView circle2) {
        boolean intersects = false;
        if (circle1.getX() + circle1.getY() >= circle2.getX() + circle2.getY() &&
                circle1.getX() - circle1.getY() <= circle2.getX() - circle2.getY());
        {
            intersects = true;
            Toast.makeText(this, "Intersected", Toast.LENGTH_LONG).show();
        }

        return intersects;

    }*/

   /* public void CheckCollision() {
        Rect rc1 = new Rect();
        circle1.getHitRect(rc1);
        Rect rc2 = new Rect();
        circle2.getHitRect(rc2);
        if (Rect.intersects(rc1, rc2)) {
            // intersection is detected
            // here is your method call
            Toast.makeText(this, "Detected Intersect", Toast.LENGTH_SHORT).show();
            Log.d("this", "DETECTED INTERSECT");
            circle1.setVisibility(View.GONE);
            circle2.setVisibility(View.GONE);
        }
    }*/




/*
    private void runthread1() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CheckCollision();
            }
        });
    }

    Boolean collided;

    public Boolean CollisionTest(Rect rc1, Rect rc2) {
        if (rc1.intersect(rc2)) {
            collided = true;
        } else {
            collided = false;
        }
        return (collided);
    }*/

   /* public static boolean isCollisionDetected(Bitmap bitmap1, int x1, int y1,
                                              Bitmap bitmap2, int x2, int y2) {

        Rect bounds1 = new Rect(x1, y1, x1+bitmap1.getWidth(), y1+bitmap1.getHeight());
        Rect bounds2 = new Rect(x2, y2, x2+bitmap2.getWidth(), y2+bitmap2.getHeight());

        if (Rect.intersects(bounds1, bounds2)) {
            Rect collisionBounds = getCollisionBounds(bounds1, bounds2);
            for (int i = collisionBounds.left; i < collisionBounds.right; i++) {
                for (int j = collisionBounds.top; j < collisionBounds.bottom; j++) {
                    int bitmap1Pixel = bitmap1.getPixel(i-x1, j-y1);
                    int bitmap2Pixel = bitmap2.getPixel(i-x2, j-y2);
                    if (isFilled(bitmap1Pixel) && isFilled(bitmap2Pixel)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int getBitmapPixel(Sprite sprite, int i, int j) {
        return sprite.getBitmap().getPixel(i-(int)sprite.getX(), j-(int)sprite.getY());
    }

    private static Rect getCollisionBounds(Rect rect1, Rect rect2) {
        int left = (int) Math.max(rect1.left, rect2.left);
        int top = (int) Math.max(rect1.top, rect2.top);
        int right = (int) Math.min(rect1.right, rect2.right);
        int bottom = (int) Math.min(rect1.bottom, rect2.bottom);
        return new Rect(left, top, right, bottom);
    }

    private static boolean isFilled(int pixel) {
        return pixel != Color.TRANSPARENT;
    }*/
}
