package com.angelh0.stayhub_user.grpc.grpcServiceImpl;

import com.angelh0.stayhub_user.dto.UserDTO;
import com.angelh0.stayhub_user.service.UserService;
import com.infoUserGrpc.grpc.getInfoRequest;
import com.infoUserGrpc.grpc.infoUserResponse;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.infoUserGrpc.grpc.infoGrpc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@GrpcService
public class GrpcInfoUserServiceImpl extends infoGrpc.infoImplBase {

    @Autowired
    UserService userService;

    @Override
    public void getInfoUser(getInfoRequest request, StreamObserver<infoUserResponse> responseObserver) {

        String uuid = request.getUuid();

        try {
            UserDTO userDTO = userService.infoUser(UUID.fromString(uuid));

            infoUserResponse response = infoUserResponse.newBuilder()
                    .setUuid(userDTO.getUuidUser().toString())
                    .setEmail(userDTO.getEmail())
                    .setFirstName(userDTO.getFirstName())
                    .setLastName(userDTO.getLastName())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(io.grpc.Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException());
        }
    }
}
