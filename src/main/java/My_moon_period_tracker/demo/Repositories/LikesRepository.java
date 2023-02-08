package My_moon_period_tracker.demo.Repositories;

import My_moon_period_tracker.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository {

    List<User> countNumberOfUsersInArticle(long userId);

}
