package My_moon_period_tracker.demo.Repositories;

import My_moon_period_tracker.demo.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
