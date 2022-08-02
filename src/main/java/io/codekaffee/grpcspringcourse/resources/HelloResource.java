package io.codekaffee.grpcspringcourse.resources;

import io.codekaffee.grpcspringcourse.HelloReq;
import io.codekaffee.grpcspringcourse.HelloResp;
import io.codekaffee.grpcspringcourse.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloResource  extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloReq request, StreamObserver<HelloResp> responseObserver) {
        var resp = HelloResp.newBuilder().setMessage(request.getMessage()).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
