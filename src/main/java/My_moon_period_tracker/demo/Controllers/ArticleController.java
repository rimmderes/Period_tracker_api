package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Enums.Tag;
import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.OPTIONS})
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
    public ResponseEntity<Article> getById(@PathVariable long id){
//        Optional<Article> article = articleService.findArticleById(id);
        Article article = articleService.findArticleById(id);

        if (article != null){
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/title")
    public ResponseEntity<List<Article>> getArticleByTitle (
            @RequestParam(required = false, name = "title") String title
    ){
        if(title != null){
            return new ResponseEntity<>(articleService.findByTitle(title), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

//    Get articles by tags CHANGED VALUE
    @GetMapping(value = "/tags")
    public ResponseEntity<List<Article>> getArticleByTag(
            @RequestParam(required = false, name = "tags") Tag tag
    ){
        if (tag != null){
            return new ResponseEntity<>(articleService.findByTags(tag), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }



//    Get article's comments
    @GetMapping (value = "/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentsFromArticle (@PathVariable long id) {
        Article article = articleService.findArticleById(id);
        List<Comment> comments = article.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // like article

    @PatchMapping (value = "/{id}/{user_id}")
    public ResponseEntity<Article> likeAnArticle (@PathVariable long id, @PathVariable long user_id) {
        Article article = articleService.likeArticle(user_id, id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }


//    Get random article
    @GetMapping(value = "/random")
    public ResponseEntity<Article> getRandomArrticle(){
        Optional<Article> article = articleService.getRandomArticle();
        if (article.isPresent()){
            return new ResponseEntity<>(article.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
