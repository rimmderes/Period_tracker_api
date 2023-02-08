package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Services.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cycle")

public class CycleController {

    @Autowired
    CycleService cycleService;
    @Autowired
    private CycleRepository cycleRepository;


    // add a cycle
    @PostMapping
    public ResponseEntity<Cycle> addNewCycle (@RequestBody Cycle cycle) {
        Cycle newCycle = cycleService.addCycle(cycle);
        return new ResponseEntity<>(newCycle, HttpStatus.CREATED);
    }

    // update a cycle
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Cycle> updateCycle(@RequestBody Cycle cycle, @PathVariable Long id) {
        Cycle cycleToUpdate = cycleService.getCycleById(id)
    }


    // find by start date

//    @GetMapping
//    public ResponseEntity<>





}
