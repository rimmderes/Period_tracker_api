package My_moon_period_tracker.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="text")
    private String text;
    @Column(name="date_posted")
    private LocalDate datePosted;


    @ManyToOne
    @JsonIgnoreProperties({"comment"})
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JsonIgnoreProperties({"comment"})
    @JoinColumn(name ="user_id")
    private User user;

    public Comment(String text, LocalDate datePosted) {
        this.text = text;
        this.datePosted = datePosted;
    }

    public Comment(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
