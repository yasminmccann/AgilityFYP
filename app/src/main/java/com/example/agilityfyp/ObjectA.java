package com.example.agilityfyp;

import android.graphics.Rect;

public class ObjectA {

        private Rect rect; // Rectangular bounds of ObjectA

        // Constructor
        public ObjectA(int left, int top, int right, int bottom) {
            rect = new Rect(left, top, right, bottom);
        }

        // Getter for rect
        public Rect getRect() {
            return rect;
        }

        // Update the position of ObjectA
        public void update(int dx, int dy) {
            rect.offset(dx, dy);
        }
}
