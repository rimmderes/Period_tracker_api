package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.DTOs.LoginDTO;
import My_moon_period_tracker.demo.DTOs.SignUpDTO;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenicateUser(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpDTO){
        if(userRepository.existsByEmail(signUpDTO.getEmail())){
            return new ResponseEntity<>("Email is already registered!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(signUpDTO.getName());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        user.setDOB(signUpDTO.getDOB());

        userRepository.save(user);

        return new ResponseEntity<>("Congrats, you're now a member of My Moon!", HttpStatus.OK);
    }
}
