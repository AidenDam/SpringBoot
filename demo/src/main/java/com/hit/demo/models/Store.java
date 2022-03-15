package com.hit.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "user1", "12345678", "Harry James Potter"));
        users.add(new User(2, "user2", "12345678", "Ronald Bilius Weasley"));
        users.add(new User(3, "user3", "12345678", "Hermione Jean Granger"));
        users.add(new User(4, "user4", "12345678", "Albus Percival Wulfric Brian Dumbledore"));
        users.add(new User(5, "user5", "12345678", "Tom Marvolo Riddle"));
    }

    public static boolean checkAccount(User user) {
        for(User u : users) {
            if(user.equals(u)) {
                return true;
            }
        }
        return false;
    }
}
