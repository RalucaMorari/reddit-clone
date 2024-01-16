package RedditClone.Controllers;

import RedditClone.DTOs.SubredditRequestDTO;
import RedditClone.Model.Subreddit;
import RedditClone.Services.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subreddit")

public class SubredditController {
    SubredditService subredditService;

    @Autowired
    public SubredditController(SubredditService subredditService) {
        this.subredditService = subredditService;
    }

    @PostMapping
    public ResponseEntity<Subreddit> createSubreddit(@RequestBody SubredditRequestDTO subredditRequestDTO) {
        Subreddit subreddit = subredditService.createSubreddit(subredditRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(subreddit);
    }
}
//  public ResponseEntity<Category> addCategory(@RequestBody Category category) {
//        Category newCategory = categoryService.addCategory(category);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);