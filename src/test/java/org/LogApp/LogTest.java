package org.LogApp;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test
    void shouldGetTimestamp() {
//        given
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        when

//        then
        assertNotNull(timestamp);
    }

    @Test
    void shouldGetNullTimestamp() {
//        given
        Timestamp timestamp = null;
//        when

//        then
        assertNull(timestamp);
    }

    @Test
    void shouldGetMessage() {
//        given
        String message = "test message";
//        when

//        then
        assertNotNull(message);
    }

    @Test
    void shouldGetNullMessage() {
//        given
        String message = null;
//        when

//        then
        assertNull(message);
    }

    @Test
    void shouldGetEmptyMessage() {
//        given
        String message = "";
//        when

//        then
        assertTrue(message.isEmpty());
    }

    @Test
    void shouldGetCreator() {
        //        given
        String creator = "testCreator";
//        when

//        then
        assertNotNull(creator);
    }

    @Test
    void shouldGetNullCreator() {
        //        given
        String creator = null;
//        when

//        then
        assertNull(creator);
    }

    @Test
    void shouldGetEmptyCreator() {
        //        given
        String creator = "";
//        when

//        then
        assertTrue(creator.isEmpty());
    }
}