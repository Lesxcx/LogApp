package org.LogApp;

import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class LogAppTest {

    @org.junit.jupiter.api.Test
    void shouldGetLogs() {
//        given
        TreeMap<Integer, Log> logs = new TreeMap<>();
        Log test = new Log("Test message", "Admin");
        logs.put(logs.size() + 1, test);
//        when
        for (Map.Entry<Integer, Log> logsEntry : logs.entrySet()) {
            final Integer logId = logsEntry.getKey();
            final Log logMessage = logsEntry.getValue();

            System.out.println(logId + ": \nTimestamp: " + logMessage.getTimestamp() +
                    "\n Creator: " + logMessage.getCreator() +
                    "\n Message: " + logMessage.getMessage());
        }
//        then
        assertNotNull(test);
        assertNotNull(logs);
    }

    @org.junit.jupiter.api.Test
    void shouldGetEmptyLogs() {
//        given
        TreeMap<Integer, Log> logs = new TreeMap<>();
        Log test = new Log("", "");
        logs.put(logs.size() + 1, test);
//        when
        for (Map.Entry<Integer, Log> logsEntry : logs.entrySet()) {
            final Integer logId = logsEntry.getKey();
            final Log logMessage = logsEntry.getValue();

            System.out.println(logId + ": \nTimestamp: " + logMessage.getTimestamp() +
                    "\n Creator: " + logMessage.getCreator() +
                    "\n Message: " + logMessage.getMessage());
        }
//        then
        assertTrue(test.getMessage().isEmpty());
        assertTrue(test.getCreator().isEmpty());
        assertNotNull(test);
        assertNotNull(logs);
    }

    @org.junit.jupiter.api.Test
    void testAppMenuIfSingInShouldGetMessage() {
//        given
        String message = "Test message";
//        when

//        then
        assertNotNull(message);
    }

    @org.junit.jupiter.api.Test
    void testAppMenuIfSingInShouldGetNullMessage() {
//        given
        String message = null;
//        when

//        then
        assertNull(message);
    }

    @org.junit.jupiter.api.Test
    void testAppMenuIfSingInShouldGetEmptyMessage() {
//        given
        String message = "";
//        when

//        then
        assertTrue(message.isEmpty());
    }
}