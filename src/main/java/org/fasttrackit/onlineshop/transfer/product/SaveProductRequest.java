package org.fasttrackit.onlineshop.transfer.product;

import javax.validation.constraints.NotNull;

public class SaveProductRequest {

    @NotNull
    private String name;
    private String imageUrl;
    @NotNull
    private Integer quantity;
    private String description;
    @NotNull
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SaveProductRequest{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
