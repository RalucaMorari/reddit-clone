package RedditClone.DTOs;

public class PostRequestDTO {

    private String postName;
    private String description;
    private Long subredditId;

    private Long userId;

    public PostRequestDTO(String postName, String description, Long subredditId, Long userId) {
        this.postName = postName;
        this.description = description;
        this.subredditId = subredditId;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(Long subredditId) {
        this.subredditId = subredditId;
    }
}
