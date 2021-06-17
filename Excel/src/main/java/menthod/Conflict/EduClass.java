package menthod.Conflict;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EduClass {

    private int classId;

    public EduClass(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object obj) {
        EduClass s = (EduClass) obj;
        return s.getClassId() == this.getClassId();
    }
}
