package io.codekaffee.grpcspringcourse.services;

import io.codekaffee.grpcspringcourse.domain.Product;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.dto.ProductOutputDTO;

import java.util.List;

public interface IProductService {
    List<ProductOutputDTO> findAll();
    ProductOutputDTO create(ProductInputDto input);
    ProductOutputDTO findById(Long id);
    void deleteById(Long id);
}
