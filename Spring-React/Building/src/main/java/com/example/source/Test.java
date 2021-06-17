package com.example.source;

abstract class Base {
    abstract void fun();
}

class Dervied extends Base {
    @Override
    void fun() {
        System.out.println("Derived fun() called");
    }
}

public class Test {
    public static void main(String[] args) {
        Base b = new Dervied();
        b.fun();
    }
}
