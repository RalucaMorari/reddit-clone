package RedditClone.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private VoteType voteType;
    @ManyToOne
    @JoinColumn(name="post_id")
    @JsonBackReference("post-vote")
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference("user-vote")
    private User user;

    public Vote() {
    }

    public Vote(Long id, VoteType voteType, Vote vote) {
        this.id = id;
        this.voteType = voteType;
        this.post = post;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
