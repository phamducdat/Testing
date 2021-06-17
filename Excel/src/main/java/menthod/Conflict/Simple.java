package menthod.Conflict;

import java.util.ArrayList;
import java.util.List;

public class Simple {

    static List<Integer> one = new ArrayList<>();
    static List<Integer> two = new ArrayList<>();
    static List<Integer> three = new ArrayList<>();
    static List<int[]> result = new ArrayList<>();

    public static void setUp() {
        one.add(1);
        one.add(2);
        one.add(3);
        one.add(4);
        one.add(5);
        one.add(6);

        two.add(1);
        two.add(10);
        two.add(11);
        two.add(13);
        two.add(2);
        two.add(13);
    }

    static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }

    public static void main(String[] args) {
//
//
//        result.add(new int[]{0,1});
//
//        System.out.println(result.get(0)[0]);
//        System.out.println(result.get(0)[1]);

        setUp();
        for (int i : one) {
            if (two.contains(i)) {
                result.add(new int[]{i, two.indexOf(i)});
            }
        }

        for (int[] i : result ) {
            for (int j : i) {
                System.out.println(j);
            }
        }

    }
}
