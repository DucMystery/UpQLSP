package CodeGym.Model;

public class Television extends Product  {

    private  double inch;

    public Television(){}

    public Television(int id, String name, String brand, double inch, double price, String description){
        this.id =id;
        this.name =name;
        this.brand = brand;
        this.inch = inch;
        this.price =price;
        this.description = description;
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
        this.name=name;
    }

    @Override
    public void setBrand(String brand) {
        this.brand =brand;
    }

    @Override
    public void setDescription(String description) {
        this.description =description;
    }

    public double getInch() {
        return inch;
    }

    public Television setInch(double inch) {
        this.inch = inch;
        return this;
    }

    @Override

    public String toString(){
        return "ID : "+getId()+" , Name : "+getName()+" , Brand : "+getBrand()+" , Inch : "+getInch()+" , Price : "+getPrice()+" , Description : "+getDescription();
    }
}
