package menthod;

import java.util.ArrayList;
import java.util.List;

public class OverLap {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(10);
        a.add(11);
        a.add(13);

        b.add(3);
        b.add(4);
        b.add(5);
        b.add(3);
        b.add(20);
        b.add(21);
        b.add(22);
        b.add(23);

        int m = 0;
        for (int i : a) {
            System.out.println("i = " + i);
            for (int k = m; k < b.size(); k++) {
                if (b.get(k) == i) {
                    System.out.println("False");
                    return;
                }
                if (b.get(k) > i) {
                    m = k;
                    break;
                }
            }

        }
        System.out.println("True");
    }
}
