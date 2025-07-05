package main.product.service;

import main.product.model.CartItem;
import main.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();
    public void add(Product product,int quantity) throws Exception{
        if(quantity>product.getQuantity()){
            throw new Exception("Insufficient stock for: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        for (CartItem item:items){
            subtotal+=item.getTotalPrice();
        }
        return subtotal;
    }

}
