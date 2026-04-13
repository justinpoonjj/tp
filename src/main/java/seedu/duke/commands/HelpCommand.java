package seedu.duke.commands;

import seedu.duke.RecordList;
import seedu.duke.Ui;

/**
 * Displays a compact help menu containing available commands,
 * their formats, and short descriptions.
 */
public class HelpCommand extends Command {
    private final Ui ui;

    public HelpCommand() {
        this(new Ui());
    }

    public HelpCommand(Ui ui) {
        this.ui = ui == null ? new Ui() : ui;
    }

    @Override
    public void execute(RecordList list) {
        assert list != null : "RecordList should not be null";

        ui.showLine();
        ui.showMessage("Available commands:");
        ui.showMessage("help - Show all available commands.");
        ui.showMessage("list [TYPE] - List records; TYPE can be E, C, or P.");
        ui.showMessage("project TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM - Add a project.");
        ui.showMessage("experience TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM - Add an experience.");
        ui.showMessage("cca TITLE /role ROLE /tech TECH /from YYYY-MM /to YYYY-MM - Add a CCA.");
        ui.showMessage("show RECORD_INDEX - Show one record and its bullets.");
        ui.showMessage("find KEYWORD - Find records by keyword.");
        ui.showMessage("findbullet KEYWORD - Find bullets by keyword.");
        ui.showMessage("addbullet RECORD_INDEX / BULLET_TEXT - Add a bullet to a record.");
        ui.showMessage("edit RECORD_INDEX [NEW_TITLE] [/role NEW_ROLE] [/tech NEW_TECH] "
                + "[/from YYYY-MM] [/to YYYY-MM] - Edit a record.");
        ui.showMessage("editbullet RECORD_INDEX BULLET_INDEX / NEW_BULLET_TEXT - Edit a bullet.");
        ui.showMessage("movebullet RECORD_INDEX FROM_BULLET_INDEX TO_BULLET_INDEX - Move a bullet.");
        ui.showMessage("delete RECORD_INDEX - Delete a record.");
        ui.showMessage("deletebullet RECORD_INDEX BULLET_INDEX - Delete a bullet.");
        ui.showMessage("sort - Sort records by title.");
        ui.showMessage("generate - Generate a resume view.");
        ui.showMessage("edituser FIELD - Edit user details (name, number, email).");
        ui.showMessage("bye - Exit ResuMake.");
        ui.showLine();
    }
}
