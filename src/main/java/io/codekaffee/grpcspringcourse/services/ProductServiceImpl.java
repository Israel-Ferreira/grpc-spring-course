package io.codekaffee.grpcspringcourse.services;

import io.codekaffee.grpcspringcourse.domain.Product;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.dto.ProductOutputDTO;
import io.codekaffee.grpcspringcourse.repositories.ProductRepository;
import io.codekaffee.grpcspringcourse.utils.ProductConverterUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductOutputDTO> findAll() {
        return productRepository.findAll().stream()
                .map(ProductConverterUtils::convertProductInProductOutput)
                .collect(Collectors.toList());
    }

    @Override
    public ProductOutputDTO create(ProductInputDto input) {
        Product product = ProductConverterUtils.convertProductInputDTOInProduct(input);
        product = productRepository.save(product);

        return ProductConverterUtils.convertProductInProductOutput(product);
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        Optional<Product> product =  productRepository.findById(id);

        return product.map(ProductConverterUtils::convertProductInProductOutput)
                .orElse(ProductConverterUtils.convertProductInProductOutput(new Product()));
    }

    @Override
    public void deleteById(Long id) {

    }
}
