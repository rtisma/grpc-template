package org.icgc.dcc.helloworld.client;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class)
public class ClientTest {

  @Test
  public void testClient(){
    val client = GreeterClient.createGreeterClient("localhost", 6565);
    val message = client.sayHello("John", "Doe");
    log.info("Response: {}", message);
  }

}
