package org.LogApp;

import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    void testCheckLogin() {
        Pattern pattern = Pattern.compile(".{5,}@.+\\.pl");
        assertTrue(pattern.matcher("Testt@git.pl").matches());
        assertFalse(pattern.matcher("test@git.pl").matches());
        assertFalse(pattern.matcher("test.git.pl").matches());
        assertFalse(pattern.matcher("@git.pl").matches());
        assertFalse(pattern.matcher("Tesst.pl").matches());
        assertFalse(pattern.matcher("tesst@pl").matches());
        Pattern pattern1 = Pattern.compile(".{5,}@.+\\.com");
        assertTrue(pattern1.matcher("Testt@git.com").matches());
        assertFalse(pattern1.matcher("test@git.com").matches());
        assertFalse(pattern1.matcher("test.git.com").matches());
        assertFalse(pattern1.matcher("@git.com").matches());
        assertFalse(pattern1.matcher("Tesst.com").matches());
        assertFalse(pattern1.matcher("tesst@com").matches());
    }

    @org.junit.jupiter.api.Test
    void shouldGetCorrectPassword() {
//given
        String password = "Test1!";
        boolean hasNumber = false, hasCap = false, hasLow = false, hasSpecial = false, testCheckPassword = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if(Character.isDigit(c)){
                hasNumber = true;
            } else if(Character.isUpperCase(c)){
                hasCap = true;
            } else if (Character.isLowerCase(c)) {
                hasLow = true;
            } else {
                hasSpecial = true;
            }
        }
//when
        if(hasNumber && hasCap && hasLow && hasSpecial) {
            testCheckPassword = true;
        }
//then
        assertTrue(testCheckPassword);
    }
    @org.junit.jupiter.api.Test
    void shouldGetWrongPassword() {
//given
        String password = "Test1";
        boolean hasNumber = false, hasCap = false, hasLow = false, hasSpecial = false, testCheckPassword = false;
        char c;
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if(Character.isDigit(c)){
                hasNumber = true;
            } else if(Character.isUpperCase(c)){
                hasCap = true;
            } else if (Character.isLowerCase(c)) {
                hasLow = true;
            } else {
                hasSpecial = true;
            }
        }
//when
        if(hasNumber && hasCap && hasLow && hasSpecial) {
            testCheckPassword = true;
        }
//then
        assertFalse(testCheckPassword);
    }


    @org.junit.jupiter.api.Test
    void shouldGetLogin() {
//        given
        String login = "testLogin";
//        when

//        then
        assertNotNull(login);
    }

    @org.junit.jupiter.api.Test
    void shouldGetNullLogin() {
//        given
        String login = null;
//        when

//        then
        assertNull(login);
    }

    @org.junit.jupiter.api.Test
    void shouldGetEmptyLogin() {
//        given
        String login = "";
//        when

//        then
        assertTrue(login.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void shouldGetPassword() {
//        given
        String password = "Password test";
//        when

//        then
        assertNotNull(password);
    }

    @org.junit.jupiter.api.Test
    void shouldGetNullPassword() {
//        given
        String password = null;
//        when

//        then
        assertNull(password);
    }

    @org.junit.jupiter.api.Test
    void shouldGetEmptyPassword() {
//        given
        String password = "";
//        when

//        then
        assertTrue(password.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void shouldGetRole() {
        //        given
        String role = "role test";
//        when

//        then
        assertNotNull(role);
    }

    @org.junit.jupiter.api.Test
    void shouldGetNullRole() {
        //        given
        String role = null;
//        when

//        then
        assertNull(role);
    }

    @org.junit.jupiter.api.Test
    void shouldGetEmptyRole() {
        //        given
        String role = "";
//        when

//        then
        assertTrue(role.isEmpty());
    }
}