package keeper.log4j.attack.controller;

import javax.servlet.http.HttpServletRequest;

import keeper.log4j.attack.entity.AttackEntity;
import keeper.log4j.attack.repository.AttackRepository;
import keeper.log4j.attack.service.MainManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AttackMainController {

  private final MainManageService mainManageService;

  @Autowired
  AttackRepository attackRepository;

  @GetMapping(value = "/")
  public List<AttackEntity> mainController(Model model) {
    HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String ip = req.getHeader("X-FORWARDED-FOR");
    if (ip == null) {
      ip = req.getRemoteAddr();
    }
    model.addAttribute("clientIP", ip);

    mainManageService.saveIpToDB(ip);

    List<AttackEntity> list = new ArrayList<>();
    Iterable<AttackEntity> iterable = attackRepository.findAll();
    for (AttackEntity attackEntity : iterable) {
      list.add(attackEntity);
    }
    return list;
  }

  @GetMapping(value = "/attack")
  public String attackClassController() {
    return "공격클래스 매핑";
  }

}



