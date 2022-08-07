package io.codekaffee.grpcspringcourse.utils;

import io.codekaffee.grpcspringcourse.domain.Product;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.dto.ProductOutputDTO;

public class ProductConverterUtils {

    public static Product convertProductInputDTOInProduct(ProductInputDto inputDto) {
        return new Product(
                inputDto.getName(),
                inputDto.getPrice(),
                inputDto.getQuantityInStock(),
                inputDto.getSku(),
                inputDto.getDescription()
        );
    }

    public static ProductOutputDTO convertProductInProductOutput(Product product) {
        return new ProductOutputDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock(),
                product.getSku(),
                product.getDescription()
        );
    }
}
