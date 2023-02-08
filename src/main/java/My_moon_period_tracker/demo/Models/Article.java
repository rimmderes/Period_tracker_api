package My_moon_period_tracker.demo.Models;

import My_moon_period_tracker.demo.Enums.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "likes")
    private int likes;
//    This uses user_id
//    @OneToMany
//    private User user

    @OneToMany(mappedBy = "articles")
    @JsonIgnoreProperties
    private List<Comment> comments;

//    Do in tags - they're enums
    @Column(name = "tags")
    private Tag tag;

    public Article (String title, String content, LocalDate date, int likes, Tag tag ){
        this.title = title;
        this.content = content;
        this.date = date;
        this.likes = likes;
        this.comments = new ArrayList<>();
        this.tag = tag;
    }

    public Article(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
