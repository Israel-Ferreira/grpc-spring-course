package io.codekaffee.grpcspringcourse.services;


import io.codekaffee.grpcspringcourse.domain.Product;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.dto.ProductOutputDTO;
import io.codekaffee.grpcspringcourse.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("When create product service is call with valid data  a product")
    public void createProductSuccessTest() {
        Product product = new Product(1L, "Fone de Ouvido Auricular JBL", 100.00, 5, "JDWERRK", "");

        when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(product);


        ProductInputDto productInputDto = new ProductInputDto("Fone de Ouvido Auricular JBL", 100.00, 5, "JDWERRK", "");
        ProductOutputDTO result = productService.create(productInputDto);

        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(product);

    }
}
