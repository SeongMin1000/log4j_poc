package keeper.log4j.victim.controller;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;



import keeper.log4j.victim.dto.CommonResult;
import keeper.log4j.victim.entity.PostEntity;
import keeper.log4j.victim.repository.PostRepository;
import keeper.log4j.victim.service.ResponseService;
import keeper.log4j.victim.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {


  private final ResponseService responseService;
  private final PostRepository postRepository;
  private final CommentService commentService;

  @PostMapping(value = "posting")
  @ResponseBody
  public CommonResult posting(@RequestParam String content) {
    commentService.saveContentToDB(content);
    //postRepository.save(PostEntity.builder().content(content).build());
    log.info(content);

    List<PostEntity> list = new ArrayList<>();

    Sort sort1 = Sort.by("id").descending();
    Pageable pageable = PageRequest.of(0, 5, sort1);
    Page<PostEntity> result = postRepository.findAll(pageable);
    JSONArray jsonArray = new JSONArray();
    for (PostEntity postEntity : result.getContent()) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", postEntity.getId());
      jsonObject.put("content", postEntity.getContent());
      jsonArray.add(jsonObject);
      list.add(postEntity);
    }
    return responseService.getSuccessResult();
  }
}



