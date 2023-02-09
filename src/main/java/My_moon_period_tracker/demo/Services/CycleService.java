package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CycleService {

    @Autowired
    CycleRepository cycleRepository;

//    @Autowired
//    UserRepository userRepository


    public List<Cycle> getAllCycles () {
        return cycleRepository.findAll();
    }


    public List<Cycle> findByStartDate(LocalDate startDate) {
        return cycleRepository.findByStartDate(startDate);
    }

    public List<Cycle> findByLastDate(LocalDate lastDate) {
        return cycleRepository.findByLastDate(lastDate);
    }

    public Cycle findByLateDays(int lateDays) {
        return cycleRepository.findByLateDays(lateDays).get(lateDays);
    }

    public Optional<Cycle> getCycleById(long id) {
        return cycleRepository.findById(id);
    }

    public Cycle updateCycle(Cycle cycle, long id){
        Cycle cycle1 = cycleRepository.findById(id).get();
        cycle1.setLastDate(cycle.getLastDate());
        cycle1.setStartDate(cycle.getStartDate());
        cycle1.setLateDays(cycle.getLateDays());
        return cycleRepository.save(cycle1);
    }

    public Cycle addCycle(Cycle cycle){
        return  cycleRepository.save(cycle);
    }
}

