package My_moon_period_tracker.demo.Models;

public class LikesDTO {

    private long userId;
    private long articleId;

    public LikesDTO(long userId, long articleId){
        this.userId = userId;
        this.articleId = articleId;
    }

    public LikesDTO(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }
}
