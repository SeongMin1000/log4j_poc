package keeper.log4j.victim.controller;

import keeper.log4j.victim.dto.CommonResult;
import keeper.log4j.victim.entity.PostEntity;
import keeper.log4j.victim.repository.PostRepository;
import keeper.log4j.victim.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
@Log4j
public class VictimController {

  private final PostRepository postRepository;
  private final ResponseService responseService;

  @PostMapping(value = "posting")
  @ResponseBody
  public CommonResult posting( @RequestParam String content ){

    postRepository.save(PostEntity.builder().content(content).build());

    return responseService.getSuccessResult();
  }
}
