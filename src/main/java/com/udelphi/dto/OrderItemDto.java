package com.udelphi.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ApiModel(description = "All details about the order item.")
public class OrderItemDto  extends AuditableDto{
    @ApiModelProperty(notes = "The database generated order item ID")
    private Integer id;
    @ApiModelProperty(notes = "Product quantity")
    private Integer quantity;
    @ApiModelProperty(notes = "Id product")
    private ProductDto product;
    @ApiModelProperty(notes = "Id order who have this order item")
    private OrderDto order;

    public OrderItemDto() {
    }

    public ProductDto getProduct() {
        return product;
    }

    public OrderItemDto setProduct(ProductDto product) {
        this.product = product;
        return this;
    }

    public OrderDto getOrder() {
        return order;
    }

    public OrderItemDto setOrder(OrderDto order) {
        this.order = order;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public OrderItemDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
