package menthod.loosecoupling.abs;

import connect.repository.EShift;
import org.apache.poi.ss.usermodel.Cell;

public class AbsEshiftNormalize extends AbsNormalize{
    @Override
    public Comparable normalize(Cell cell) {
        String input = this.formatString(cell);
        if (input == null)
            return null;
        return EShift.of(input);
    }
}
