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
  public JSONArray posting(@RequestParam String content) {
    commentService.saveContentToDB(content);
    log.info(content);

    JSONArray jsonArray = commentService.getContentFromDB();

    return jsonArray;
  }
}



