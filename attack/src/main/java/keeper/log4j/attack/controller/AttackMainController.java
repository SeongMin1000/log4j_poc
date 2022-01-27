package keeper.log4j.attack.controller;

import javax.servlet.http.HttpServletRequest;

import keeper.log4j.attack.entity.AttackEntity;
import keeper.log4j.attack.repository.AttackRepository;
import keeper.log4j.attack.service.MainManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AttackMainController {

  private final MainManageService mainManageService;

  @Autowired
  AttackRepository attackRepository;

  @GetMapping(value = "/main")
  @ResponseBody
  public JSONArray mainController(Model model) {
    HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String ip = req.getHeader("X-FORWARDED-FOR");
    if (ip == null) {
      ip = req.getRemoteAddr();
    }
    model.addAttribute("clientIP", ip);
    mainManageService.saveIpToDB(ip);

    List<AttackEntity> list = new ArrayList<>();

    Sort sort1 = Sort.by("id").descending();
    Pageable pageable = PageRequest.of(0, 5, sort1);
    Page<AttackEntity> result = attackRepository.findAll(pageable);
    JSONArray jsonArray = new JSONArray();
    for (AttackEntity attackEntity : result.getContent()) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", attackEntity.getId());
      jsonObject.put("ip", attackEntity.getIp());
      jsonObject.put("connectionDate", attackEntity.getConnectionDate());

      jsonArray.add(jsonObject);
      list.add(attackEntity);
    }

    return jsonArray;
  }

  @GetMapping(value = "/attack")
  public String attackClassController() {

    return "으악";
  }

}
