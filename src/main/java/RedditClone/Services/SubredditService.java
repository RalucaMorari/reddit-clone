package RedditClone.Services;

import RedditClone.DTOs.Mappers.SubredditMapper;
import RedditClone.DTOs.SubredditRequestDTO;
import RedditClone.Model.Subreddit;
import RedditClone.Repositories.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SubredditService {
    private SubredditRepository subredditRepository;
    private SubredditMapper subredditMapper;
    @Autowired
    public SubredditService(SubredditRepository subredditRepository, SubredditMapper subredditMapper) {
        this.subredditRepository = subredditRepository;
        this.subredditMapper=subredditMapper;

    }

    @Transactional
    public Subreddit createSubreddit(SubredditRequestDTO subredditRequestDTO) {
        Subreddit subreddit = subredditMapper.mapSubredditRequestDTOtoSubreddit(subredditRequestDTO);
        return subredditRepository.save(subreddit);
    }


    /*public Subreddit mapSubredditRequestDTOtoSubreddit(SubredditRequestDTO subredditRequestDTO) {
            Subreddit subreddit = new Subreddit();
            subreddit.setName(subredditRequestDTO.getName());
            subreddit.setDescription(subredditRequestDTO.getDescription());
            subreddit.setCreatedDate(LocalDateTime.now());
            return subreddit;
        }
    }*/



}

