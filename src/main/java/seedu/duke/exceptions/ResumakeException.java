package seedu.duke.exceptions;

/**
 * Represents application-specific checked exceptions in ResuMake.
 */
public class ResumakeException extends Exception {
    /**
     * Creates a ResumakeException with a user-facing message.
     *
     * @param message Exception message.
     */
    public ResumakeException(String message) {
        super(message);
    }
}
