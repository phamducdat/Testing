package menthod.trycatch.Real;

import org.springframework.validation.Errors;

public enum Error {
    INTEGER_ERROR(0, "ONE"),
    STRING_ERROR(1, "TWO"),
    BOOLEAN_ERROR(2,"THREE");


    private final int code;
    private final String description;

    Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
