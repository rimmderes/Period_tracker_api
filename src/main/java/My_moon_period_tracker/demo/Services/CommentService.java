package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;



    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentsById(long id){
        return commentRepository.findById(id);
    }
    public Comment addComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }
}