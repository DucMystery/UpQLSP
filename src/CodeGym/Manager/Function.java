package CodeGym.Manager;

import CodeGym.Model.Product;
import CodeGym.ProductList.ProductList;

public interface Function {

    ProductList<Product> sortByPriceUp();
    ProductList<Product> sortByPriceDown();

    void findByName (String name);
    void editNameByID(int id, String newName);
    void editPriceByID(int id, double newPrice);
    void editDescriptionByID(int id, String newDescription);
    void  deleteProductByID(int id);
    void displayAll(ProductList<Product> products);
}
