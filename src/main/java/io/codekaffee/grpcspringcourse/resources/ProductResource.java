package io.codekaffee.grpcspringcourse.resources;

import io.codekaffee.grpcspringcourse.*;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.dto.ProductOutputDTO;
import io.codekaffee.grpcspringcourse.services.ProductServiceImpl;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductResource(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public void findProducts(EmptyRequest request, StreamObserver<FindAllProductsResp> responseObserver) {
        super.findProducts(request, responseObserver);
    }

    @Override
    public void createProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        ProductInputDto input = new ProductInputDto(
                request.getName(),
                request.getPrice(),
                request.getQuantityInStock(),
                request.getSku(),
                request.getDescription()
        );

        ProductOutputDTO outputDTO = productService.create(input);

        ProductResponse resp = ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantityInStock())
                .setSku(outputDTO.getSku())
                .setDescription(outputDTO.getDescription())
                .build();

        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void findProductById(FindByIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.findProductById(request, responseObserver);
    }

    @Override
    public void deleteProduct(FindByIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.deleteProduct(request, responseObserver);
    }
}
