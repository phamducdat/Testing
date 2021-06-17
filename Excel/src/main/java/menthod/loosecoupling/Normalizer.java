package menthod.loosecoupling;

import org.apache.poi.ss.usermodel.Cell;

public interface Normalizer {
    Comparable normalize(Cell cell);
}
