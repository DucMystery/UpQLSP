package CodeGym.Manager;

import CodeGym.Model.Fridge;
import CodeGym.Model.Product;
import CodeGym.Model.Television;
import CodeGym.ProductList.ProductList;

import java.io.*;

public class ProductManager implements Function{

    public final ProductList<Product> products;

    public ProductManager(ProductList<Product> products) {
        this.products = products;
    }

    public void creatFridge(int id, String name,String brand,double price,double capacity,String description ){
        Product product = new Fridge(id,name,brand,price,capacity,description);
        products.add(product);
    }
    public void creatTelevision(int id, String name, String brand, double inch, double price, String description ){
        Product product = new Fridge(id,name,brand,inch,price,description);
        products.add(product);
    }

    public boolean checkID(int id){
        for (Product product :products){
            if (product.getId()==id)
                return true;
        }
        return false;
    }

    public synchronized void save(){
        try {
            FileOutputStream fout = new FileOutputStream("productList.txt");
            for (Product product :products){
                byte[]bytes = product.toString().getBytes();
                byte[] downLine ="\n".getBytes();
                fout.write(bytes);
                fout.write(downLine);
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() throws IOException {
        FileReader reader = new FileReader("productList.txt");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line =br.readLine())!=null){
            String []content =line.split(" ,");
            for (Product product : products){
                if (product instanceof Fridge){
                    product =(Fridge)product;
                    int id = Integer.parseInt(content[0].substring(4));
                    String name = content[1].substring(7);
                    String brand = content[2].substring(8);
                    double price = Double.parseDouble(content[3].substring(8));
                    double capacity = Double.parseDouble(content[4].substring(11));
                    String description = content[5].substring(14);
                    creatFridge(id,name,brand,price,capacity,description);
                }
                if (product instanceof Television){
                    product =(Television)product;
                    int id = Integer.parseInt(content[0].substring(4));
                    String name = content[1].substring(7);
                    String brand = content[2].substring(8);
                    double inch = Double.parseDouble(content[3].substring(7));
                    double price = Double.parseDouble(content[4].substring(8));
                    String description = content[5].substring(14);
                    creatTelevision(id,name,brand,inch,price,description);
                }
            }
        }
        br.close();
    }



    @Override
    public ProductList<Product> sortByPriceUp() {
        for (int i = 0; i<products.size();i++){
            Product currentMin = products.get(i);
            int currentMinIndex = i;

            for (int j =i+1;j<products.size();j++){
                if (currentMin.getPrice()>products.get(j).getPrice()){
                    currentMin =products.get(j);
                    currentMinIndex =j;
                }
            }

            if (currentMinIndex !=i){
                products.set(currentMinIndex,products.get(i));
                products.set(i,currentMin);
            }
        }
        return products;
    }

    @Override
    public ProductList<Product> sortByPriceDown() {
        boolean status = true;
        for (int k = 1; k < products.size() && status; k++) {
            status = false;
            for (int i = 0; i < products.size() - k; i++) {
                if (products.get(i).getPrice() < products.get(i + 1).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(i + 1));
                    products.set(i + 1, temp);

                    status = true;
                }
            }
        }
        return products;
    }

    @Override
    public void findByName(String name) {
        for (int  i=0;i<products.size();i++){
            if (products.get(i).getName().contains(name)){
                System.out.println(products.get(i));
            }
        }
    }

    @Override
    public void editNameByID(int id, String newName) {
        for (int i =0; i<products.size();i++){
            if (products.get(i).getId()==id){
                products.get(i).setName(newName);
                break;
            }
        }
    }

    @Override
    public void editPriceByID(int id, double newPrice) {

        for (int i =0; i<products.size();i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setPrice(newPrice);
                break;
            }
        }

    }

    @Override
    public void editDescriptionByID(int id, String newDescription) {
        for (int i =0; i<products.size();i++) {
            if (products.get(i).getId() == id) {
                products.get(i).setDescription(newDescription);
                break;
            }
        }
    }

    @Override
    public void deleteProductByID(int id) {
        products.removeIf(n->(n.getId()==id));
    }

    @Override
    public void displayAll(ProductList<Product> products) {
        for (Product product :products){
            if (product instanceof Fridge){
                product =(Fridge)product;
                System.out.println(product.toString());
            }else if (product instanceof Television){
                product = (Television)product;
                System.out.println(product.toString());
            }
        }
    }
}
