package seedu.duke;
import java.util.ArrayList;
import java.util.Iterator;

import seedu.duke.RecordType.Record;

public class RecordList implements Iterable<seedu.duke.RecordType.Record> {
    private final ArrayList<seedu.duke.RecordType.Record> list;
    private int size;

    public RecordList() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public void add(seedu.duke.RecordType.Record record){
        list.add(record);
        size++;
    }

    public seedu.duke.RecordType.Record getRecord(int index) {
        return list.get(index);
    }

    public Iterator<Record> iterator() {
        return list.iterator();
    }

    public int getSize() {
        return size;
    }

    public void removeIndex(int index) {
        list.remove(index);
        this.size--;
    }
}
