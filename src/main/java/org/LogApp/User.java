package org.LogApp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String login;
    private String password;
    private String role;


    public User(String password, String role) {
        this.password = password;
        this.role = role;
    }

    public User(String user) {
        Scanner scanner = new Scanner(System.in);
        UsersDatabase usersDatabase = new UsersDatabase();
        boolean validatedLogin = false;
        try {
            while (!validatedLogin) {
                System.out.println("Enter your e-mail.");
                String login = scanner.nextLine();
                if (checkLogin(login)){
                    this.login = login;
                    validatedLogin = true;
                } else {
                    System.out.println("The email should be in the following format: <at least 5 characters>@<domain>.<com or pl>.");
                    System.out.println("Try different e-mail.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        boolean validatedPassword = false;
        try {
            while (!validatedPassword) {
                System.out.println("Enter your password");
                password = scanner.nextLine();
                if (checkPassword(password)) {
                    this.password = password;
                    validatedPassword = true;
                } else {
                    System.out.println("Yor password must have at least one upper case, one special symbol and one number");
                    System.out.println("Try a different password");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            if (usersDatabase.usersClientInfo.get(user).getRole().equals("admin")) {
                System.out.println("Set up role for new user.");
                String newRole = scanner.nextLine();
                this.role = setRoleAdmin(newRole);
            } else {this.role = "user";}
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile(".{5,}@.+\\.pl");
        Pattern pattern1 = Pattern.compile(".{5,}@.+\\.com");
        Matcher matcher = pattern.matcher(login);
        Matcher matcher1 = pattern1.matcher(login);
        return matcher.matches() || matcher1.matches();
    }
    public static boolean checkPassword(String password) {

        boolean hasNumber = false, hasCap = false, hasLow = false, hasSpecial = false;
        char c;
//        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
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
            if(hasNumber && hasCap && hasLow && hasSpecial) {
                return true;
            }
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    private String setRoleAdmin(String role) {
        this.role = role;
        return role;
    }
}
