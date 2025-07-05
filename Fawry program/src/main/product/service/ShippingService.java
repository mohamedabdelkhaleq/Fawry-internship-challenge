package main.product.service;

import main.product.model.CartItem;
import main.product.model.Product;
import main.product.model.ShippableItem;

import java.util.List;

public class ShippingService {
    public static void ship(List<ShippableItem> items){
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (ShippableItem item : items) {
                System.out.printf("1x %s%n",item.getName());
                totalWeight += item.getWeight() * item.getQuantity();
            }
        System.out.printf("Total package weight %.1fkg%n",totalWeight);
        }
    }
