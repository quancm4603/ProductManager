package productmanager;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> ProductList;

    public ProductRepository() {
        ProductList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        ProductList.add(product);
    }

    public List<Product> getAllProducts() {
        return ProductList;
    }
    
    public Product searchProductById(int id){
        for(Product product : ProductList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
