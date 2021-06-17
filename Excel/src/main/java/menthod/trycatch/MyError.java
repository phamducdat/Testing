package menthod.trycatch;

import menthod.trycatch.Real.CustomException;
import menthod.trycatch.Real.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class MyError{

    static LinkedHashMap<Integer, String> listInput = new LinkedHashMap<>();
    static List<IllegalArgumentException> listException = new ArrayList<>();
    static HashMap<CustomException, Integer> customExceptionHashMap = new HashMap<>();
    static List<CustomException> customExceptionList = new ArrayList<>();
    static List<Error> listErrors = new ArrayList<>();
    static List<Error> errorList = new ArrayList<>();

    public static void handleErrors(HashMap<CustomException, Integer> customExceptionHashMap) {
        System.out.println("Size of input = " + customExceptionHashMap.size());
        List<Integer> listInt = new ArrayList<>();
        List<Integer> listStr = new ArrayList<>();
        List<Integer> listBoolean = new ArrayList<>();
        for (CustomException customException : customExceptionHashMap.keySet()) {
            int k = customExceptionHashMap.get(customException);
            for (Error error : customException.getListError()) {
                if (error.getCode() == Error.INTEGER_ERROR.getCode()) {
                    listInt.add(k);
                } if (error.getCode() == Error.STRING_ERROR.getCode()) {
                    listStr.add(k);
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

    public static void main(String[] args) {
        listInput.put(1,"gfg");
        listInput.put(2,"gfg");
        listInput.put(10,null);
        listInput.put(3,null);
        listInput.put(342,null);
        listInput.put(23,"gfg");
        listInput.put(14,null);

        for (int k : listInput.keySet()) {
//            System.out.println("k = " + k);
            try {

                geeksforgeeks geeks = new geeksforgeeks(geeksforgeeks.toInt(k),
                        geeksforgeeks.toStr(listInput.get(k)));
            } catch (CustomException e) {
                customExceptionHashMap.put(e,k);
            }


        }

//        for (CustomException e : customExceptionHashMap.keySet()) {
//            for(Error error : e.getListError()) {
//                System.out.println(error.getDescription() + "  " + " ; " + error.getCode() + customExceptionHashMap.get(e));
//            }
//        }
        handleErrors(customExceptionHashMap);
    }


}
