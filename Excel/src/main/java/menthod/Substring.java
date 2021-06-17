package menthod;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.support.StringMultipartFileEditor;

public class Substring {

    public static String sub(String s){
        System.out.println("///" + s + "///");
        String output = StringUtils.substringBefore(s,"-");
        String input = StringUtils.substringAfter(s,"-");

        return output;
    }

    public static void main(String[] args) {
//        String s = "065-910";
//        System.out.println(s);
//        s = Substring.sub(s);
//        System.out.println(s);
//        s = Substring.sub(s);
//        System.out.println(s);

//        System.out.println(Substring.sub(s));
        String s = "Mã_lớp_Kèm";
        s = StringUtils.upperCase(s);
        System.out.println(s);


    }
}
