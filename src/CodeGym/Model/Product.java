package CodeGym.Model;

public abstract class Product {

    protected int id;
    protected double price;
    protected String name;
    protected String brand;
    protected String description;


    public abstract void setId(int id);
    public abstract void setPrice(double price);
    public abstract void setName(String name);
    public abstract void setBrand(String brand);
    public abstract void setDescription(String description);

    public  int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return null;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }
}
