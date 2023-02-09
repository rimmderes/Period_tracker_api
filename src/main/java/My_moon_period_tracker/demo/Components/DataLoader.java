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

import static My_moon_period_tracker.demo.Enums.Tag.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ArticleRepository articleRepository;

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // users

        User eoan = new User("Eoan", "password", "eoan@gmail.com", LocalDate.of(1994, 7, 1));
        userService.addNewUser(eoan);

        User amy = new User("Amy", "confirmpassword", "amy@hotmail.com", LocalDate.of(1999, 4, 3));
        userService.addNewUser(amy);

        User georgia = new User("Georgia", "clarke", "georgia@hotmail.com", LocalDate.of(2000, 4, 5));
        userService.addNewUser(georgia);

        User rebecca = new User("Rebecca", "solomon", "rebecca@hotmail.com", LocalDate.of(1999, 12, 31));
        userService.addNewUser(rebecca);

        User rimm = new User("Rimm", "Deres", "rimm@gmail.com", LocalDate.of(1999, 11, 1));
        userService.addNewUser(rimm);


        //articles

        Article womenHealth = new Article("How to have good health", "lorem ispum ...", LocalDate.of(2023, 2, 8),
                FEMALE_HEALTH);
        articleRepository.save(womenHealth);
        articleService.likeArticle(eoan.getId(), womenHealth.getId());

        Article menstruation = new Article("Menstruation tips", "lorem ispum ...", LocalDate.of(2022, 9, 5),
                MENSTRUATION);
        articleRepository.save(menstruation);
        articleService.likeArticle(rimm.getId(), menstruation.getId());

        Article pregnancy = new Article("Your pregnancy journey", "lorem ispum ...", LocalDate.of(2021, 2, 14), PREGNANCY);
        articleRepository.save(pregnancy);
        articleService.likeArticle(rebecca.getId(), pregnancy.getId());


        Article youngGirls = new Article("For the girlies", "lorem ispum ...", LocalDate.of(2020, 6, 22),
                YOUNG_GIRLS);
        articleRepository.save(youngGirls);
        articleService.likeArticle(georgia.getId(), youngGirls.getId());


        Article menopause = new Article("For the older ladies", "lorem ispum ...", LocalDate.of(2023, 1, 26),
                MENOPAUSE);
        articleRepository.save(menopause);
        articleService.likeArticle(amy.getId(), menopause.getId());








    }


}
