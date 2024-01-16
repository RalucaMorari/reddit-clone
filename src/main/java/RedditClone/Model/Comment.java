package RedditClone.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;
    @Column
    private String createdDate;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference("user-comment")
    private User user;
    @ManyToOne
    @JoinColumn(name="post_id")
    @JsonBackReference("post-comment")
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String text, String createdDate, User user, Comment comment) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
