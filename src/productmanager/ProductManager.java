package productmanager;

import java.util.List;
import java.util.Scanner;

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
        ProductManager productManager = new ProductManager(productRepository);

        Scanner scanner = new Scanner(System.in);
        int choice;
        int id = 1;
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Search product by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // Nhập sản phẩm từ bàn phím
                    System.out.println("Enter product details:");
                    System.out.print("Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Price: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character

                    productRepository.addProduct(new Product(id, productName, productPrice));
                    id++;
                    break;

                case 2:
                    // Hiển thị danh sách sản phẩm
                    productManager.displayAllProducts();
                    break;

                case 3:
                    // Tìm kiếm sản phẩm theo ID
                    System.out.println("Enter product ID:");
                    int productId = scanner.nextInt();
                    System.out.println(productRepository.searchProductById(productId));;
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
