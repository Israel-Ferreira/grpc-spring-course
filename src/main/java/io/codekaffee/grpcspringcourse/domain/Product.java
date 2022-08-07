package io.codekaffee.grpcspringcourse.domain;


import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(unique = true)
    private String sku;


    public Product() {
    }

    public Product(Long id, String name, Double price, Integer quantityInStock, String sku, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.sku = sku;
        this.description = description;
    }

    public Product(String name, Double price, Integer quantityInStock, String sku, String description) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.sku = sku;
        this.description = description;
    }

    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
