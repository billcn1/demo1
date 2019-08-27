package com.example.demo1.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Car {
    @Max(value=100,message="id不能大于100")
    private Integer id;
    @NotBlank(message="用户名不能为空")
    @Length(min = 2, max = 10, message = "用户名 长度必须在 {min} - {max} 之间")
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$",message = "手机格式不合法")
    private String name;
   @DecimalMax(value = "10",message = "价格不能高于10元")
   @DecimalMin(value = "1",message = "价格不能低于2元")
    private Float price;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @JsonIgnore
    private String memo;
    @JsonInclude
    @NotNull(message = "属性字段不能为空")
    @NotBlank(message = "属性字段不能为空白")
    private String isnull;
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",message = "邮箱格式不合法")
    private String email;

    public Car(@Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "邮箱格式不合法") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car(Integer id, String name, Float price, Date createdate, String memo, String isnull) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdate = createdate;
        this.memo = memo;
        this.isnull = isnull;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIsnull() {
        return isnull;
    }

    public void setIsnull(String isnull) {
        this.isnull = isnull;
    }

    public Car() {
    }
}
