package My_moon_period_tracker.demo.Components;

import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import My_moon_period_tracker.demo.Services.ArticleService;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static My_moon_period_tracker.demo.Enums.Emotion.HAPPY;
import static My_moon_period_tracker.demo.Enums.Emotion.SAD;
import static My_moon_period_tracker.demo.Enums.Flow.HEAVY;
import static My_moon_period_tracker.demo.Enums.Flow.MEDIUM;
import static My_moon_period_tracker.demo.Enums.Symptom.ACNE;
import static My_moon_period_tracker.demo.Enums.Symptom.TENDER_BREASTS;
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
    private final CycleRepository cycleRepository;
    private final UserRepository userRepository;

    public DataLoader(CycleRepository cycleRepository,
                      UserRepository userRepository){
        this.cycleRepository = cycleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // users

        User eoan = new User("Eoan", "password", "eoan@gmail.com", LocalDate.of(1994, 7, 1));
        userService.addNewUser(eoan);
        userRepository.save(eoan);

        User amy = new User("Amy", "confirmpassword", "amy@hotmail.com", LocalDate.of(1999, 4, 3));
        userService.addNewUser(amy);
        userRepository.save(amy);

        User georgia = new User("Georgia", "clarke", "georgia@hotmail.com", LocalDate.of(2000, 4, 5));
        userService.addNewUser(georgia);
        userRepository.save(georgia);


        User rebecca = new User("Rebecca", "solomon", "rebecca@hotmail.com", LocalDate.of(1999, 12, 31));
        userService.addNewUser(rebecca);
        userRepository.save(rebecca);


        User rimm = new User("Rimm", "Deres", "rimm@gmail.com", LocalDate.of(1999, 11, 1));
        userService.addNewUser(rimm);
        userRepository.save(rimm);



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



        // likes
        articleService.getNumberOfLikesFromArticle(womenHealth.getId());
        articleService.getNumberOfLikesFromArticle(menstruation.getId());
        articleService.getNumberOfLikesFromArticle(pregnancy.getId());
        articleService.getNumberOfLikesFromArticle(youngGirls.getId());
        articleService.getNumberOfLikesFromArticle(menopause.getId());



        // adding cycles to user

        Cycle rimmCycle = new Cycle(LocalDate.of(2023, 01, 29), LocalDate.of(2023, 01, 22), 2, SAD, ACNE, MEDIUM, rimm);
        userService.addCycleToUser(rimmCycle, rimm);
        cycleRepository.save(rimmCycle);

        Cycle rimm2Cycle = new Cycle(LocalDate.of(2022, 12, 27), LocalDate.of(2023, 01, 2), 0, HAPPY, TENDER_BREASTS, HEAVY, rimm);
        userService.addCycleToUser(rimm2Cycle, rimm);
        cycleRepository.save(rimm2Cycle);
        userRepository.save(rimm);


        // comments














    }


}
