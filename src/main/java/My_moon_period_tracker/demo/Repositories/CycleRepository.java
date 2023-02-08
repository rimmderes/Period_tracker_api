package My_moon_period_tracker.demo.Repositories;

import My_moon_period_tracker.demo.Models.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
}
