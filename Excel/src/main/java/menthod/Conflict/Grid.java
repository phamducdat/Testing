package menthod.Conflict;

import netscape.security.UserTarget;

import java.awt.image.ImageProducer;
import java.util.*;

public class Grid {

    public static Map<EduClass, LinkedList<EduClass>> replace = new HashMap<>();

    public static void setUp(List<GroupClassOM> classGroups) {
        System.out.println("Size of Group = " + classGroups.size());
        for (GroupClassOM g : classGroups) {
            List<EduClass> classes = g.getClasses();
            System.out.println("Size of classes = " + classes.size());
            Iterator<EduClass> i = classes.iterator();
            while (i.hasNext()) {
                EduClass e = i.next();
                System.out.println("ClassId = " + e.getClassId());
                replace.put(e, new LinkedList<>());
                i.remove();
                System.out.println("Size of classes before = " + classes.size());
                Iterator<EduClass> j = classes.iterator();
                while (j.hasNext()) {
                    EduClass s = j.next();
                    if (e.equals(s)) {
                        System.out.println("e = " + e.getClassId() + " s = " + s.getClassId());
                        replace.get(e).add(s);
                        j.remove();
                        System.out.println("Ok");
                    }
                }


            }

        }

        for (EduClass e : replace.keySet()) {
            System.out.println("With : "+ e.getClassId());
            for (EduClass s : replace.get(e)) {
                System.out.println(s.getClassId());
            }
        }
    }


    public static void main(String[] args) {
//        List<Integer> test = new LinkedList<>();
//
//        test.add(10);
//        test.add(21);
//        test.add(32);
//        test.add(43);
//        test.add(54);
//
//        for (int i = 0; i < test.size(); ++i) {
//            if (i == 0) test.remove(test.get(i));
//            if (test.get(i) % 2 == 0) test.remove(i);
//            System.out.println(test.size());
//            System.out.println(test.get(i));
//        }
//
//        Iterator<Integer> i = test.iterator();
//        while (i.hasNext()) {
//            int s = i.next();
//            System.out.println(s);
//            if (s % 2 == 0) i.remove();
//            System.out.println("Size = " + test.size());
//        }

        EduClass c1 = new EduClass(1);
        EduClass c2 = new EduClass(2);
        EduClass c3 = new EduClass(3);
        EduClass c4 = new EduClass(4);
        EduClass c5 = new EduClass(5);
        EduClass c6 = new EduClass(3);
        EduClass c7 = new EduClass(2);
        EduClass c8 = new EduClass(1);

        List<EduClass> classes = new LinkedList<>();

        classes.add(c1);
        classes.add(c2);
        classes.add(c3);
        classes.add(c4);
        classes.add(c5);
        classes.add(c6);
        classes.add(c7);
        classes.add(c8);

        GroupClassOM g1 = new GroupClassOM("1","2", classes);
        GroupClassOM g2 = new GroupClassOM("2","2", classes);

        List<GroupClassOM> classGroups = new ArrayList<>();
        classGroups.add(g1);
        classGroups.add(g2);

        Grid.setUp(classGroups);


    }
}
