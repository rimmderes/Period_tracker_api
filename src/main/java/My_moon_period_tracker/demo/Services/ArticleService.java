package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.*;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

//    Find all articles for the articles page
    public List<Article> displayAllArticles() {
        return articleRepository.findAll();
    }

//    Find a single article for the individual article page
    public Article findArticleById(long id){
        return articleRepository.findById(id).get();
    }


    //    Find an article by title
    public List<Article> findByTitle(String title){
        return articleRepository.findByTitle(title);
    }

//    Find articles with same tags
    public List<Article> findByTags(Tag tag){
        return articleRepository.findByTag(tag);
    }


// like article
public Article likeArticle(long userId, long articleId) {
    Optional<Article> optionalArticle = articleRepository.findById(articleId);
    if (!optionalArticle.isPresent()) {
        return null;
    }

    Optional<User> optionalUser = userRepository.findById(userId);
    if (!optionalUser.isPresent()) {
        return null;
    }
    Article article = optionalArticle.get();
    User user = optionalUser.get();
    List<User> likesList = article.getArticleLikes();
    if (article.checkifUserLiked(user.getId())) {
        article.removeLike(user);
    } else {
        likesList.add(user);
    }
    article.setArticleLikes(likesList);
    articleRepository.save(article);
    return article;
}



//    Get random article

    Random random = new Random();
    public Optional<Article> getRandomArticle() {
        List<Article> allArticles = articleRepository.findAll();
        List<Long> allIds = new ArrayList<>();
        for(Article article: allArticles){
            allIds.add(article.getId());
        }
        while (true){
            int randomId = random.nextInt(0, allIds.size());
            Optional <Article> randomArticle = articleRepository.findById(allIds.get(randomId));
            if(randomArticle.isPresent()){
                return randomArticle;
            }
        }
    }

}
