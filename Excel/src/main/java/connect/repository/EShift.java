package connect.repository;



import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum EShift{
    MORNING("SÁNG"),
    AFTERNOON("CHIỀU"),
    EVENING("TỐI");

    private final String description;

    EShift(String description) { this.description = description;}

    public static EShift of(@NotNull String shift) {
        if (null == shift) {
            throw new IllegalArgumentException(
                    "No shift with description \"null\" found, shifts can only be \"SÁNG\",\"CHIỀU\", \"TỐI\"");

        }

        String normalizedShift = StringUtils.deleteWhitespace(shift).toUpperCase();
        switch (normalizedShift) {
            case "SÁNG":
                return MORNING;
            case "CHIỀU":
                return AFTERNOON;
            case "TỐI":
                return EVENING;
            default:
                throw new IllegalArgumentException("No shift with description \"" +
                        shift +
                        "\" found, shifts can only be \"SÁNG\", \"CHIỀU\", \"TỐI\"");
        }

    }
}
