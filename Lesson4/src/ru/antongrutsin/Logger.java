package ru.antongrutsin;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class Logger {
    private FileWriter writer;

    public void writeLog(String tfMessage){
        try {
            writer = new FileWriter("chatLog.txt", true);
            Date date = new Date();
            writer.write(date.toString() + ": " + tfMessage);
            writer.append('\n');
            writer.flush();
            writer.close();
        } catch (IOException ex){
            throw new RuntimeException("IOException: " + ex.getMessage());
        }
    }
}

