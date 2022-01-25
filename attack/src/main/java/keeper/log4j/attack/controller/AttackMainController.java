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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class  AttackMainController {
  private final MainManageService mainManageService;

  @Autowired
  AttackRepository attackRepository;

  @GetMapping(value = "/")
  public String mainController(Model model){
    HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String ip = req.getHeader("X-FORWARDED-FOR");
    if(ip == null){
      ip = req.getRemoteAddr();
    }
    model.addAttribute("clientIP", ip);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
    Date now = new Date();
    String now_dt = format.format(now);

    AttackEntity attackEntity = AttackEntity.builder()
            .ip(ip)
            .connectionDate(now_dt)
            .build();

    attackRepository.save(attackEntity);

    return ip+"메인페이지입니다";
  }

  @GetMapping(value = "/attack")
  public String attackClassController(){
    return "공격클래스 매핑";
    }

  }


