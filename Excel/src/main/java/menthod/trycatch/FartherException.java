package menthod.trycatch;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;

public class FartherException extends Exception{
    public static void main(String[] args) {
        HashMap<String, Integer> Test = new HashMap<>();
//        LinkedList<String, Integer> Test = new LinkedList<>();
//        ArrayDeque<String, Integer>
        Test.put("a",1);
        Test.put("b",1);
        System.out.println(Test.size());

    }
}

