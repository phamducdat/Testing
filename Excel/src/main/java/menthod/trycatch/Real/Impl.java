package menthod.trycatch.Real;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Impl {

    public static LinkedHashMap<String, String> inputList = new LinkedHashMap<>();
    public static LinkedHashMap<CustomException, Integer> customExceptionList = new LinkedHashMap<>();

    public static void handleException() {
        List<Integer> ONE = new ArrayList<>();
        List<Integer> TWO = new ArrayList<>();
        for (CustomException c : customExceptionList.keySet()) {
            int k = customExceptionList.get(c);
            for (Error error : c.getListError()) {
                if (error.getCode() == Error.INTEGER_ERROR.getCode()) {
                    ONE.add(k);
                } if (error.getCode() == Error.STRING_ERROR.getCode()) {
                    TWO.add(k);
                }
            }
        }

        System.out.println("ONE are : ");
        for (int i : ONE) {
            System.out.println(i);
        }

        System.out.println("TWO are : ");
        for (int i : TWO) {
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        inputList.put("null", "b"); //1 int
        inputList.put("3", null); //2 str
        inputList.put("2", "a"); //3
        inputList.put("4", null); //4 string
        inputList.put("KD", null); //5 int
        inputList.put("7", "g"); //6 string
        inputList.put("6", "g"); //7 string
        inputList.put("NO", "b"); //8 int

        int i = 0;
        System.out.println(inputList.size());
        for (String s : inputList.keySet()) {
            i = i + 1;
            try {
                EduClass eduClass =
                        new EduClass(EduClass.toInteger(s), EduClass.toString(inputList.get(s)));
            } catch (CustomException e) {
                customExceptionList.put(e,i);
//                System.out.println(e.getMessage() + " : " + i);
//                System.out.println();
            }
        }

//        for (CustomException c : customExceptionList.keySet()) {
//            System.out.println(c.getMessage() + " : " + customExceptionList.get(c));
//            System.out.println();
//        }

        handleException();
    }
}
