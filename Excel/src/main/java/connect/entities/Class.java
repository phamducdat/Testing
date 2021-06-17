package connect.entities;



import lombok.Getter;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigInteger;
import java.time.DayOfWeek;

@Getter
@Setter
@Document(collection = "class")
public class Class {
    @Id

    private Integer classId;
    private Integer attachedClassId;
    private String courseId;
    private String credit;
    private String note;
    private Integer dayOfWeek;
    private String startTime;
    private String endTime;
    private String shift;
    private String weeks;
    private String room;
    private String needExperiment;
    private String numRegistration;
    private Integer maxQuantity;
    private String status, classType, managementId;

}
