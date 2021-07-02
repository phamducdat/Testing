package io.openvidu.mvc.java;

public class TestMethod {

    public static class Mehtod2 {
        public static int getFirstArg(int a, int b) {
            System.out.println("dat = " + a);
            System.out.println("h = " + b);
            return a;
        }
    }

    private int a;
    private int b;


    public static int sum(int a, int b) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return Mehtod2.getFirstArg(a,b);
    }

    public static void main(String[] args) {
        System.out.println(TestMethod.sum(24,2));
    }
}
