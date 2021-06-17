package menthod;

import connect.entities.EduCourse;
import connect.repository.EDepartment;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashSet;

public class Unique {
    public static void main(String[] args) {
        EDepartment eDepartment = EDepartment.KD;
        EDepartment eDepartment2 = EDepartment.KD;
        HashSet<EduCourse> courses = new HashSet<>();
        EduCourse eduCourse = new EduCourse(
                "123",
                "ee",
                "dffd",
                eDepartment);

        EduCourse eduCourse2 = new EduCourse(
                "123",
                "ee",
                "dffd",
                eDepartment2);

        courses.add(eduCourse2);
        courses.add(eduCourse);

        System.out.println(courses.size());


    }


}
