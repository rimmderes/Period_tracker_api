package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Services.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        cycleService.updateCycle(cycle, id);
        Optional <Cycle> updatedCycle = cycleService.getCycleById(id);
        return new ResponseEntity<>(updatedCycle.get(), HttpStatus.OK);
    }


    // find by start date

    @GetMapping
    public ResponseEntity<List<Cycle>> getCyclebyStartDate (
            @RequestParam(required=false, name="startdate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            LocalDate startDate) {
        if(startDate != null) {
            return new ResponseEntity<>(cycleService.findByStartDate(startDate), HttpStatus.OK);
        }
        return new ResponseEntity<>(cycleService.getAllCycles(), HttpStatus.OK);
    }


    // find by last date
//    @GetMapping
//    public ResponseEntity<>





}
