package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private CycleRepository cycleRepository;
    @Autowired
    private CommentRepository commentRepository;

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

    public void addCycleToUser (Cycle cycle, User user) {
        user.getCycles().add(cycle);
    }

    // delete user
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    // add cycle to user

    public User addCycleToUser (long userId, long cycleId) {
        User user = userRepository.findById(userId).get();
        Cycle cycle = cycleRepository.findById(cycleId).get();
        List <Cycle> cycleList = user.getCycles();
        cycleList.add(cycle);
        user.setCycles(cycleList);
        userRepository.save(user);
        return user;
    }

    public void  addCommentToUser (Comment comment, User user) {
        user.getComments().add(comment);
    }




}
