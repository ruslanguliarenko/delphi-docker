package com.udelphi.dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ApiModel(description = "All details about the category.")
public class CategoryDto extends AuditableDto {

    @ApiModelProperty(notes = "Database generated category ID")
    private Integer id;
    @ApiModelProperty(notes = "Category name")
    private String name;

    public CategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public CategoryDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDto setName(String name) {
        this.name = name;
        return this;
    }
}
