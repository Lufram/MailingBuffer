package requirem.second;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Producer extends Thread {

    private String name;
    private Buffer buffer;
    // Constructor
    public Producer (String sender, Buffer buffer) { 
        super();
        this.name = name;
        this.buffer = buffer;
        Thread.setName(name);
    }
    // Getters
    public  String getSender() {
        return name;
    }
    public  String getBuffer() {
        return buffer;
    }

    // Setters
    public void setSender(String sender) {
        this.name = name;
    }
    public void setBuffer(String sender) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
       
       
    }
}