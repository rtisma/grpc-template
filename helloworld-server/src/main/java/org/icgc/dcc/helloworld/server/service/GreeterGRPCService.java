package org.icgc.dcc.helloworld.server.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.icgc.dcc.helloworld.schema.GreeterGrpc;
import org.icgc.dcc.helloworld.schema.Helloworld;
import org.lognet.springboot.grpc.GRpcService;

import static java.lang.String.format;

@Slf4j
@GRpcService
public class GreeterGRPCService extends GreeterGrpc.GreeterImplBase {

  @Override public void sayHello(Helloworld.HelloWorldRequest request,
      StreamObserver<Helloworld.HelloWorldResponse> responseObserver) {
    val message = format("Hello World to %s %s", request.getFirstname(), request.getLastname());
    log.info(message);
    responseObserver.onNext(Helloworld.HelloWorldResponse.newBuilder()
        .setMsg(message)
        .build());
    responseObserver.onCompleted();
  }

}
