package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // get all users

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    // add new user
    public User addNewUser (User user) {
        userRepository.save(user);
        return user;
    }

    // delete user
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }




}
