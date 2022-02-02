package keeper.log4j.victim.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import keeper.log4j.victim.entity.PostEntity;
import keeper.log4j.victim.repository.PostRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  @Autowired
  private PostRepository postRepository;

  public void saveContentToDB(String content) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
    Date now = new Date();
    String now_dt = format.format(now);

    PostEntity postEntity = PostEntity.builder()
        .content(content)
        .registerDate(now_dt)
        .build();

    postRepository.save(postEntity);
  }

  public JSONArray getContentFromDB() {
    Sort sort1 = Sort.by("id").descending();
    Pageable pageable = PageRequest.of(0, 10, sort1);
    Page<PostEntity> result = postRepository.findAll(pageable);
    JSONArray jsonArray = new JSONArray();
    for (PostEntity postEntity : result.getContent()) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", postEntity.getId());
      jsonObject.put("content", postEntity.getContent());
      jsonObject.put("registerDate", postEntity.getRegisterDate());
      jsonArray.add(jsonObject);
    }
    return jsonArray;
  }
}

