package org.LogApp;

import java.sql.Timestamp;

public class Log {
    private final Timestamp timestamp;
    private final String message;
    private final String creator;

    public Log(String message, String userName) {

        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.message = message;
        this.creator = userName;

    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getCreator() {
        return creator;
    }
}
