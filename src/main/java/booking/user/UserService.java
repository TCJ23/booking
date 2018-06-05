package booking.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public User createUser(String username, String firstname, String lastname, String email) {
        User user1 = new User(username, firstname, lastname, email);
        userList.add(user1);
        return user1;
    }


}

