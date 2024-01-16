package RedditClone.DTOs;

import RedditClone.Model.VoteType;

public class VoteRequestDTO {

    private Long postId;
    private Long userId;

    private VoteType voteType;

    public VoteRequestDTO(Long postId, Long userId, VoteType voteType) {
        this.postId = postId;
        this.userId = userId;
        this.voteType = voteType;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
