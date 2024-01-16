package RedditClone.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String postName;
    @Column
    private String description;
    @Column
    private Long voteCount;
    @Column
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonManagedReference("comment-post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonManagedReference("vote-post")
    private List<Vote> votes;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference("user-post")
    private User user ;

    @ManyToOne
    @JoinColumn(name="subreddit_id")
    @JsonBackReference("subreddit-post")
    private Subreddit subreddit;

    public Post() {
    }

    public Post(Long id, String postName, String description, Long voteCount, LocalDateTime createdDate, List<Comment> comments, List<Vote> votes, User user, Subreddit subreddit) {
        this.id = id;
        this.postName = postName;
        this.description = description;
        this.voteCount = voteCount;
        this.createdDate = createdDate;
        this.comments = comments;
        this.votes = votes;
        this.user = user;
        this.subreddit = subreddit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subreddit getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(Subreddit subreddit) {
        this.subreddit = subreddit;
    }
}
