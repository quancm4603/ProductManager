package productmanager;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getAllProducts() {
        return productList;
    }
    
    public Product searchProductById(int id){
        for(Product product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
