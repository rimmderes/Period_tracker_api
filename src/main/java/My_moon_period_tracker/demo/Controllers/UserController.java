package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.DTOs.UserToCycleDTO;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get user by Id
    @GetMapping(value="/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Post new user
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User addedUser = userService.addNewUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    // adding cycle to user

    @PatchMapping(value = "/cycle/{userId}/{cycleId}")
    public ResponseEntity<User> addCycletoUser (@PathVariable long userId, @PathVariable long cycleId) {
        User updatedUser = userService.addCycleToUser(userId, cycleId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // add comment to user
    @PatchMapping(value = "/comment/{id}")
        public ResponseEntity<User> addCommentToUser (@PathVariable long id, @RequestBody UserToCycleDTO userToCycleDTO) {
        long userId = userToCycleDTO.getUserId();
        User updatedCommentUser = userService.addCommentToUser(id, userId);
        return new ResponseEntity<>(updatedCommentUser, HttpStatus.OK);
    }



}
