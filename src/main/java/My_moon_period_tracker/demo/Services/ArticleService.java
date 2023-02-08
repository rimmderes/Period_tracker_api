package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

//    Find all articles for the articles page
    public List<Article> displayAllArticles() {
        return articleRepository.findAll();
    }

//    Find a single article for the individual article page
    public Optional<Article> findArticleById(long id){
        return articleRepository.findById(id);
    }

//    Find an article by title
    public List<Article> findByTitle(String title){
        return articleRepository.findByTitle(title);
    }

//    Find articles with same tags
    public List<Article> findByTags(Tag tag){
        return articleRepository.findByTag(tag);
    }

//    Find number of likes in article
    public int getNumberOfLikesFromArticle(long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.get().getLikes().size();
    }

//    Like article
    public void likeArticle(long userId, long articleId){
        Optional<Article> article = articleRepository.findById(articleId);
        Optional<User> user = userRepository.findById(userId);
        List<User> likes = article.get().getLikes();
        likes.add(user.get());
        article.get().setLikes(likes);
    }
}
