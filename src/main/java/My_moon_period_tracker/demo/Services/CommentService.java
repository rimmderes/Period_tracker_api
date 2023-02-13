package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.Article;
import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Models.CommentDTO;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.ArticleRepository;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;



    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentsById(long id){
        return commentRepository.findById(id);
    }
    public Comment addComment(CommentDTO commentDTO) {
        User userObject = userRepository.findById(commentDTO.getUserId()).get();
        Article articleObject = articleRepository.findById(commentDTO.getArticleId()).get();

        Comment comment = new Comment(userObject, articleObject, commentDTO.getText(), commentDTO.getDatePosted());
        commentRepository.save(comment);
        return comment;
    }



//    public void updateComment(long id, Comment comment){
//        Comment comment1 = commentRepository.findById(id).get();
//        comment1.setText(comment.getText());
//        comment1.setDatePosted(comment.getDatePosted());
//        commentRepository.save(comment);
//    }
    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

    public Comment updateComment(CommentDTO commentDTO, long id){
        User userObject = userRepository.findById(commentDTO.getUserId()).get();
        Article articleObject = articleRepository.findById(commentDTO.getArticleId()).get();

        Comment commentToUpdate = commentRepository.findById(id).get();

        commentToUpdate.setText(commentDTO.getText());
        commentToUpdate.setDatePosted(commentDTO.getDatePosted());
        commentToUpdate.setArticle(articleObject);
        commentToUpdate.setUser(userObject);
        return commentToUpdate;
    }
}