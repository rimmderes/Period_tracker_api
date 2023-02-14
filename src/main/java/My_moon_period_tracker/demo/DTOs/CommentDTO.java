package My_moon_period_tracker.demo.DTOs;

import java.time.LocalDate;

public class CommentDTO {

    private String text;

    private LocalDate datePosted;

    private long articleId;

    private long userId;

    public CommentDTO(String text, LocalDate datePosted, long articleId, long userId){
        this.text = text;
        this.datePosted= datePosted;
        this.articleId = articleId;
        this.userId = userId;
    }

    public CommentDTO (){

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

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
