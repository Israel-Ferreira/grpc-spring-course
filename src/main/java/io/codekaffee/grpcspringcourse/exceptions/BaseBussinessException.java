package io.codekaffee.grpcspringcourse.exceptions;

import io.grpc.Status;

public abstract class BaseBussinessException extends RuntimeException {
    public BaseBussinessException(String message) {
        super(message);
    }

    public abstract Status getStatusCode();
    public abstract String getErrorMessage();
}
