package Zamay.PP312.v.Service;

import Zamay.PP312.v.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserService {
    public void saveUser(User user);

    public User getUser(long id);

    public List<User> getAllUsers();

    public void delete(long id);

    public void update(long id, User editedUser);
}
