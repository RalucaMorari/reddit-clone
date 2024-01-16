package RedditClone.Controllers;

import RedditClone.DTOs.PostRequestDTO;
import RedditClone.DTOs.SubredditRequestDTO;
import RedditClone.Model.Post;
import RedditClone.Model.Subreddit;
import RedditClone.Services.PostService;
import RedditClone.Services.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }




    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        Post post = postService.createPost(postRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
