package menthod.loosecoupling.abs;

import org.apache.poi.ss.usermodel.Cell;

public class Father {
    public static Comparable normalize(AbsNormalize absNormalize, Cell cell){
        return absNormalize.normalize(cell);
    }
}
