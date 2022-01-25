package keeper.log4j.attack.service;

import keeper.log4j.attack.entity.AttackEntity;
import keeper.log4j.attack.repository.AttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MainManageService {

  @Autowired
  AttackRepository attackRepository;

  public void saveIpToDB(String ip){

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
    Date now = new Date();
    String now_dt = format.format(now);

    AttackEntity attackEntity = AttackEntity.builder()
            .ip(ip)
            .connectionDate(now_dt)
            .build();

    attackRepository.save(attackEntity);

  }

  /**
   * 취약한 자바 클래스
   */
  public void attackJavaClass(){

  }
}
