package My_moon_period_tracker.demo.Controllers;

import My_moon_period_tracker.demo.Models.Cycle;
import My_moon_period_tracker.demo.Models.User;
import My_moon_period_tracker.demo.Repositories.CycleRepository;
import My_moon_period_tracker.demo.Services.CycleService;
import My_moon_period_tracker.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cycles")

public class CycleController {

    @Autowired
    CycleService cycleService;
    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private UserService userService;

    // add a cycle
    @PostMapping(value = "/{user_id}")
    public ResponseEntity<Cycle> addNewCycle (@RequestBody Cycle cycle, @PathVariable Long user_id) {
        User user = userService.getUserById(user_id);
        cycle.setUser(user);
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
    @GetMapping (value= "/startdate")
    public ResponseEntity<List<Cycle>> getCyclebyStartDate (
            @RequestParam(required=false, name="startdate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            LocalDate startDate) {
        if(startDate != null) {
            return new ResponseEntity<>(cycleService.findByStartDate(startDate), HttpStatus.OK);
        }
        return new ResponseEntity<>(cycleService.getAllCycles(), HttpStatus.OK);
    }

    // GET ALL CYCLES
    @GetMapping
    public ResponseEntity<List<Cycle>> allCycles() {
        List<Cycle> cycles = cycleService.getAllCycles();
        return new ResponseEntity<>(cycles, HttpStatus.OK);
    }


// GET CYCLE BY ID
    @GetMapping(value="/{id}")
    public ResponseEntity<Cycle> getCycleById(@PathVariable long id){
        Optional<Cycle> cycle = cycleService.getCycleById(id);
        if (cycle.isPresent()){
            return new ResponseEntity<>(cycle.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }





}
