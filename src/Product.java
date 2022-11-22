import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.*;


public class Product extends Exception {

    private String name;


    private double requiredQuantity;
    private static BigDecimal price;


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.requiredQuantity, requiredQuantity) == 0 && name.equals(product.name) && price.equals(product.price);
    }

    public void setName(String name) {
        this.name = name;
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

    public  Product  (String name, double requiredQuantity, BigDecimal price) {

        if (!name.isEmpty() && price != null) {
            this.name = name;
        }
        this.requiredQuantity = requiredQuantity;
        this.price = price;

    }

    private boolean isNullOrEmpty(BigDecimal price) {
        return false;
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

        public void insert(Product products) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Продукты", true))) {
                oos.writeObject(new Product(products.getName(), products.getRequiredQuantity(), products.getPrice()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public Set<Product> productByName(String title) {
            Set<Product> product = new HashSet<>(10);
            for (Product prod : products) {
                if (prod.getName().equals(title)) {
                    product.add(prod);
                } else {
                    System.out.println("Продукт существует");
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

    private void Data() {

    }

    public static boolean checkDate(String name, double requiredQuantity, BigDecimal price) {

        try {
            check(name, requiredQuantity, price);

        } catch (WrongnameException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;


    }

    public static void check(String name, double requiredQuantity, BigDecimal price)
            throws WrongnameException {
        if (!checkDate(price)) {
            throw new WrongnameException("Заполните карточку товара полностью");
        }
        if (!checkDate(requiredQuantity)) {
            throw new WrongnameException("Заполните карточку товара полностью");

        }
        if (!price.equals(name)) {
            throw new WrongnameException("Заполните карточку товара полностью");
        }
    }

    private static boolean checkDate(BigDecimal price) {
        return false;
    }

    private static boolean checkDate(double requiredQuantity) {
        return false;
    }
}

