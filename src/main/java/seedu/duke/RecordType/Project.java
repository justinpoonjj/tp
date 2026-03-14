package seedu.duke.RecordType;

import java.time.YearMonth;

public class Project extends Record {
    public Project(String title, String role, String tech, YearMonth from, YearMonth to) {
        super(title,role,tech,from,to);
    }
}
