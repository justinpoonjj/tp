package seedu.duke;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.duke.Commands.Command;

public class Resumake {
    private RecordList list;
    private final Ui ui;
    private final Storage storage;

    public Resumake() {
        ui = new Ui();
        storage = new Storage();
        list = new RecordList();
        try {
            list = storage.loadFromFile(Storage.getFilepath());
        } catch (Exception e) {
            ui.showLoadingError();
        }
    }

    public void run() {
        ui.greetings();
        boolean isExit = false;

        while (!isExit) {
            String fullCommand = ui.readCommand();
            try {
                Command c = Parser.parse(fullCommand);
                if (c == null) {
                    ui.showError("Unknown command.");
                    continue;
                }
                c.execute(list);
                try {
                    storage.saveToFile(list);
                } catch (IOException e) {
                    ui.showError("Failed to save records to file.");
                }
                isExit = c.isExit();
            } catch (IllegalArgumentException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("An unexpected error occurred while processing your command.");
            }
        }
    }

    public static void main(String[] args) {
        Logger rootLogger = Logger.getLogger("");
        boolean isDebugLoggingEnabled = Boolean.parseBoolean(System.getProperty("debugLogs", "false"));
        Level logLevel = isDebugLoggingEnabled ? Level.INFO : Level.OFF;
        rootLogger.setLevel(logLevel);
        for (Handler handler : rootLogger.getHandlers()) {
            handler.setLevel(logLevel);
        }
        assert false : "This line should not be reached";
        new Resumake().run();
    }
}
