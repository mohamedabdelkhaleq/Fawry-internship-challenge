package main.product.service;

import main.product.model.CartItem;
import main.product.model.Expirable;
import main.product.model.Product;
import main.product.model.ShippableItem;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_FEE = 30.0;
    public static void checkout(Cart cart) throws Exception{
        if(cart.isEmpty()) throw new Exception("Cart is empty");
        List<CartItem> items = cart.getItems();
        List<ShippableItem> toShip = new ArrayList<>();
        double subtotal = 0;
        for (CartItem item:items){
            Product product = item.getProduct();
            if(product instanceof Expirable&&((((Expirable) product).isExpired()))){
                throw new Exception(product.getName()+"Is Expired.");
            }
            if (item.getQuantity() > product.getQuantity()) {
                throw new Exception("Not enough stock for: " + product.getName());
            }
            if (product instanceof ShippableItem) {
                toShip.add((ShippableItem) product);
            }
            subtotal += item.getTotalPrice();
        }
        double shipping;
        if (toShip.isEmpty()) {
            shipping = 0;
        } else {
            shipping = SHIPPING_FEE;
        }
        double total = subtotal + shipping;
        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        if (!toShip.isEmpty()) ShippingService.ship(toShip);

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s %.0f$%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shipping);
        System.out.printf("Amount %.0f%n", total);
    }

    }


