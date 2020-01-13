package com.udelphi.dto;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ApiModel(description = "All details about the order.")
public class OrderDto extends AuditableDto{
    @ApiModelProperty(notes = "The database generated order ID")
    private Integer id;
    @ApiModelProperty(notes = "Date when created order")
    private Date orderDate;
    @JsonIgnoreProperties(value = {"order", "product", "quantity",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "List order items")
    private Set<OrderItemDto> orderItems = new HashSet<>();
    @ApiModelProperty(notes = "Id client who make order")
    private UserDto client;

    public OrderDto() {
    }

    public UserDto getClient() {
        return client;
    }

    public OrderDto setClient(UserDto client) {
        this.client = client;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public OrderDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public OrderDto setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Set<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public OrderDto setOrderItems(Set<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
