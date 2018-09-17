package org.icgc.dcc.helloworld.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.NonNull;
import lombok.val;
import org.icgc.dcc.helloworld.schema.GreeterGrpc;
import org.icgc.dcc.helloworld.schema.GreeterGrpc.GreeterBlockingStub;
import org.icgc.dcc.helloworld.schema.Helloworld;
import org.springframework.stereotype.Component;

@Component
public class GreeterClient {

  private final ManagedChannel managedChannel;
  private final GreeterBlockingStub stub;

  public GreeterClient(@NonNull ManagedChannel managedChannel,
     @NonNull GreeterBlockingStub stub) {
    this.managedChannel = managedChannel;
    this.stub = stub;
  }

  public String sayHello(String firstName, String lastName){
    val req  = Helloworld.HelloWorldRequest.newBuilder()
        .setFirstname(firstName)
        .setLastname(lastName)
        .build();
    val resp = stub.sayHello(req);
    return resp.getMsg();
  }

  public static GreeterClient createGreeterClient(@NonNull String host, final int port){
    val mc = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    val stub = GreeterGrpc.newBlockingStub(mc);
    return new GreeterClient(mc, stub);

  }

}
