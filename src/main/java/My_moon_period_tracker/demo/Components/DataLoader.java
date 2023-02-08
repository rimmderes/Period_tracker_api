package My_moon_period_tracker.demo.Components;

import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import My_moon_period_tracker.demo.Services.ArticleService;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static My_moon_period_tracker.demo.Enums.Tag.FEMALE_HEALTH;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception{

        User eoan = new User("Eoan", "password", "eoan@gmail", LocalDate.of(1994, 7, 1));
        userService.addNewUser(eoan);

        User amy = new User("Amy", "confirmpassword", "amy@hotmail", LocalDate.of(1999, 4, 3));
        userService.addNewUser(amy);

        Article womenHealth = new Article("How to have good health", "lorem ispum ...", LocalDate.of(2023, 2, 8),
                FEMALE_HEALTH);
        articleRepository.save(womenHealth);
        articleService.likeArticle(eoan.getId(), womenHealth.getId());

       
    }


}
