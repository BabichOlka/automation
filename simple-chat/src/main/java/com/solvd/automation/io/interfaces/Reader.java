package com.solvd.automation.io.interfaces;

import com.solvd.automation.io.exception.UnableToCloseExcepton;
import com.solvd.automation.io.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton, UnableToCloseExcepton, UnableToReadException;
}
