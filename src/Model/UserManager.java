package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable {

    private static ArrayList<User> users = new ArrayList<>();

    static int id = 0;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User findUser(String name) {

        User userToReturn = null;
        for (User user: users) {
            if (user.getUserName().trim().equalsIgnoreCase(name)) {
                userToReturn = user;
            }
        }
        return userToReturn;
    }

    public static void addUsers(User user) {
        if (!users.contains(user)) {
            users.add(user);
        } else {
            System.out.println("user is already registered.");
        }
    }
}
