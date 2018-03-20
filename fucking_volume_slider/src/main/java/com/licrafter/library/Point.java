package com.licrafter.library;

/**
 * Created by lijx on 2017/6/14.
 */

class Point {
    float x;
    float y;

    Point() {

    }

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    void trans(float x, float y) {
        this.x += x;
        this.y += y;
    }

    void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
