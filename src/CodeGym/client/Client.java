package CodeGym.client;

import CodeGym.Manager.ProductManager;
import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    private ProductList<Product> products;
    private ProductManager productManager;
    Scanner scanner = new Scanner(System.in);
    public final String NAME="Admin";

    public Client() throws IOException {
        this.products = new ProductList<Product>();
        this.productManager = new ProductManager(products);
        productManager.read();
    }

    public void account(){
        System.out.println("You are : ");
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        int pick = scanner.nextInt();
        switch (pick){
            case 1:
                System.out.println("Enter a name :");
                scanner.nextLine();
                String nameAdmin = scanner.nextLine();
                if (nameAdmin.equals(NAME))
                    displayAdmin();
                System.out.println("Error");
                account();
                break;
            case 2:
                displayCustomer();
                break;
            default:
                System.out.println("Enter 1 or 2 .");
                account();
        }
    }

    public void displayAdmin(){
        System.out.println("Enter a :");
        System.out.println("1. Add new Product");
        System.out.println("2. Edit name by ID");
        System.out.println("3. Edit price by ID");
        System.out.println("4. Edit description by ID");
        System.out.println("5. Edit brand by ID");
        System.out.println("0. Exit");
        int pick = scanner.nextInt();
        switch (pick){
            case 1 :
               chooseAddProduct();
               int pick1 = scanner.nextInt();
                switch (pick1){
                    case 1 :
                        System.out.println("Enter a ID of Fridge :");
                        int id = scanner.nextInt();
                        System.out.println("Enter a name of Fridge :");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("Enter a brand of Fridge :");
                        String brand = scanner.next();
                        System.out.println("Enter a price of Fridge :");
                        double price = scanner.nextDouble();
                        System.out.println("Enter a capacity of Fridge :");
                        double capacity = scanner.nextDouble();
                        System.out.println("Enter a description of Fridge :");
                        scanner.nextLine();
                        String description = scanner.nextLine();
                        productManager.creatFridge(id,name,brand,price,capacity,description);
                        productManager.save();
                        System.out.println("Done!");
                        displayAdmin();
                        break;
                    case 2 :
                        System.out.println("Enter a ID of TV :");
                        int id1 = scanner.nextInt();
                        System.out.println("Enter a name of TV :");
                        scanner.nextLine();
                        String name1 = scanner.nextLine();
                        System.out.println("Enter a brand of TV :");
                        String brand1 = scanner.next();
                        System.out.println("Enter a inch of TV");
                        double inch = scanner.nextDouble();
                        System.out.println("Enter a price of TV :");
                        double price1 = scanner.nextDouble();
                        System.out.println("Enter a description of TV :");
                        scanner.nextLine();
                        String description1 = scanner.nextLine();
                        productManager.creatTelevision(id1,name1,brand1,inch,price1,description1);
                        productManager.save();
                        System.out.println("Done!");
                        displayAdmin();
                        break;
                    default:
                        System.out.println("Choose 1 or 2");
                        chooseAddProduct();

                }
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 0 :
        }

    }

    public void displayCustomer(){
        System.out.println("Enter a :");
        System.out.println("1. Find product by name .");
        System.out.println("2. Display all product.");
        System.out.println("3. View in ascending prices.");
        System.out.println("4. See in descending prices.");
        System.out.println("0.Exit.");
        int pick = scanner.nextInt();
        switch (pick){
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 0 :
        }
    }
    public void chooseAddProduct(){
        System.out.println("The type of product you want to add");
        System.out.println("1.Fridge");
        System.out.println("2.Television");
        System.out.println("0. Exit");
    }




}
