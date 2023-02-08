package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikesService {

    User user;

    public Optional<User> checkIfUserHasLikes() {
        if (user.getArticles().isEmpty()){
            return null;
        } else {
            return user.getArticles().size();
        }
    }

}
