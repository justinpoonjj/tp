package seedu.duke;

import java.time.YearMonth;

public class ParsedFields {
    public final String title;
    public final String role;
    public final String tech;
    public final YearMonth from;
    public final YearMonth to;

    ParsedFields(String title, String role, String tech, YearMonth from, YearMonth to) {
        this.title = title;
        this.role = role;
        this.tech = tech;
        this.from = from;
        this.to = to;
    }
}
