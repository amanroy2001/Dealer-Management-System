//Name- Aman Roy Emp id- 927836
public class Laptop {
    private String brand;
    private double price;
    private int inventory;

    public Laptop(String brand, double price, int inventory) {
        this.brand = brand;
        this.price = price;
        this.inventory = inventory;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
