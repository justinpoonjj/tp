package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.YearMonth;
import seedu.duke.RecordType.*;

public class EditCommandTest {

    @Test
    public void execute_validIndex_recordDescriptionUpdated() {
        RecordList recordList = new RecordList();
        seedu.duke.RecordType.Record record = new seedu.duke.RecordType.Record("Old description", "title", "role", "tech", "2019-10", 2019-02);
        recordList.add(record);

        EditCommand editCommand = new EditCommand(0, "New description");
        editCommand.execute(recordList);

        assertEquals("New description", record.description);
    }

    @Test
    public void execute_validIndexOnlyTargetRecordUpdated() {
        RecordList recordList = new RecordList();
        seedu.duke.RecordType.Record firstRecord = new seedu.duke.RecordType.Record("First record");
        seedu.duke.RecordType.Record secondRecord = new seedu.duke.RecordType.Record("Second record");
        recordList.add(firstRecord);
        recordList.add(secondRecord);

        EditCommand editCommand = new EditCommand(1, "Updated second record");
        editCommand.execute(recordList);

        assertEquals("First record", firstRecord.description);
        assertEquals("Updated second record", secondRecord.description);
    }

    @Test
    public void execute_validIndex_sizeRemainsSame() {
        RecordList recordList = new RecordList();
        recordList.add(new Record("Record one"));

        EditCommand editCommand = new EditCommand(0, "Edited record one");
        editCommand.execute(recordList);

        assertEquals(1, recordList.getSize());
    }
}