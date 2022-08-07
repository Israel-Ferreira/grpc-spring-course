package io.codekaffee.grpcspringcourse.dto;


public class ProductOutputDTO {
    private final Long id;

    private final String name;

    private final Double price;

    private final Integer quantityInStock;

    private final String sku;

    private final String description;

    public ProductOutputDTO(Long id, String name, Double price, Integer quantityInStock, String sku, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.sku = sku;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }
}
