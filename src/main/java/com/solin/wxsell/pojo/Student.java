package com.solin.wxsell.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("swagger 实体类解释说明")
public class Student {

    @ApiModelProperty("学生姓名")
    private String name;
    @ApiModelProperty("学生姓名")
    private Integer age;
    @ApiModelProperty("学生身高")
    private Double height;
    @ApiModelProperty("学生体重")
    private Double weight;

    public Student(String name, Integer age, Double height, Double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
