import main.product.model.*;
import main.product.service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            Cheese cheese = new Cheese("Cheese ", 100, 3, LocalDate.now().plusDays(3), 200);
            Biscuits biscuits = new Biscuits("Biscuits ", 150, 3, LocalDate.now().plusDays(2), 700);
            MobileScratchCard card = new MobileScratchCard("ScratchCard", 10, 10);
            Tv tv = new Tv("TV 55\"", 250, 2,100);

            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(card, 1);

            CheckoutService.checkout(cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
