package seedu.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.duke.RecordType.Record;

public class RecordListTest {
    @Test
    public void addRecord_recordAdded_sizeIncreases() {
        RecordList recordList = new RecordList();
        seedu.duke.RecordType.Record record = new Record("Test record");

        recordList.add(record);

        assertEquals(1,recordList.getSize());
        assertEquals(record, recordList.getRecord(0));
    }
}
