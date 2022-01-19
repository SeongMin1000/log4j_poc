package keeper.log4j.victim.controller;

import keeper.log4j.victim.dto.CommonResult;
import keeper.log4j.victim.entity.PostEntity;
import keeper.log4j.victim.repository.PostRepository;
import keeper.log4j.victim.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/")
public class PostController {

  private final ResponseService responseService;
  private final PostRepository postRepository;

  @PostMapping(value = "posting")
  @ResponseBody
  public CommonResult posting(@RequestParam String content){

    postRepository.save(PostEntity.builder().content(content).build());
    log.info(content);

    return responseService.getSuccessResult();
  }

  @GetMapping(value = "/")
  @ResponseBody
  public String showPost(){
    return "게시글";
  }

}
