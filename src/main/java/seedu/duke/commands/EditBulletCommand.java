/**
 * Represents a command that edits an existing bullet point in a record.
 *
 * <p>The user specifies the record index and bullet index (both 1-based),
 * along with the new bullet content.</p>
 *
 * <p>This command does not change the number of bullets in the record,
 * only replaces the content of an existing bullet.</p>
 */

package seedu.duke.commands;

import java.util.logging.Logger;

import seedu.duke.RecordList;
import seedu.duke.Ui;
import seedu.duke.exceptions.ResumakeException;
import seedu.duke.recordtype.Record;

public class EditBulletCommand extends Command {
    private static final Logger logger = Logger.getLogger(EditBulletCommand.class.getName());

    private final int userRecordIndex;
    private final int userBulletIndex;
    private final String newBullet;
    private final Ui ui;

    /**
     * Constructs an EditBulletCommand.
     *
     * @param userRecordIndex The 1-based index of the record.
     * @param userBulletIndex The 1-based index of the bullet within the record.
     * @param newBullet       The new content for the bullet.
     * @param ui              The Ui instance for output (if null, creates default
     *                        Ui).
     *
     * @throws IllegalArgumentException If indices are non-positive or bullet is
     *                                  blank.
     */

    public EditBulletCommand(int userRecordIndex, int userBulletIndex, String newBullet, Ui ui) {
        if (userRecordIndex <= 0) {
            throw new IllegalArgumentException("Record index must be positive (1-based)");
        }
        if (userBulletIndex <= 0) {
            throw new IllegalArgumentException("Bullet index must be positive (1-based)");
        }
        if (newBullet == null || newBullet.trim().isEmpty()) {
            throw new IllegalArgumentException("Bullet text cannot be blank");
        }

        this.userRecordIndex = userRecordIndex;
        this.userBulletIndex = userBulletIndex;
        this.newBullet = newBullet.trim();
        this.ui = ui == null ? new Ui() : ui;

        logger.info("EditBulletCommand created for record index=" + userRecordIndex
                + ", bullet index=" + userBulletIndex);
    }

    public int getUserRecordIndex() {
        return userRecordIndex;
    }

    public int getUserBulletIndex() {
        return userBulletIndex;
    }

    public String getNewBullet() {
        return newBullet;
    }

    /**
     * Executes the bullet edit operation on the given RecordList.
     *
     * <p>
     * The specified bullet in the target record will be replaced
     * with the new content.
     * </p>
     *
     * <p>
     * If the record index or bullet index is invalid, or the new bullet
     * content is invalid, a ResumakeException will be thrown.
     * </p>
     *
     * @param list The RecordList containing records.
     * @throws ResumakeException If the operation fails due to invalid indices
     *                           or invalid bullet content.
     */

    @Override
    public void execute(RecordList list) throws ResumakeException {
        if (list == null) {
            throw new IllegalArgumentException("RecordList cannot be null");
        }

        logger.info("Executing EditBulletCommand for record index=" + userRecordIndex
                + ", bullet index=" + userBulletIndex);

        try {
            Record record = list.getRecord(userRecordIndex - 1);
            if (record == null) {
                throw new ResumakeException("Invalid record index.");
            }

            logger.fine("Editing bullet in record: " + record.getTitle());

            try {
                record.editBullet(userBulletIndex - 1, newBullet);
            } catch (IndexOutOfBoundsException e) {
                logger.warning("Bullet edit failed for record index=" + userRecordIndex
                        + ", bullet index=" + userBulletIndex + " (bullet out of bounds)");
                throw new ResumakeException("Invalid bullet index.");
            }

            logger.info("Bullet edit succeeded for record index=" + userRecordIndex
                    + ", bullet index=" + userBulletIndex);

            ui.showLine();
            ui.showMessage("Edited bullet " + userBulletIndex + " in record " + userRecordIndex);
            ui.showLine();
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Bullet edit failed for record index=" + userRecordIndex
                    + ", bullet index=" + userBulletIndex + " (record out of bounds)");
            throw new ResumakeException("Invalid record index.");
        } catch (IllegalArgumentException e) {
            logger.warning("Bullet edit failed: " + e.getMessage());
            throw new ResumakeException(e.getMessage());
        }
    }
}
