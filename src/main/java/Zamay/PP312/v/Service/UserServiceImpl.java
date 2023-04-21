package Zamay.PP312.v.Service;

import Zamay.PP312.v.Model.User;
import Zamay.PP312.v.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Transactional
    @Override
    public User getUser(long id) {
       return userRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void update(long id, User editedUser) {
        editedUser.setId(id);
        userRepository.save(editedUser);
    }
}
