package My_moon_period_tracker.demo.Components;

import My_moon_period_tracker.demo.Models.*;
import My_moon_period_tracker.demo.Repositories.*;
import My_moon_period_tracker.demo.Services.ArticleService;
import My_moon_period_tracker.demo.Services.CommentService;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DataLoader(CycleRepository cycleRepository,
                      UserRepository userRepository,
                      CommentRepository commentRepository){
        this.cycleRepository = cycleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // users

        Role role = new Role("ROLE_ADMIN");
        roleRepository.save(role);

        User eoan = new User("Eoan", passwordEncoder.encode("password"), "eoan@gmail.com", LocalDate.of(1997, 7, 1));
        userService.addNewUser(eoan);
//
//
        User amy = new User("Amy", passwordEncoder.encode("confirmpassword"), "amy@hotmail.com", LocalDate.of(1999, 4, 3));
        userService.addNewUser(amy);
//
//
        User georgia = new User("Georgia", passwordEncoder.encode("clarke"), "georgia@hotmail.com", LocalDate.of(2000, 4, 5));
        userService.addNewUser(georgia);
//
//
        User rebecca = new User("Rebecca", passwordEncoder.encode("solomon"), "rebecca@hotmail.com", LocalDate.of(1999, 12, 31));
        userService.addNewUser(rebecca);
//
//
        User rimm = new User("Rimm", passwordEncoder.encode("Deres"), "rimm@gmail.com", LocalDate.of(1999, 11, 1));
        userService.addNewUser(rimm);
//
//
        User khalil = new User("Khalil", passwordEncoder.encode("Hersi"), "khalil@gmail.com", LocalDate.of(1994, 8, 6));
        userService.addNewUser(khalil);
//
        User jade = new User("Jane", passwordEncoder.encode("doe"), "janedoe@gmail.com", LocalDate.of(2008, 9, 21));
        userService.addNewUser(jade);




        //articles

        Article womenHealth = new Article("Feminine Hygiene and Health", "lorem ispum ...", LocalDate.of(2023, 2, 1),
                FEMALE_HEALTH);
        articleRepository.save(womenHealth);

        articleService.likeArticle(2, 1);
        articleService.likeArticle(4, 1);



        Article menstruation = new Article("Menstruation tips", "lorem ispum ...", LocalDate.of(2022, 9, 5),
                MENSTRUATION);
        articleRepository.save(menstruation);

        articleService.likeArticle(5, 2);
        articleService.likeArticle(3, 2);
        articleService.likeArticle(6, 2);



        Article pregnancy = new Article("Your pregnancy journey", "lorem ispum ...", LocalDate.of(2021, 2, 14), PREGNANCY);
        articleRepository.save(pregnancy);

        articleService.likeArticle(4, 3);
        articleService.likeArticle(6, 3);



        Article youngGirls = new Article("For the girlies", "lorem ispum ...", LocalDate.of(2020, 6, 22),
                YOUNG_GIRLS);
        articleRepository.save(youngGirls);
        articleService.likeArticle(7, 4);



        Article menopause = new Article("For the older ladies", "lorem ispum ...", LocalDate.of(2023, 1, 26),
                MENOPAUSE);
        articleRepository.save(menopause);
        articleService.likeArticle(2, 5);
//

        // comments
        Comment amyComment1 = new Comment(amy, womenHealth, "Love this!", LocalDate.of(2023, 2, 13));

        commentRepository.save(amyComment1);
        userService.addCommentToUser(amyComment1, amy);


        Comment amyComment2 = new Comment(amy, menopause, "Interesting article", LocalDate.of(2023, 1, 30));
        userService.addCommentToUser(amyComment2, amy);
        commentRepository.save(amyComment2);

        Comment georgiaComment1 = new Comment(georgia, menstruation, "Very insightful and helpful as I am on my period now.", LocalDate.of(2023, 2, 3));
        userService.addCommentToUser(georgiaComment1, georgia);
        commentRepository.save(georgiaComment1);

        Comment rebeccaComment1 = new Comment(rebecca, womenHealth, "Fantastic Hygiene tips which I now use", LocalDate.of(2023, 2, 3 ));
        userService.addCommentToUser(rebeccaComment1, rebecca);
        commentRepository.save(rebeccaComment1);

        Comment rebeccaComment2 = new Comment(rebecca, pregnancy, "I had a pregnancy scare and went on this article which helped me feel more prepared for the future", LocalDate.of(2022, 2, 28));
        userService.addCommentToUser(rebeccaComment2, rebecca);
        commentRepository.save(rebeccaComment2);

        Comment rimmComment1 = new Comment(rimm, menstruation, "Had bad cramps and now I understand what happens during my period! Wish there was more research into women's health and less into viagra for men", LocalDate.of(2022, 10, 3));
        userService.addCommentToUser(rimmComment1, rimm);
        commentRepository.save(rimmComment1);

        Comment khalilComment1 = new Comment(khalil, menstruation, "As a husband and father, it is imperative all men read up on what happens to women during their period. They are incredible. Great article to find out so much!", LocalDate.of(2022, 12, 15));
        userService.addCommentToUser(khalilComment1, khalil);
        commentRepository.save(khalilComment1);

        Comment khalilComment2 = new Comment(khalil, pregnancy, "My wife is pregnant and it has been great tracking her journey and knowing what is happening in her body!", LocalDate.of(2021, 5, 3));
        userService.addCommentToUser(khalilComment2, khalil);
        commentRepository.save(khalilComment2);

        Comment jadeComment1 = new Comment(jade, youngGirls, "I just started my period and this has informed me so much! Wish we learnt more in school.", LocalDate.of(2022, 7, 8));
        userService.addCommentToUser(jadeComment1, jade);
        commentRepository.save(jadeComment1);




        // adding cycles to user

        Cycle rimmCycle = new Cycle(LocalDate.of(2023, 1, 22), LocalDate.of(2023, 1, 29), SAD, ACNE, MEDIUM);
        userService.addCycleToUser(rimmCycle, rimm);
        cycleRepository.save(rimmCycle);

        Cycle rimm2Cycle = new Cycle(LocalDate.of(2022, 12, 27), LocalDate.of(2023, 1, 2), HAPPY, TENDER_BREASTS, HEAVY, LocalDate.of(2022, 12, 10));
        userService.addCycleToUser(rimm2Cycle, rimm);
        cycleRepository.save(rimm2Cycle);


        Cycle amyCycle = new Cycle(LocalDate.of(2022, 11, 28), LocalDate.of(2022, 12, 1), ENERGETIC, CRAVINGS, LIGHT, LocalDate.of(2022, 10, 10));
        userService.addCycleToUser(amyCycle, amy);
        cycleRepository.save(amyCycle);


        Cycle georgiaCycle = new Cycle(LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 8), FRISKY, HEADACHE, SUPER_HEAVY, LocalDate.of(2023, 1, 1));

        userService.addCycleToUser(georgiaCycle, georgia);
        cycleRepository.save(georgiaCycle);


        Cycle rebeccaCycle = new Cycle(LocalDate.of(2022, 9, 7), LocalDate.of(2022, 9, 11), IRRITATED, FATIGUE, SUPER_HEAVY);
        userService.addCycleToUser(rebeccaCycle, rebecca);
        cycleRepository.save(rebeccaCycle);

        Cycle rebecca2Cycle = new Cycle(LocalDate.of(2022, 10, 5), LocalDate.of(2022, 10, 9), ANXIOUS, BACKACHE, HEAVY);
        userService.addCycleToUser(rebecca2Cycle, rebecca);
        cycleRepository.save(rebecca2Cycle);

        Cycle rebecca3Cycle = new Cycle(LocalDate.of(2022, 10, 30), LocalDate.of(2022, 11, 3), CALM, BACKACHE, LIGHT);
        userService.addCycleToUser(rebecca3Cycle, rebecca);
        cycleRepository.save(rebecca3Cycle);

        Cycle rebecca4Cycle = new Cycle(LocalDate.of(2022, 11, 26), LocalDate.of(2022, 11, 30), MOOD_SWINGS, FATIGUE, MEDIUM);
        userService.addCycleToUser(rebecca4Cycle, rebecca);
        cycleRepository.save(rebecca4Cycle);

        Cycle rebecca5Cycle = new Cycle(LocalDate.of(2022, 12, 21), LocalDate.of(2022, 12, 25), OBSESSIVE_THOUGHTS, BLOATING, HEAVY);
        userService.addCycleToUser(rebecca5Cycle, rebecca);
        cycleRepository.save(rebecca5Cycle);

        Cycle rebecca6Cycle = new Cycle(LocalDate.of(2023, 1, 19), LocalDate.of(2023, 1, 23), APATHETIC, INSOMNIA, SUPER_HEAVY);
        userService.addCycleToUser(rebecca6Cycle, rebecca);
        cycleRepository.save(rebecca6Cycle);



//        To update article number of likes
        List<Article> allArticles = articleRepository.findAll();
        for (Article articleToUpdate : allArticles) {
            articleToUpdate.update();
            articleRepository.save(articleToUpdate);
        }



        userRepository.saveAll(List.of(rimm, amy, eoan, georgia, rebecca));


    }

}
