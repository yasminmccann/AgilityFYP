package com.example.agilityfyp;


import android.graphics.Rect;

public class ObjectB {
        private Rect rect; // Rectangular bounds of ObjectB

        // Constructor
        public ObjectB(int left, int top, int right, int bottom) {
            rect = new Rect(left, top, right, bottom);
        }

        // Getter for rect
        public Rect getRect() {
            return rect;
        }

        // Update the position of ObjectB
        public void update(int dx, int dy) {
            rect.offset(dx, dy);


        }
}
