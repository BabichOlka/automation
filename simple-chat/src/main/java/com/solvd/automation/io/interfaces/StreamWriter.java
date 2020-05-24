package com.solvd.automation.io.interfaces;

import com.solvd.automation.io.exception.UnableToWriteException;

public interface StreamWriter {
    void write(String path, Packable pkg) throws UnableToWriteException;
}