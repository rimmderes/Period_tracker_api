package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Models.Comment;
import My_moon_period_tracker.demo.DTOs.CommentDTO;
import My_moon_period_tracker.demo.Repositories.CommentRepository;
import My_moon_period_tracker.demo.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;
    //    post comment
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Comment> addNewComment(@RequestBody CommentDTO commentDTO) {
        Comment newComment = commentService.addComment(commentDTO);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    //get all comments
    @GetMapping
    public ResponseEntity<List<Comment>> displayAllComments(){
        List<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    //    get comment by id
    @GetMapping(value="/{id}")
    public ResponseEntity<Comment> getCommentsById(@PathVariable long id) {
        Optional<Comment> comment = commentService.getCommentsById(id);
        if (comment.isPresent()){
            return new ResponseEntity<>(comment.get(), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value= "/{id}")
    public ResponseEntity<Comment> updateCommentById(@PathVariable long id, @RequestBody CommentDTO commentDTO){
        commentService.updateComment(commentDTO, id);
        Optional<Comment> updatedComment = commentService.getCommentsById(id);
        return new ResponseEntity<>(updatedComment.get(), HttpStatus.OK);

    }
    //    delete comment by id
    @DeleteMapping(value= "/{id}")
    public ResponseEntity<Long> deleteReader(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
