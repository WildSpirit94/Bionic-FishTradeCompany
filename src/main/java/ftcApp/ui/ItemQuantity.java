package ftcApp.ui;

import ftcApp.model.Item;

import java.io.Serializable;

public class ItemQuantity implements Serializable {
    private Item item;
    private double weight;

    public ItemQuantity() {
    }

    public ItemQuantity(Item item, double weight) {
        this.item = item;
        this.weight = weight;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
