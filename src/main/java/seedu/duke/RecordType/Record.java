package seedu.duke.RecordType;

import java.time.YearMonth;

public class Record {
    protected String title;
    protected String role;
    protected String tech;
    protected YearMonth from;
    protected YearMonth to;

    public Record(String title, String role, String tech, YearMonth from, YearMonth to) {
        this.title = title;
        this.role = role;
        this.tech = tech;
        this.from = from;
        this.to = to;
    }

    public boolean containsKeyword(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String toString() {
        return title;
    }

    public void setDescription(String description) {
        this.title = description;
    }
}