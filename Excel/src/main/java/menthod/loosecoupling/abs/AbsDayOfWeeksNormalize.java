package menthod.loosecoupling.abs;

import org.apache.poi.ss.usermodel.Cell;

import java.time.DayOfWeek;

public class AbsDayOfWeeksNormalize extends AbsNormalize{
    @Override
    public Comparable normalize(Cell cell) {
        String input = this.formatString(cell);
        if (input == null)
            return null;
        return DayOfWeek.of(Integer.parseInt(input)-1);
    }
}
