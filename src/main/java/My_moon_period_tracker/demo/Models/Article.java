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



    @ManyToMany
    @JoinTable(
            name = "article_likes",
            joinColumns = {@JoinColumn (name = "article_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false)}
    )
    @JsonIgnoreProperties({"articles", "comments"})
    private List<User> articleLikes;

    @Column(name = "numberOfLikes")
    private int numOfLikes;

    @OneToMany(mappedBy = "article")
    @JsonIgnoreProperties({"article"})
    private List<Comment> comments;

    @Column(name = "tags")
    private Tag tag;

    public Article (String title, String content, LocalDate date, Tag tag){
        this.title = title;
        this.content = content;
        this.date = date;
        this.articleLikes = new ArrayList<>();
        this.numOfLikes = 0;
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

    public List<User> getArticleLikes() {
        return articleLikes;
    }

    public void setArticleLikes(List<User> articleLikes) {
        this.articleLikes = articleLikes;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
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


//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

//    Method for likes
    public void update(){
        int sum = 0;
        if(articleLikes.isEmpty()){
            numOfLikes = 0;
        }
        for (User user: articleLikes){
            int number = user.getArticles().size();
            sum += number;
        }
        numOfLikes = articleLikes.size();
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }


    public boolean checkifUserLiked (long userId) {
        for (User user : articleLikes) {
            if(user.getId() == userId) {
                return true;
            }
        }
        return false;
    }

    public void removeLike (User userToRemove) {
        int indexToRemove = -1;
        for(int i = 0; i<articleLikes.size(); i++) {
            if(userToRemove.getId() == articleLikes.get(i).getId()) {
                indexToRemove = i;
            }

        }
        if (indexToRemove > -1) {
            articleLikes.remove(indexToRemove);

        }
    }

}
