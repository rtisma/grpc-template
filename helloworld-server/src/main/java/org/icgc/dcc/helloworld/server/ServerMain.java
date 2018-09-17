package org.icgc.dcc.helloworld.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class ServerMain {

  public static void main(String[] args){
    SpringApplication.run(ServerMain.class, args);
  }

}
