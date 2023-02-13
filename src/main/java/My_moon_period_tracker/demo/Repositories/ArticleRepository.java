package My_moon_period_tracker.demo.Repositories;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository  extends JpaRepository<Article, Long> {

    List<Article> findByTitle (String title);


    List<Article> findByTag(Tag tag);

    boolean existsArticleLikeByArticleLikes (User user);

}
