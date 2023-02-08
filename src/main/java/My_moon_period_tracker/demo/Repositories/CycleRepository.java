package My_moon_period_tracker.demo.Repositories;

import My_moon_period_tracker.demo.Models.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {

    List<Cycle> findByStartDate(LocalDate startDate);
    List<Cycle> findByLastDate(LocalDate lastDate);
    List<Cycle> findByLateDays(int startDate);

}
