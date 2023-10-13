package com.example.transfer_money_API.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private final String path;

    public Logger(String path) {
        this.path = path;
    }

    public void log(String messageToLog) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(path, true))) {
            logWriter.write(messageToLog);
            logWriter.newLine();
            logWriter.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
