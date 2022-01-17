package keeper.log4j.attack.service;

import org.springframework.stereotype.Service;

@Service
public class MainManageService {

  /**
   * 접속 아이피 표시
   */
  public String displayIP(){
    return "127.0.0.1";
  }
}
