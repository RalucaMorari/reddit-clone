package RedditClone.Services;

import RedditClone.DTOs.Mappers.PostMapper;
import RedditClone.DTOs.PostRequestDTO;
import RedditClone.Model.Post;
import RedditClone.Model.Subreddit;
import RedditClone.Model.User;
import RedditClone.Repositories.PostRepository;
import RedditClone.Repositories.SubredditRepository;
import RedditClone.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private PostRepository postRepository;

    private PostMapper postMapper;

    private UserRepository userRepository;
    private SubredditRepository subredditRepository;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper, UserRepository userRepository, SubredditRepository subredditRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
        this.subredditRepository = subredditRepository;
    }

    @Transactional
    public Post createPost(PostRequestDTO postRequestDTO){

        Post post = postMapper.mapPostRequestDTOtoPost(postRequestDTO);
        User user = userRepository.findById(postRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("user not found"));
        Subreddit subreddit = subredditRepository.findById(postRequestDTO.getSubredditId()).orElseThrow(() ->new RuntimeException("subreddit not found"));
        post.setSubreddit(subreddit);
        post.setUser(user);

        return postRepository.save(post);

    }
}
