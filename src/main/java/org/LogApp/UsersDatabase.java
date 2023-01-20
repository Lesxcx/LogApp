package org.LogApp;

import java.util.HashMap;

public class UsersDatabase {

    HashMap<String,User> usersClientInfo = new HashMap<>();

    public UsersDatabase(){
        usersClientInfo.put("Admin", new User("Admin1!", "admin"));
        usersClientInfo.put("Kasia", new User("Hasło1!", "user"));
        usersClientInfo.put("Nikodem", new User("Ps1!","user"));
    }
    public UsersDatabase(String login, String password, String role) {
        usersClientInfo.put(login, new User(password, role));
    }

}
