package productmanager;

import java.util.List;

public class ProductManager {
    
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void displayAllProducts() {
        List<Product> products = repository.getAllProducts();

        System.out.println("List of Products:");
        System.out.println("=================");
        for (Product product : products) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.addProduct(new Product(1, "Laptop", 999.99));
        productRepository.addProduct(new Product(2, "Smartphone", 599.99));
        productRepository.addProduct(new Product(3, "Headphones", 79.99));
        
        ProductManager productManager = new ProductManager(productRepository);
        productManager.displayAllProducts();
        
    }
    
}
