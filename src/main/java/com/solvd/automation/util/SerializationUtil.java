package com.solvd.automation.util;

import com.solvd.automation.io.exception.UnableToReadException;
import com.solvd.automation.io.exception.UnableToWriteException;
import com.solvd.automation.io.impl.stream.ObjectReader;
import com.solvd.automation.io.impl.stream.ObjectWriter;
import com.solvd.automation.io.interfaces.Packable;

public class SerializationUtil {
    private String dataFilePath  = System.getProperty("user.dir") + "\\src\\serial";
    private String dataFileResponse = System.getProperty("user.dir") + "\\src\\serial_response";

    private static ObjectReader objectReader;
    private static  ObjectReader objectReaderResponse;

    public SerializationUtil(String dataFilePath, String dataFileResponse) {
        this.dataFilePath = dataFilePath;
        this.dataFileResponse = dataFileResponse;

        this.objectReader = new ObjectReader(dataFilePath);
        this.objectReaderResponse = new ObjectReader(dataFileResponse);
    }

    public void writeObject(Packable obj) {
        try {
            new ObjectWriter().write(dataFilePath, obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", dataFilePath));
        }
    }

    public Packable readObject() {
        try {
            return objectReader.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", dataFilePath));
        }

    }

    public Packable readResponse() {
        try {
            return objectReaderResponse.read();
        } catch (UnableToReadException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to read!", dataFileResponse));
        }

    }

    public void writeResponse(Packable obj) {
        try {
            new ObjectWriter().write(dataFileResponse, obj);
        } catch (UnableToWriteException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("%s is unable to write!", dataFileResponse));
        }
    }

}