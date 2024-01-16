package RedditClone.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Subreddit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "subreddit", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference("subreddit-post")
    private List<Post> posts;

    public Subreddit() {
    }

    public Subreddit(Long id, String name, String description, LocalDateTime createdDate, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
