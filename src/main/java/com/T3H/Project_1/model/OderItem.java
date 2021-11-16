package com.T3H.Project_1.model;

import java.util.List;

public class OderItem {
    private int Quanity;
    private ProductDTO productDTO;

    public OderItem() {

    }

    public int getQuanity() {
        return Quanity;
    }

    public void setQuanity(int quanity) {
        Quanity = quanity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
