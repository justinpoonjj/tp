package seedu.duke;

import seedu.duke.recordtype.Record;
import java.util.logging.Logger;
import java.util.logging.Level;

public class EditCommand extends Command {
    private static final Logger logger = Logger.getLogger(EditCommand.class.getName());

    private final int index;
    private final String newDescription;
    private final Ui ui;

    public EditCommand(int index, String newDescription) {
        assert newDescription != null : "New description should not be null";

        this.index = index;
        this.newDescription = newDescription;
        this.ui = new Ui();

        assert this.ui != null : "Ui should be initialized";

        logger.info("EditCommand created with index=" + index
                + ", newDescription=" + newDescription);
    }

    @Override
    public void execute(RecordList list) {
        assert list != null : "RecordList passed to EditCommand should not be null";

        logger.info("Executing EditCommand on index=" + index);

        if (index < 0 || index >= list.getSize()) {
            logger.warning("Invalid index: " + index + ", list size=" + list.getSize());

            ui.showLine();
            ui.showError("Record index is out of range.");
            ui.showLine();
            return;
        }

        Record record = list.getRecord(index);
        assert record != null : "Record at valid index should not be null";

        logger.info("Before edit: " + record.getTitle());

        record.setDescription(newDescription);

        logger.info("After edit: " + newDescription);

        ui.showLine();
        System.out.println("Record " + (index + 1) + " has been updated.");
        ui.showLine();

        logger.info("EditCommand completed successfully for index=" + index);
    }
}