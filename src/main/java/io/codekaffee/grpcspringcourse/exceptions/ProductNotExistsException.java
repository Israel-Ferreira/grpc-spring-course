package io.codekaffee.grpcspringcourse.exceptions;

import io.grpc.Status;

public class ProductNotExistsException extends BaseBussinessException{

    private static final String ERROR_MESSAGE = "Produto %s não encontrado no sistema";
    private final String name;

    public ProductNotExistsException(String name) {
        super(String.format(ERROR_MESSAGE, name));
        this.name = name;
    }

    @Override
    public Status getStatusCode() {
        return Status.NOT_FOUND;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE, this.name);
    }
}
