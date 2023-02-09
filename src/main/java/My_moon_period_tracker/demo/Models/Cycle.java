package My_moon_period_tracker.demo.Models;


import My_moon_period_tracker.demo.Enums.Emotion;
import My_moon_period_tracker.demo.Enums.Flow;
import My_moon_period_tracker.demo.Enums.Symptom;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "cycle")

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
    private Emotion emotions;

    @Column  (name = "symptoms")
    private Symptom symptoms;

    @Column  (name = "flow")
    private Flow flow;

//    @ManyToOne
//    private User user;

    public Cycle(long id, LocalDate lastDate, LocalDate startDate, int lateDays, Emotion emotions, Symptom symptoms, Flow flow){
        this.id = id;
        this.lastDate = lastDate;
        this.startDate = startDate;
        this.lateDays = lateDays;
        this.emotions = emotions;
        this.symptoms = symptoms;
        this.flow = flow;
    }

    public Cycle(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    public Emotion getEmotions() {
        return emotions;
    }

    public void setEmotions(Emotion emotions) {
        this.emotions = emotions;
    }

    public Symptom getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptom symptoms) {
        this.symptoms = symptoms;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
