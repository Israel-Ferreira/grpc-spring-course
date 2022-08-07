package io.codekaffee.grpcspringcourse.util;

import io.codekaffee.grpcspringcourse.domain.Product;
import io.codekaffee.grpcspringcourse.dto.ProductInputDto;
import io.codekaffee.grpcspringcourse.utils.ProductConverterUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductConverterUtilTest {

    @Test
    public void productToProductOutputDtoTest() {
        var product = new Product(1L, "Paçoca - Caixa com 30 Unidades", 10.00, 10, "JXW3K", "Paçoca");

        var output = ProductConverterUtils.convertProductInProductOutput(product);

        Assertions.assertThat(output)
                .usingRecursiveComparison()
                .isEqualTo(product);
    }


    @Test
    public void productInputToProduct() {
        var input = new ProductInputDto("Paçoca - Caixa com 30 Unidades", 20.00, 10, "JXW3K", "Paçoca Paçoquita");
        var product =  ProductConverterUtils.convertProductInputDTOInProduct(input);

        Assertions.assertThat(input)
                .usingRecursiveComparison()
                .isEqualTo(product);
    }
}
