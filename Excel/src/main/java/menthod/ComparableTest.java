package menthod;


import connect.repository.EShift;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Setter
@Getter
public class ComparableTest {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();

        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);

        System.out.println(test.indexOf(0));
        System.out.println(test.size());
    }
}
