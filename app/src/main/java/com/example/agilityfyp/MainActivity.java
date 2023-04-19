package com.example.agilityfyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Circle(this));
        //setContentView(R.layout.activity_main);
    }

       /* Button circle = (Button) findViewById(R.id.btn2);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent2();
            }
        });

        Button start = (Button) findViewById(R.id.startBtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startIntent();
            }
        });

        Button graph = (Button) findViewById(R.id.graph);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent3();
            }
        });

    }

    public void startIntent() {
        Intent intent = new Intent(this, Test3.class);
        startActivity(intent);
    }

    public void startIntent2() {
        Intent intent = new Intent(MainActivity.this, AgilityTest1.class);
        startActivity(intent);
    }

    public void startIntent3() {
        Intent intent = new Intent(MainActivity.this, GraphActivity.class);
        startActivity(intent);
    }*/

}