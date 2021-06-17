package menthod.Conflict;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Real {



    static List<Child> oneChild = new ArrayList<>();
    static List<Child> twoChild = new ArrayList<>();
    static List<Child> threeChild = new ArrayList<>();

    static Sample sample1 = new Sample("courseId1","classType1",oneChild);
    static Sample sample2 = new Sample("courseId2","classType2",twoChild);
    static Sample sample3 = new Sample("courseId3","classType3",threeChild);


    static void sub1() {
//        List<Sample> all = new LinkedList<>();
//        all.add(sample1);
//        all.add(sample2);
//        all.add(sample3);
//        int index1 = 0;
//        for (int i = 0 ; i < all.size(); ++i)
    }

    public static void main(String[] args) {
        Child s0 = new Child(1000000);
        Child s1 = new Child(1);
        Child s2 = new Child(2);
        Child s3 = new Child(10);
        Child s4 = new Child(4);
        Child s5 = new Child(10);
        Child s6 = new Child(1);
        Child s7 = new Child(6);
        Child s8 = new Child(7);
        Child s9 = new Child(8);
        Child s10 = new Child(2);
        Child s11 = new Child(3);
        Child s12 = new Child(9);
        Child s13 = new Child(11);
        Child s14 = new Child(6);
        Child s15 = new Child(1);
        Child s16 = new Child(2);
        Child s17 = new Child(3);
        Child s18 = new Child(4);
        Child s19 = new Child(5);
        Child s20 = new Child(6);

        oneChild.add(s0);
        oneChild.add(s1);
        oneChild.add(s2);
        oneChild.add(s3);
        oneChild.add(s4);

        // size = 5;

        twoChild.add(s5);
        twoChild.add(s6);
        twoChild.add(s7);
        twoChild.add(s8);
        twoChild.add(s9);
        twoChild.add(s10);
        twoChild.add(s11);
        twoChild.add(s12);
        twoChild.add(s13);

        //size = 10;
        threeChild.add(s14);
        threeChild.add(s15);
        threeChild.add(s16);
        threeChild.add(s17);
        threeChild.add(s18);
        threeChild.add(s19);
        threeChild.add(s20);



    }

}
