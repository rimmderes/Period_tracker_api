package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

//    Get all articles
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> article = articleService.displayAllArticles();
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

//    Get single article
    @GetMapping(value = "/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id){
        Optional<Article> article = articleService.findArticleById(id);
        if (article.isPresent()){
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    Get article by title
    @GetMapping(value = "/title")
    public ResponseEntity<List<Article>> getArticleByTitle (
            @RequestParam(required = false, name = "title") String title
    ){
        if(title != null){
            return new ResponseEntity<>(articleService.findByTitle(title), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

//    Get articles by tags
    @GetMapping(value = "tags")
    public ResponseEntity<List<Article>> getArticleByTag(
            @RequestParam(required = false, name = "tag") Tag tag
    ){
        if (tag != null){
            return new ResponseEntity<>(articleService.findByTags(tag), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

//    Show comments from article
    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsFromArticle(@PathVariable long id){
        Optional<Article> article = articleService.findArticleById(id);
        List<Comment> comments = article.get().getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
