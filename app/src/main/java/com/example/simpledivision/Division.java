package com.example.simpledivision;

public class Division implements Operation {

    @Override
    public double execute(int a, int b) {
        return a / (double) b;
    }
}
