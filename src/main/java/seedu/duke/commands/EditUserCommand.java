package seedu.duke.commands;

import static seedu.duke.User.promptForEmail;
import static seedu.duke.User.promptForName;
import static seedu.duke.User.promptForNumber;

import seedu.duke.RecordList;
import seedu.duke.Ui;
import seedu.duke.User;
import seedu.duke.exceptions.ResumakeException;

public class EditUserCommand extends Command {
    private static final int MAX_ATTEMPTS = 4;
    private final String field;
    private final Ui ui;

    public EditUserCommand(String field) throws ResumakeException {
        this(field, new Ui());
    }

    public EditUserCommand(String field, Ui ui) throws ResumakeException {
        if (!isValidField(field)) {
            throw new ResumakeException("Invalid User Field. Must be name, number or email.");
        }
        this.field = field;
        this.ui = ui == null ? new Ui() : ui;
    }

    private boolean isValidField(String field) {
        return "name".equals(field) || "number".equals(field) || "email".equals(field);
    }

    @Override
    public void execute(RecordList list) throws ResumakeException {
        User user = User.getInstance();

        ui.showMessage("Current " + field + ": " + getCurrentValue(user));
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            ui.showMessage("Enter new " + field + ":");
            String newValue = ui.readCommand();

            try {
                user.editField(field, newValue);
                ui.showMessage("Updated " + field + " to: " + getCurrentValue(user));
                return;
            } catch (ResumakeException e) {
                int attemptsLeft = MAX_ATTEMPTS - attempt - 1;
                if (attemptsLeft > 0) {
                    ui.showError(e.getMessage() + " You have " + attemptsLeft + " more chance"
                            + (attemptsLeft == 1 ? "" : "s") + ".");
                } else {
                    throw new ResumakeException(
                            "You have exhausted all your attempts. edituser exited. "
                                    + "If you would like to try editing the user profile, enter \"edituser\" again.");
                }
            }
        }
    }

    private String getCurrentValue(User user) {
        switch (field.toLowerCase()) {
        case "name":
            return user.getName();
        case "number":
            return String.valueOf(user.getNumber());
        case "email":
            return user.getEmail();
        default:
            return "unknown";
        }
    }

    private String promptUserField(User user) {
        switch (field.toLowerCase()) {
        case "name":
            return promptForName();
        case "number":
            return Integer.toString(promptForNumber());
        case "email":
            return promptForEmail();
        default:
            return "unknown";
        }
    }

}
