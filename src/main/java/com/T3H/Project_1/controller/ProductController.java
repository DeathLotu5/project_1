package com.T3H.Project_1.controller;

import com.T3H.Project_1.model.Cart;
import com.T3H.Project_1.model.OderItem;
import com.T3H.Project_1.model.ProductDTO;
import com.T3H.Project_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/add-to-card/{productId}")
    public String addToCard(HttpServletRequest req, @PathVariable(name = "productId") int id, HttpSession session) {
        ProductDTO productDTO = productService.getById(id);
        if (session.getAttribute("cart") == null) {
            Cart cart = new Cart();
            OderItem oderItem = new OderItem();
            oderItem.setQuanity(1);
            oderItem.setProductDTO(productDTO);
            List<OderItem> itemList = new ArrayList<OderItem>();
            itemList.add(oderItem);

            cart.setOderItem(itemList);
            session.setAttribute("cart", cart);
            req.setAttribute("order", cart);
        } else {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OderItem> itemList = cart.getOderItem();
            boolean flag = false;
            for(OderItem  oderItem : itemList) {
                if(oderItem.getProductDTO().getId() == productDTO.getId()) {
                    oderItem.setQuanity(oderItem.getQuanity() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                OderItem oderItem = new OderItem();
                oderItem.setQuanity(1);
                oderItem.setProductDTO(productDTO);

                itemList.add(oderItem);
            }
            session.setAttribute("cart", cart);
            req.setAttribute("order", cart);
        }

        return "cart";
    }

    @GetMapping("/view-cart")
    public String viewCart(HttpServletRequest req, HttpSession session) {
        if(session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            req.setAttribute("order", cart);
        }


        return "cart";
    }

}
