package automation.io.interfaces;

import automation.io.exception.UnableToCloseExcepton;
import automation.io.exception.UnableToReadException;
import automation.io.exception.UnableToCloseExcepton;
import automation.io.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton, UnableToCloseExcepton, UnableToReadException;
}
