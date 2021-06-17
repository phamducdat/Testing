package menthod.loosecoupling.abs;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

public class AbsBoolenNormalize extends AbsNormalize {
    @Override
    public Comparable normalize(Cell cell) {
        String input = this.formatString(cell);
        if(input == null)
            return null;
        return StringUtils.endsWithIgnoreCase("TN", input);
    }
}
