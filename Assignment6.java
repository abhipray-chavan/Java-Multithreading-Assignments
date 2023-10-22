import java.util.ArrayList;
import java.util.List;

public class Assignment6 {
    public static class Product {
        private String name;
        private String category;
        
        public Product(String name, String category) {
            this.name = name;
            this.category = category;
        }
        
        public String getName() {
            return name;
        }
        
        public String getCategory() {
            return category;
        }
    }
    
    public static List<Product> filterByCategory(List<Product> products, String category) {
        List<Product> filteredProducts = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        
        return filteredProducts;
    }
    
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("iPhone", "Electronics"));
        products.add(new Product("T-shirt", "Clothing"));
        products.add(new Product("Headphones", "Electronics"));
        products.add(new Product("Shoes", "Footwear"));
        
        // Filter products by category
        List<Product> filteredProducts = Assignment6.filterByCategory(products, "Electronics");
        
        // Display the filtered products
        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }
    }
}