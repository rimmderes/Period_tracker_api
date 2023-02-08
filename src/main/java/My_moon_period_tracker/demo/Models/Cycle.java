package My_moon_period_tracker.demo.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Comment;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "cycles")
public class Cycle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lastDate")
    private LocalDate lastDate;

    @Column (name = "startDate")
    private LocalDate startDate;

    @Column (name = "lateDays")
    private int lateDays;

    @Column  (name = "emotions")
    private Enum emotions;

    @Column  (name = "symptoms")
    private Enum symptoms;

    @Column  (name = "flow")
    private Enum flow;

    @ManyToOne
    private User user;

//    public Cycle(long id, LocalDate lastDate, LocalDate startDate, LocalDate lateDays Enum emotions, Enum symptoms, Enum flow){
//        this.id
//    }

}
