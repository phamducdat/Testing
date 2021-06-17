package com.example.demo;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

public class TestUUID {

    private final static Pattern UUID_REGEX_PATTERN =
            Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

    public static boolean isValidUUID(String str) {
        if (str == null) {
            return false;
        }
        System.out.println("It is UUID");
        return UUID_REGEX_PATTERN.matcher(str).matches();
    }
    public static void CheckUUID(String str) {
        try {
            UUID uuid = UUID.fromString(str);
            System.out.print("Valid");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.print("InValid");
        }
    }

    public static void main(String[] args) {
        TestUUID.isValidUUID("009692ee-f930-4a7-bbd0-63b8baa5a927");

        TestUUID.CheckUUID("009692ee-f930-4a7-bbd0-63b8b");
    }
}
