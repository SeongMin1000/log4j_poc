package keeper.log4j.attack.controller;

import keeper.log4j.attack.service.MainManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AttackMainController {

  private final MainManageService mainManageService;

  @GetMapping(value = "/")
  public String mainController(){
    String ip = mainManageService.displayIP();
    return ip+"메인페이지입니다";
  }

  @GetMapping(value = "/attack")
  public String attackClassController(){
    return "공격용 클래스가 매핑됩니다";
  }
}
