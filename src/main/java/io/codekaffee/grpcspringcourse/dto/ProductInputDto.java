package io.codekaffee.grpcspringcourse.dto;

public class ProductInputDto {
    private final String name;
    private final Double price;

    private final Integer quantityInStock;

    private final String sku;

    private  final String description;


    public ProductInputDto(String name, Double price, Integer quantityInStock, String sku, String description) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.sku = sku;
        this.description = description;
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
