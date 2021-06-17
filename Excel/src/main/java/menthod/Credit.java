package menthod;

import org.apache.commons.lang3.StringUtils;

public class Credit {

    public static void main(String[] args) {
        String s = "2(2-1-0-4)";
        String b = "";


        String b1 = StringUtils.deleteWhitespace(b);
        String s1 = StringUtils.deleteWhitespace(s);
        if(b1.equals("")){
            System.out.println("ok");
        }else
            System.out.println("no");


        String s2 = StringUtils.substring(s1,0,1);
        String b2 = StringUtils.substringBefore(b1,"-");
        String b3 = StringUtils.substringAfter(b1,"-");
        int a = Integer.parseInt(s2);
        System.out.println(a);
        System.out.println(b2);
        System.out.println(b3);
//        String s3 = " 77";
//        System.out.println(Integer.parseInt(s3));

    }
}
