package menthod.Conflict;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Sample {

    private final String courseId;

    private final String classType;

    private final List<Child> classes;

    @Override
    public boolean equals(Object obj) {
        Sample sample = (Sample) obj;
        if (!this.getCourseId().equals(sample.getCourseId())) {
            return StringUtils.equals(this.getClassType(), sample.getClassType());
        }
        return true;
    }
}
