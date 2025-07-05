package main.product.model;
public class Mobile extends Product implements Shippable,ShippableItem {
    private double weight;

    public Mobile(String name, double price, int quantity) {
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
