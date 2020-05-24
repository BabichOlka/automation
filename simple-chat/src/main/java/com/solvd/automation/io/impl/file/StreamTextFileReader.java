package com.solvd.automation.io.impl.file;

import com.solvd.automation.io.base.BaseReader;
import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.interfaces.Reader;

import java.io.*;

public class StreamTextFileReader extends BaseReader implements Reader {

    public StreamTextFileReader(File file) {
        super(file);
    }

    public StreamTextFileReader(String path) {
        super(path);
    }

    @Override
    public String read() throws UnableToReadException{
        try(FileInputStream fin = new FileInputStream(this.file)) { // try withou resources
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer);
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnableToReadException(String.format("Could not read %s!", this.path));
    }
}
