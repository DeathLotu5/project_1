package com.T3H.Project_1.model;

import javax.persistence.Column;

public class ProductDTO {
    private int id;

    @Column(name="`DESC`")
    private String desc;

    private int price;

    @Column(name="PRODUCT_NAME")
    private String productName;

    public ProductDTO() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
