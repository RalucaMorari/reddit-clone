package RedditClone.DTOs.Mappers;

import RedditClone.DTOs.PostRequestDTO;
import RedditClone.Model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PostMapper {



    @Mapping(target = "id", ignore=true)
    @Mapping(target = "voteCount", constant="0L")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    public abstract Post mapPostRequestDTOtoPost(PostRequestDTO postRequestDTO);
}
