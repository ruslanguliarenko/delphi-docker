package com.udelphi.dto;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ApiModel(description = "All details about the product.")
public class ProductDto extends AuditableDto{
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;
    @ApiModelProperty(notes = "Product name")
    private String name;
    @ApiModelProperty(notes = "Product description")
    private String description;
    @ApiModelProperty(notes = "Product price")
    private double price;
    @ApiModelProperty(notes = "Categories that have a product")
    @JsonIgnoreProperties(value = {"name",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    private Set<CategoryDto> categories = new HashSet<>();
    @JsonIgnoreProperties(value = {"text", "user", "product", "comments", "comment",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "Comment that have a product")
    private Set<CommentDto> comments = new HashSet<>();
    @JsonIgnoreProperties(value = {"order", "product", "quantity",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "Order items that have a product")
    private Set<OrderItemDto> orderItems = new HashSet<>();

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public ProductDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Set<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public ProductDto setOrderItems(Set<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public ProductDto setComments(Set<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public ProductDto setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
        return this;
    }
}
