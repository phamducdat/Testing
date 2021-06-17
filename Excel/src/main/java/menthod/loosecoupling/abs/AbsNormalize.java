package menthod.loosecoupling.abs;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public abstract class AbsNormalize {

        public String formatString(Cell cell){
        DataFormatter formatter = new DataFormatter();
        String s = formatter.formatCellValue(cell);
        s = StringUtils.deleteWhitespace(s);
        if (StringUtils.endsWithIgnoreCase("NULL",s) || StringUtils.equalsIgnoreCase("",s))
            return null;
        return s;
    }

    public abstract Comparable normalize(Cell cell);

}
