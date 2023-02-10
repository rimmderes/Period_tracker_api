package My_moon_period_tracker.demo.Components;

import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import My_moon_period_tracker.demo.Services.ArticleService;
import My_moon_period_tracker.demo.Services.CommentService;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static My_moon_period_tracker.demo.Enums.Emotion.*;
import static My_moon_period_tracker.demo.Enums.Flow.*;
import static My_moon_period_tracker.demo.Enums.Symptom.*;
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

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentService commentService;

    public DataLoader(CycleRepository cycleRepository,
                      UserRepository userRepository,
                      CommentRepository commentRepository){
        this.cycleRepository = cycleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // users

        User eoan = new User("Eoan", "password", "eoan@gmail.com", LocalDate.of(1997, 7, 1));
        userService.addNewUser(eoan);


        User amy = new User("Amy", "confirmpassword", "amy@hotmail.com", LocalDate.of(1999, 4, 3));
        userService.addNewUser(amy);


        User georgia = new User("Georgia", "clarke", "georgia@hotmail.com", LocalDate.of(2000, 4, 5));
        userService.addNewUser(georgia);


        User rebecca = new User("Rebecca", "solomon", "rebecca@hotmail.com", LocalDate.of(1999, 12, 31));
        userService.addNewUser(rebecca);


        User rimm = new User("Rimm", "Deres", "rimm@gmail.com", LocalDate.of(1999, 11, 1));
        userService.addNewUser(rimm);


        User khalil = new User("Khalil", "Hersi", "khalil@gmail.com", LocalDate.of(1994, 8, 6));
        userService.addNewUser(khalil);




        //articles

        Article womenHealth = new Article("How-to-have-good-health", "lorem ispum ...", LocalDate.of(2023, 2, 8),
                FEMALE_HEALTH);
        articleRepository.save(womenHealth);

        articleService.likeArticle(1, 1);



        Article menstruation = new Article("Menstruation tips", "lorem ispum ...", LocalDate.of(2022, 9, 5),
                MENSTRUATION);
        articleRepository.save(menstruation);

        articleService.likeArticle(5, 2);


        Article pregnancy = new Article("Your pregnancy journey", "lorem ispum ...", LocalDate.of(2021, 2, 14), PREGNANCY);
        articleRepository.save(pregnancy);

        articleService.likeArticle(4, 3);



        Article youngGirls = new Article("For the girlies", "lorem ispum ...", LocalDate.of(2020, 6, 22),
                YOUNG_GIRLS);
        articleRepository.save(youngGirls);
        articleService.likeArticle(3, 4);




        Article menopause = new Article("For the older ladies", "lorem ispum ...", LocalDate.of(2023, 1, 26),
                MENOPAUSE);
        articleRepository.save(menopause);
        articleService.likeArticle(2, 5);





        // likes
//        articleService.getNumberOfLikesFromArticle(womenHealth.getId());
//        articleService.getNumberOfLikesFromArticle(menstruation.getId());
//        articleService.getNumberOfLikesFromArticle(pregnancy.getId());
//        articleService.getNumberOfLikesFromArticle(youngGirls.getId());
//        articleService.getNumberOfLikesFromArticle(menopause.getId());


        // comments
        Comment comment1 = new Comment(amy, womenHealth, "Love this!", LocalDate.of(2023, 3, 30));

        commentRepository.save(comment1);
//        articleRepository.save(womenHealth);


//        userService.addCommentToUser(comment1, amy);
//        articleService.addCommentToArticle(comment1, womenHealth);



        Comment comment2 = new Comment(amy, menopause, "Interesting article", LocalDate.of(2023, 4, 30));
//       userService.addCommentToUser(comment2, amy);


        commentRepository.save(comment2);







        // adding cycles to user

        Cycle rimmCycle = new Cycle(LocalDate.of(2023, 1, 22), LocalDate.of(2023, 1, 29),  SAD, ACNE, MEDIUM );
        userService.addCycleToUser(rimmCycle, rimm);
        cycleRepository.save(rimmCycle);

        Cycle rimm2Cycle = new Cycle(LocalDate.of(2022, 12, 27), LocalDate.of(2023, 1, 2),  HAPPY, TENDER_BREASTS, HEAVY, LocalDate.of(2022, 12, 10));
        userService.addCycleToUser(rimm2Cycle, rimm);
        cycleRepository.save(rimm2Cycle);



        Cycle amyCycle = new Cycle(LocalDate.of(2022, 11, 28), LocalDate.of(2022, 12, 1),  ENERGETIC, CRAVINGS, LIGHT, LocalDate.of(2022, 10, 10));
        userService.addCycleToUser(amyCycle, amy);
        cycleRepository.save(amyCycle);



        Cycle georgiaCycle = new Cycle(LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 8),   FRISKY, HEADACHE, SUPER_HEAVY, LocalDate.of(2023, 1, 1) );

        userService.addCycleToUser(georgiaCycle, georgia);
        cycleRepository.save(georgiaCycle);



        Cycle rebeccaCycle = new Cycle(LocalDate.of(2022, 9, 7), LocalDate.of(2022, 9, 11),  IRRITATED, FATIGUE, SUPER_HEAVY);
        userService.addCycleToUser(rebeccaCycle, rebecca);
        cycleRepository.save(rebeccaCycle);

        Cycle rebecca2Cycle = new Cycle(LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 9),  ANXIOUS, BACKACHE, HEAVY);
        userService.addCycleToUser(rebecca2Cycle, rebecca);
        cycleRepository.save(rebecca2Cycle);

        Cycle rebecca3Cycle = new Cycle(LocalDate.of(2022, 10, 30), LocalDate.of(2022, 11, 3),  CALM, BACKACHE, LIGHT);
        userService.addCycleToUser(rebecca3Cycle, rebecca);
        cycleRepository.save(rebecca3Cycle);

        Cycle rebecca4Cycle = new Cycle(LocalDate.of(2022, 11, 26), LocalDate.of(2022, 11, 30),  MOOD_SWINGS, FATIGUE, MEDIUM);
        userService.addCycleToUser(rebecca4Cycle, rebecca);
        cycleRepository.save(rebecca4Cycle);

        Cycle rebecca5Cycle = new Cycle(LocalDate.of(2022, 12, 21), LocalDate.of(2022, 12, 25),  OBSESSIVE_THOUGHTS, BLOATING, HEAVY);
        userService.addCycleToUser(rebecca5Cycle, rebecca);
        cycleRepository.save(rebecca5Cycle);

        Cycle rebecca6Cycle = new Cycle(LocalDate.of(2023, 1, 19), LocalDate.of(2023, 1, 23),  APATHETIC, INSOMNIA, SUPER_HEAVY);
        userService.addCycleToUser(rebecca6Cycle, rebecca);
        cycleRepository.save(rebecca6Cycle);







        userRepository.saveAll(List.of(rimm, amy, eoan, georgia, rebecca));











    }


}
