package com.solvd.automation.io.interfaces;

import com.solvd.automation.io.exception.UnableToReadException;

public interface StreamReader {
    Packable read() throws UnableToReadException;
}