package My_moon_period_tracker.demo.Services;

import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CycleService {

    @Autowired
    CycleRepository cycleRepository;


    public Cycle findByStartDate(LocalDate startDate) {
        return cycleRepository.findByStartDate(startDate).get();
    }

    public Cycle findByLastDate(LocalDate lastDate) {
        return cycleRepository.findByLastDate(lastDate).get();
    }

    public Cycle findByLateDays(LocalDate lateDays) {
        return cycleRepository.findByLateDays(lateDays).get();
    }

    public Cycle updateCycle(Cycle cycle, long id){
        Cycle cycle1 = cycleRepository.findById(id).get();
        cycle1.setLastDate(cycle1.getLastDate());
        cycle1.setStartDate(cycle1.getStartDate());
        cycle1.setLateDays(cycle1.getLateDays());
        return cycleRepository.set(cycle);
    }

    public Cycle addCycle(Cycle cycle){
        return  cycleRepository.save(cycle);
    }
}

