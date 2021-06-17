package menthod;

import java.util.ArrayList;
import java.util.List;

public class SplitString {

    public static void main(String[] args) {
        List<Integer> g = new ArrayList<>();

        String s1 = "10";
        String s2 = "26.29";
        String s3 = "2,25-31,33-40";
        String s4 = "2,9-20, 33-40";
        String s5 = "22,24, 25, 26,40";

        List<String> all = new ArrayList<>();
        all.add(s1);
        all.add(s2);
        all.add(s3);
        all.add(s4);
        all.add(s5);

        for (String i : all) {
            i = i.replaceAll("\\s+", "");
            String[] s = i.split("[,.]");
            for (String k : s) {
                if(!k.contains("-")) {
                    g.add(Integer.parseInt(k));
                }else {
                    String[] v = k.split("-");
                    int c = Integer.parseInt(v[0]);
                    int d = Integer.parseInt(v[1]);
                    for(int t = c; t <= d; t++){
                        g.add(t);
                    }
                }
            }
        }

        for(int i : g){
            System.out.println(i);
        }

    }
}
