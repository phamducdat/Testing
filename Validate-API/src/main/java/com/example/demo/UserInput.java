package com.example.demo;

import com.example.demo.validation.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {
    @NotNull
    @Size(min = 1, max = 60)
    private String lastName;

    @Size(max = 60)
    private String middleName;

    @NotNull(message = "{user.firstName.notNull}")
    @Size(min = 1, max = 60, message = "{user.firstName.size}")
    private String firstName;

    @NotNull(message = "{user.dateOfBirth.notNull}")
    @Past(message = "{user.dateOfBirth.past}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate dateOfBirth;

    @NotNull
    @PositiveOrZero
    private Integer siblings;

    @Size(max = 60)
    @UUID
    private String text;
    //Test case : "text":"009692ee-f930-4a74-bbd0-63b8baa5a" this is not UUID
    //Test case: "text":"009692ee-f930-4a74-bbd0-63b8baa5a927" this is UUID
}
