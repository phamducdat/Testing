package menthod.trycatch;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class TestTryCatch {

//    public static void main(String[] args) {
//        try {
//            int[] a = {5,6,7};
//            System.out.println(a[4]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Index does not exist");
//        }
//    }

    private int a;

    private String b;

    public TestTryCatch(int a,String b) throws IllegalArgumentException{
//        try {
//            this.a = a;
//            this.b = b;
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//        }
//
        if(a < 10) throw new IllegalArgumentException("a must be greater than 10");
        if (b == null) throw new IllegalArgumentException("b must not null");
        else {
        this.a = a;
        this.b = b;
        }
    }

    public static void main(String[] args) {
        try {
            TestTryCatch testTryCatch = new TestTryCatch(11, null);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + "\n" +
                    ex.toString() + "\n" +
                    ex.getCause());
        }
//        try {
//            TestTryCatch testTryCatch = new TestTryCatch(10, null);
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//    }
        HashMap<Integer, String> inputs = new HashMap<>();
//        inputs.put(2, "gg");
//        inputs.put(3, "hh");
//        inputs.put(4, null);
//
//
//        for(int i = 0; i <=2;i++)
//    {
//        try {
//            TestTryCatch testTryCatch = new TestTryCatch(i, inputs.get(i));
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getCause() + "\n" +
//                            exception.getMessage() + "\n" +
//                        exception.getLocalizedMessage()+ "\n" +
//                        exception.toString() + "\n"
//            );
//            break;
//        }
//        System.out.println();
//    }
}




}
