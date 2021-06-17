package connect.entities;


import connect.repository.EDepartment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Getter
@ToString
@Document(collection = "course")
public class EduCourse {

        //@MongoId, khi test tren project thi khong luu duoc
        @Id
        private final String id; // MÃ_HP

        private final String name, eName; //TÊN_HP, TÊN_HP_TIẾNG_ANH

        private final EDepartment department; // KHOA_VIỆN

        /**
         * Creates a new {@link EduCourse} from the given id, name, eName and department.
         *
         * @param id         must not be {@code null} or empty
         * @param name       must not be {@code null} or empty
         * @param eName      must not be {@code null} or empty
         * @param department must not be {@code null} or empty
         */
        public EduCourse(
                String id, String name, String eName, EDepartment department
        ) {
                this.id = id;
                this.name = name;
                this.eName = eName;
                this.department = department;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {

                if (this == obj) {
                        return true;
                }

                if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
                        return false;
                }

                EduCourse that = (EduCourse) obj;

                return this.id.toUpperCase().equals(that.getId().toUpperCase());
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
                return id == null ? 0 : id.hashCode();
        }

        private static String formatCell(Cell cell) {
                DataFormatter formatter = new DataFormatter();
                String s = formatter.formatCellValue(cell);
                s = StringUtils.deleteWhitespace(s);
                return s;
        }

        public static String normalizeString(Cell cell) {
                return EduCourse.formatCell(cell);
        }

        public static EDepartment normalizeDepartment(Cell cell){
                String input = EduCourse.formatCell(cell);
                if (input == null) {
                        return null;
                }
                return EDepartment.of(input);
        }


}
