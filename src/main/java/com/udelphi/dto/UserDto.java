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
@ApiModel(description = "All details about the user.")
public class UserDto  extends  AuditableDto{
    @ApiModelProperty(notes = "The database generated user ID")
    private Integer id;
    @ApiModelProperty(notes = "User name")
    private String name;
    @ApiModelProperty(notes = "User email")
    private String email;
    @ApiModelProperty(notes = "User password")
    private String password;
    @JsonIgnoreProperties(value = {"name",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "Roles that have a user")
    private Set<RoleDto> roles = new HashSet<>();
    @JsonIgnoreProperties(value = {"text", "user", "product", "comments", "comment",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "Comments that have a user")
    private Set<CommentDto> comments = new HashSet<>();
    @JsonIgnoreProperties(value = {"orderDate", "client", "orderItems",
            "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
    @ApiModelProperty(notes = "Orders that have a user")
    private Set<OrderDto> orders = new HashSet<>();

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public UserDto setOrders(Set<OrderDto> orders) {
        this.orders = orders;
        return this;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public UserDto setComments(Set<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public UserDto setRoles(Set<RoleDto> roles) {
        this.roles = roles;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
