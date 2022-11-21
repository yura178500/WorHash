import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.*;



public class Product {

    private String name;
    private double requiredQuantity;
    private BigDecimal price;


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.requiredQuantity, requiredQuantity) == 0 && name.equals(product.name) && price.equals(product.price);
    }


    public int hashCode() {
        return Objects.hash(name, requiredQuantity, price);
    }


    public String toString() {
        return "Список товаров" +
                "   Название' " + name + '\'' +
                ", Количество " + requiredQuantity +
                ", Цена " + price + "кг";
    }




    public Product(String name, double requiredQuantity, BigDecimal price) {
        this.requiredQuantity = requiredQuantity;
        this.price = price;
        if (!name.isEmpty() && price != null) {
            this.name = name;
        }
    }

    private boolean isNullOrEmpty(String price) {
        return false ;
    }


    public String getName() {
        return name;
    }

    public double getRequiredQuantity() {
        return requiredQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static class Shop {
    private Set<Product> products = new HashSet<>(10);

    public void addProducts(Product... products) {
        Collections.addAll(this.products, products);
    }

    public void removeProduct(Product products) {
        this.products.remove(products);
    }
    public void insert( Product products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Продукты", true))) {
            oos.writeObject(new Product( products.getName(),products.getRequiredQuantity() ,products.getPrice()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Set<Product> productByName(String title) {
        Set<Product> product = new HashSet<>(10);
        for (Product prod : products) {
            if (prod.getName().equals(title)) {
                product.add(prod);
            }else {
                System.out.println("Продукт сушествует");
        }

    }
        return product;
    }



    public Set<Product> productInRange(BigDecimal minPrice, double requiredQuantity, BigDecimal maxPrice) {
        Set<Product> products = new HashSet<>();
        for (Product prod : this.products) {
            if (prod.getPrice().compareTo(minPrice) > 0 && prod.getPrice().compareTo(maxPrice) < 0) {
                products.add(prod);
            }
        }
        return products;
    }


    public void addAllProducts() {

    }
}


}

