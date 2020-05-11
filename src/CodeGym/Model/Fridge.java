package CodeGym.Model;

public class Fridge extends Product{
    private double capacity;
    public Fridge(){}

    public Fridge (int id, String name,String brand,double price,double capacity,String description){
        this.id =id;
        this.name =name;
        this.brand =brand ;
        this.price = price;
        this.capacity =capacity;
        this.description= description;
    }



    public double getCapacity() {
        return capacity;
    }

    public Fridge setCapacity(double capacity) {
        this.capacity = capacity;
        return this;
    }


    @Override
    public void setId(int id) {
        this.id =id;
    }

    @Override
    public void setPrice(double price) {
        this.price =price;
    }

    @Override
    public void setName(String name) {
        this.name =name;
    }

    @Override
    public void setBrand(String brand) {
        this.brand =brand;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String toString(){
        return "ID : "+getId()+" , Name : "+getName()+" , Brand : "+getBrand()+" , Price : "+getPrice()+" , Capacity : "+getCapacity()+" , Description : "+getDescription();
    }
}
