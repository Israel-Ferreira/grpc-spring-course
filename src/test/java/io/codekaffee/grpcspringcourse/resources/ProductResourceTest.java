package io.codekaffee.grpcspringcourse.resources;

import io.codekaffee.grpcspringcourse.ProductRequest;
import io.codekaffee.grpcspringcourse.ProductServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@DirtiesContext
@TestPropertySource("classpath:application-test.properties")
public class ProductResourceTest {

    @GrpcClient("inProcess")
    private ProductServiceGrpc.ProductServiceBlockingStub client;

    @Test
    @DisplayName("When valid data is provides a product is created ")
    public void createProductSuccessTest() {
        var productRequest = ProductRequest.newBuilder()
                .setName("Paçoca 30 Unidades ")
                .setPrice(30.00)
                .setQuantityInStock(12)
                .setSku("233HJSB")
                .setDescription("Pacote com 30 Unidades de Paçoca")
                .build();

        var result = client.createProduct(productRequest);

        Assertions.assertThat(productRequest)
                .usingRecursiveComparison()
                .comparingOnlyFields("name", "price", "quantity_in_stock", "sku")
                .isEqualTo(result);


    }

}
