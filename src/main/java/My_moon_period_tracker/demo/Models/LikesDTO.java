package My_moon_period_tracker.demo.Models;

public class LikesDTO {

    private long user_id;
    private long article_id;

    public LikesDTO(long userId, long articleId){
        this.user_id = userId;
        this.article_id = articleId;
    }

    public LikesDTO(){}

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long userId) {
        this.user_id = userId;
    }

    public long getArticleId() {
        return article_id;
    }

    public void setArticleId(long articleId) {
        this.article_id = articleId;
    }
}
