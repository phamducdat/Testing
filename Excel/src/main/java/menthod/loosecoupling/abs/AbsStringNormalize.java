package menthod.loosecoupling.abs;

import menthod.loosecoupling.StringNormalizer;
import org.apache.poi.ss.usermodel.Cell;

public class AbsStringNormalize extends AbsNormalize{


    public String normalize(Cell cell){
        String output = this.formatString(cell);
        return output;
    }
}
