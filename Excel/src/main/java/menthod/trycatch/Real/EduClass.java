package menthod.trycatch.Real;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class EduClass {

    private Integer a;
    public String b;
    public List<Error> errorList = new ArrayList<>();

    public static Integer toInteger(String b) {
//        if (b == null) throw  new IllegalArgumentException();
        if (b.equals("null") || b.equals("KD") || b.equals("NO")) return null;
        else {
            return Nor.toInt(b);
        }
    }

    public static String toString(String b){
//        if (b == null) throw new IllegalArgumentException("Twice");
        return b;
    }

    public EduClass(Integer a, String b) throws CustomException {
        if (a == null) errorList.add(Error.INTEGER_ERROR);
        if (b == null) errorList.add(Error.STRING_ERROR);
        if (errorList.size() > 0) throw new CustomException(errorList);
        this.a = a;
        this.b = b;
    }
}
