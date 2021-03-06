package connect.entities;


import connect.repository.EShift;
import connect.repository.enums.CustomException;
import connect.repository.enums.Error;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "class")
public class EduClass {

    public List<Error> errorList = new ArrayList<>();



    @Nullable
    private final Integer attachedClassId;

    private final Integer classId;

    private final String courseId;

    private final Integer credit;
    @Nullable
    private final String note;
    @Nullable
    private final DayOfWeek dayOfWeek;
    @Nullable
    private final Integer startTime;
    @Nullable
    private final Integer endTime;

    private final EShift shift;
    @Nullable
    private final String weeks;
    @Nullable
    private final String room;
    private final boolean needExperiment;
    @Nullable
    private final Integer numRegistration;
    @Nullable
    private final Integer maxQuantity;

    private final String status, classType, managementId;
    @Id
    private BigInteger id;
    @Transient
    @Getter(value = AccessLevel.NONE)
    private List<Integer> weeksList = null;

    public EduClass(
            Integer classId,
            @Nullable Integer attachedClassId,
            String courseId,
            Integer credit,
            @Nullable String note,
            @Nullable DayOfWeek dayOfWeek,
            @Nullable Integer startTime,
            @Nullable Integer endTime,
            @Nullable EShift shift,
            @Nullable String weeks,
            @Nullable String room,
            boolean needExperiment,
            @Nullable Integer numRegistration,
            @Nullable Integer maxQuantity,
            @NotNull String status,
            @NotNull String classType,
            @NotNull String managementId
    ) throws CustomException {
        if (classId == null) errorList.add(Error.classId_error);
        if (courseId == null) errorList.add(Error.courseId_error);
        if (credit == null) errorList.add(Error.credit_error);
        if (errorList.size() > 0) throw new CustomException(errorList);
        this.classId = classId;
        this.attachedClassId = attachedClassId;
        this.courseId = courseId;
        this.credit = credit;
        this.note = note;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shift = shift;
        this.weeks = weeks;
        this.room = room;
        this.needExperiment = needExperiment;
        this.numRegistration = numRegistration;
        this.maxQuantity = maxQuantity;
        this.status = status;
        this.classType = classType;
        this.managementId = managementId;
    }

    private static String formatCell(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        String s = formatter.formatCellValue(cell);
        s = StringUtils.deleteWhitespace(s);
        if (StringUtils.equalsIgnoreCase("NULL",s)||StringUtils.equalsIgnoreCase("",s))
            return null;
        return s;
    }

    public static Integer normalizeInteger(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return Integer.parseInt(input);
    }

    public static String normalizeString(Cell cell) {
        return EduClass.formatCell(cell);
    }

    public static EShift normalizeShift(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return EShift.of(input);
    }

    public static DayOfWeek normalizeDayOfWeek(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return DayOfWeek.of(Integer.parseInt(input)-1);
    }

    public static Integer normalizeFisrt(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return Integer.parseInt(StringUtils.substring(input, 0, 1));
    }

    public static Integer normalizeAfterTime(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return Integer.parseInt(StringUtils.substringAfter(input, "-"));
    }

    public static Integer normalizeBeforeTime(Cell cell) {
        String input = EduClass.formatCell(cell);
        if (input == null) {
            return null;
        }
        return Integer.parseInt(StringUtils.substringBefore(input, "-"));
    }

    public static Boolean normalizeBoolean(Cell cell) {
        String input = EduClass.formatCell(cell);
        if(input == null)
            return false;
        return StringUtils.endsWithIgnoreCase("TN", input);
    }

    private List<Integer> convertWeeksToList() {
        // TODO by: datpd
        List<Integer> weeksList = new ArrayList<>();
        String s = StringUtils.deleteWhitespace(this.weeks);
        String[] weeks = s.split("[,.]");
        for (String w : weeks) {
            if (!w.contains("-")) {
                weeksList.add(Integer.parseInt(w));
            } else {
                String[] we = w.split("-");
                int start = Integer.parseInt(we[0]);
                int end = Integer.parseInt(we[1]);
                for (int i = start; i <= end; i++) {
                    weeksList.add(i);
                }
            }
        }
        return weeksList;
    }

    public List<Integer> getWeeksList() {
        if (null == weeksList) {
            weeksList = this.convertWeeksToList();
        }

        return weeksList;
    }

    /**
     * Check the time overlap of 2 classes
     *
     * @param eduClass
     * @return {@code true} if 2 classes overlap, {@code false} if otherwise
     */
    public boolean overlap(@Nullable EduClass eduClass) {
        // TODO by: datpd
        if (null == eduClass) {
            return false;
        }

        if (this == eduClass) {
            return true;
        }
        if (this.endTime == null || this.startTime == null ||
                eduClass.getStartTime() == null || eduClass.getEndTime() == null) {
            return false;
        }

        if (this.endTime < eduClass.getStartTime() ||
                this.startTime > eduClass.getEndTime()) { // Time does not overlap.
            return false;
        } else {
            // Check common elements of 2 list of weeks
            List<Integer> a = this.getWeeksList();
            List<Integer> b = eduClass.getWeeksList();
            int m = 0;
            for (int i : a) {
                for (int k = m; k < b.size(); k++) {
                    if (b.get(k) == i) {
                        return true;
                    }
                    if (b.get(k) > i) {
                        m = k;
                        break;
                    }
                }
            }
        }

        return false;
    }
}