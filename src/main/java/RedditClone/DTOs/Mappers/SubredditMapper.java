package RedditClone.DTOs.Mappers;

import RedditClone.DTOs.SubredditRequestDTO;
import RedditClone.Model.Subreddit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public abstract class SubredditMapper {


    @Mapping(target = "id", ignore=true)
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    public abstract Subreddit mapSubredditRequestDTOtoSubreddit(SubredditRequestDTO subredditRequestDTO);

   /* @org.mapstruct.Mapping(source = "subreddit.name", target = "name")
    @org.mapstruct.Mapping(source = "subreddit.description", target = "description")
    @org.mapstruct.Mapping(source = "date", target = "createdDate")
    public abstract SubredditRequestDTO mapSubredditRequestDTOToSubreddit(Subreddit subreddit);*/
}
