package menthod.Conflict;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class GroupClassOM {

    private final String courseId;

    private final String classType;

    private List<EduClass> classes;
}
