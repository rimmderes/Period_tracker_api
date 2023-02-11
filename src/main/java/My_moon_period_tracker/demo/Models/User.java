package My_moon_period_tracker.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "DOB")
    private LocalDate DOB;

    @OneToMany
    @JsonIgnoreProperties({"user", "comments"})
    private List<Comment> comments;

    @OneToMany
    @JsonIgnoreProperties ({"user"})
    private List<Cycle> cycles;

    @ManyToMany (mappedBy = "likes")
    @JsonIgnoreProperties({"likes", "comments"})
    private List<Article> articles;
//    @JoinTable(
//            name = "users_articles",
//            // create primary key column
//            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
//            // create foreign key column
//            inverseJoinColumns = {@JoinColumn(name = "article_id", nullable = false)}
//    )


    public User(String name, String password, String email, LocalDate DOB) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.DOB = DOB;
        this.comments = new ArrayList<>();
        this.cycles = new ArrayList<>();
    }

    public User(){}

    public void addNewCycle(Cycle cycle){
        this.cycles.add(cycle);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Cycle> getCycles() {
        return cycles;
    }

    public void setCycles(List<Cycle> cycles) {
        this.cycles = cycles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
