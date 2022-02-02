package keeper.log4j.victim.service;

import keeper.log4j.victim.entity.PostEntity;
import keeper.log4j.victim.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private PostRepository postRepository;

    public void saveContentToDB(String content){
        PostEntity postEntity = PostEntity.builder()
                .content(content)
                .build();
        postRepository.save(postEntity);
    }
}

