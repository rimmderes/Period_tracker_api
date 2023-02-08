package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

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
        return articleRepository.findByTags(tag);
    }
}
