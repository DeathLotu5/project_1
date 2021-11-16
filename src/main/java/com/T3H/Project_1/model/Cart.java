package com.T3H.Project_1.model;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class Cart {
//    private int id;
    private List<OderItem> oderItem;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public List<OderItem> getOderItem() {
        return oderItem;
    }

    public void setOderItem(List<OderItem> oderItem) {
        this.oderItem = oderItem;
    }
}
