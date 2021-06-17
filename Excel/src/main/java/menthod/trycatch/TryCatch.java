package menthod.trycatch;


import connect.repository.enums.CustomException;
import menthod.trycatch.Real.Error;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TryCatch {

    static List<Error> listErrors = new ArrayList<>();

    public static Integer getInt(Integer a) {
        return a;
    }

    public static void main(String[] args) {
//        try {
//
//            Integer a = TryCatch.getInt(null);
//            if (a == null) listErrors.add(Error.INTEGER_ERROR);
//            if (listErrors.size() > 0)
//        } catch (CustomException)

    }

}
