package keeper.log4j.attack.controller;

import javax.servlet.http.HttpServletRequest;
import keeper.log4j.attack.service.MainManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AttackMainController {

  private final MainManageService mainManageService;

  @GetMapping(value = "/")
  public String mainController(Model model){
    HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String ip = req.getHeader("X-FORWARDED-FOR");
    if(ip == null){
      ip = req.getRemoteAddr();
    }
    model.addAttribute("clientIP", ip);
    return ip+"메인페이지입니다";
  }

  @GetMapping(value = "/attack")
  public String attackClassController(){
    return "공격용 클래스가 매핑됩니다";
  }
}
