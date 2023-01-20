package org.LogApp;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogApp {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    public String userName;
    public TreeMap<Integer, Log> logs = new TreeMap<>();
    public LogApp() throws InputMismatchException{
        Log firstLog = new Log("This is first log. Made by Admin.", "Admin");
        Log secondLog = new Log("This is second log. Made by Kasia.", "Kasia");
        logs.put(logs.size() + 1, firstLog);
        logs.put(logs.size() + 1, secondLog);
        UsersDatabase usersDatabase = new UsersDatabase();
        boolean decToExit = true;

        while (decToExit) {
            boolean decToSingOut = true;
            System.out.println("Enter your user name");
            userName = s.nextLine();
            if (usersDatabase.usersClientInfo.containsKey(userName)) {

                System.out.println("Enter your password");
                String password = s.nextLine();

                if (password.equals(usersDatabase.usersClientInfo.get(userName).getPassword())) {
                    try {
                        while (decToSingOut) {
                            appMenuIfSingIn();
                            byte dec1 = sc.nextByte();
                            switch (dec1) {
                                case 1 -> {
                                    try{getLogs();} catch (NullPointerException e) {System.out.println(e.getMessage());}
                                }
                                case 2 -> {
                                    try {
                                        System.out.println("Write your log message.");
                                        String message = s.nextLine();
                                        Log newLog = new Log(message, userName);
                                        logs.put(logs.lastKey() + 1, newLog);
                                    } catch (NullPointerException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                case 3 -> {
                                    User newUser = new User(userName);
                                    usersDatabase.usersClientInfo.put(newUser.getLogin(), new User(newUser.getPassword(), newUser.getRole()));
                                }
                                case 4 -> decToExit = false;
                                case 5 -> {
                                    if (usersDatabase.usersClientInfo.get(userName).getRole().equals("admin")) {
                                        System.out.println("With log you wanna delete?");
                                        try {
                                            Integer logToDelete = sc.nextInt();
                                            logs.remove(logToDelete);
                                        }  catch (InputMismatchException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } else System.out.println("Only administrator can delete logs!");

                                }
                                case 6 -> decToSingOut = false;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong symbol entered. Enter the number listed in the menu.");
                    }
                } else {
                    System.out.println("Wrong password!");
                }
            } else {
                System.out.println("Wrong user name!");
            }
        }
    }
    public void getLogs() {
        for (Map.Entry<Integer, Log> logsEntry : logs.entrySet()) {
            final Integer logId = logsEntry.getKey();
            final Log logMessage = logsEntry.getValue();

            System.out.println(logId + ": \nTimestamp: " + logMessage.getTimestamp() +
                    "\n Creator: " + logMessage.getCreator() +
                    "\n Message: " + logMessage.getMessage());
        }
    }
    public void appMenuIfSingIn() {
        System.out.println("""
                    What you wanna do?
                     Press '1' for view logs.
                     Press '2' for create log.
                     Press '3' create new user.
                     Press '4' for exit program.
                     Press '5' to delete log.
                     Press '6' for sing out.""");
    }
}
