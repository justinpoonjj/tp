package seedu.duke;

import seedu.duke.RecordType.Record;

public class AddCommand extends Command{
    private final Record r;

    public AddCommand(Record r) {
        this.r = r;
    }

    @Override
    public void execute(RecordList list) {
        list.add(r);
        System.out.println(r.toString() + "added");
    }
}
