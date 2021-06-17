package menthod;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

public abstract class Abs {

    public String format(String s){
        String output = StringUtils.deleteWhitespace(s);
        if(StringUtils.equalsIgnoreCase("NULL",output) || StringUtils.endsWithIgnoreCase("",output))
            return null;
        return output;
    }

    Comparable normalize(Cell cell){
        return null;
    }
}
