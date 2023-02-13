package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Service
public class UserLoginService implements UserDetailsService {

    private UserRepository userRepository;

    public UserLoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email: " + email));

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
