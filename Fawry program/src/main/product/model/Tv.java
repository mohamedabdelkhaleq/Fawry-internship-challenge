package main.product.model;

public class Tv extends Product implements Shippable,ShippableItem {
    private double weight;

    public Tv(String name, double price, int quantity,double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public String getName() {
        return super.getName() + " " + weight + "g";
    }
}
