package menthod.Conflict;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Child {

    private int classId;

    public Child(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object obj) {
        Child s = (Child) obj;
        return s.getClassId() == this.getClassId();
    }
}
