package menthod.loosecoupling.abs;

import org.apache.poi.ss.usermodel.Cell;

public class AbsIntegerNormalize extends AbsNormalize {



    public Comparable normalize(Cell cell) {
        String input = this.formatString(cell);
        if (input == null)
            return null;
        return Integer.parseInt(input);
    }
}
