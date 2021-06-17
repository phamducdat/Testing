package menthod.trycatch;


import menthod.trycatch.Real.CustomException;
import menthod.trycatch.Real.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class geeksforgeeks {
    public Integer a;
    public String b;

    static LinkedHashMap<Integer, String> listInput = new LinkedHashMap<>();
    static List<IllegalArgumentException> listException = new ArrayList<>();
    static HashMap<CustomException, Integer> customExceptionHashMap = new HashMap<>();
    static List<CustomException> customExceptionList = new ArrayList<>();
    static List<Error> listErrors = new ArrayList<>();
    static List<Error> errorList = new ArrayList<>();



    public static int toInt (int a) {
        if (a < 10) errorList.add(Error.INTEGER_ERROR);
        return a;
    }
    public static String toStr (String b) {
        if (b == null) errorList.add(Error.STRING_ERROR);
        return b;
    }

    public geeksforgeeks(int a, String b) throws CustomException{
        this.a = a;
        this.b = b;
        if (errorList.size() > 0) {
            System.out.println("size of errorList = " + errorList.size());
            List<Error> temp = errorList;
            errorList = new ArrayList<>();
            throw new CustomException(temp);
        }
    }


    public static void handleErrors(HashMap<CustomException, Integer> customExceptionHashMap) {
        List<Integer> listInt = new ArrayList<>();
        List<Integer> listStr = new ArrayList<>();
        List<Integer> listBoolean = new ArrayList<>();
        HashMap<Error, List<Integer>> setUp = new HashMap<>();
        for (CustomException customException : customExceptionHashMap.keySet()) {
            int k = customExceptionHashMap.get(customException);
            for (Error error : customException.getListError()) {
//                setUp.put(error, new ArrayList<>());
//                setUp.get(error).add(k);
//                System.out.println ("Ok");
                switch (error.getCode()) {
                    case 0:
                        listInt.add(k);
                    case 1:
                        listStr.add(k);
                    default:
                        listBoolean.add(k);
                }
            }
        }
        System.out.println("Errors of Integer are, this must like 123 : ");
        for (int i : listInt) {
            System.out.println(i);
        }

        System.out.println("Errors of String are, this must like \"abc\" : ");
        for (int i : listStr) {
            System.out.println(i);
        }
    }


}
