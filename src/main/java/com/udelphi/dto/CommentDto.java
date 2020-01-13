package com.udelphi.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ApiModel(description = "All details about the comment.")
public class CommentDto extends AuditableDto{
    @ApiModelProperty(notes = "Database generated comment ID")
    private Integer id;
    @ApiModelProperty(notes = "Comment text")
    private String text;
    @ApiModelProperty(notes = "Id user who written comment")
    private UserDto user;
    @ApiModelProperty(notes = "Id product to which it was written comment")
    private ProductDto product;
    @JsonIgnoreProperties(value = {"text", "user", "product", "comments", "comment",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "List sub comments")
    private Set<CommentDto> comments;
    @ApiModelProperty(notes = "Sub comment")
    private CommentDto comment;

    public CommentDto() {
    }

    public CommentDto getComment() {
        return comment;
    }

    public CommentDto setComment(CommentDto comment) {
        this.comment = comment;
        return this;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public CommentDto setComments(Set<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public CommentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public CommentDto setText(String text) {
        this.text = text;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public CommentDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public ProductDto getProduct() {
        return product;
    }

    public CommentDto setProduct(ProductDto product) {
        this.product = product;
        return this;
    }
}
