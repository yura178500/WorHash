import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(10);
        products.add(new Product("Яблоки", 12, new BigDecimal("4.63")));
        products.add(new Product("Груши", 20, new BigDecimal("2.27")));
        products.add(new Product("Киви", 13, new BigDecimal("0.99")));
        products.add(new Product("Огурцы", 12, new BigDecimal("4.63")));
        products.add(new Product("Помидоры", 20, new BigDecimal("2.27")));
        products.add(new Product("Гранат", 13, new BigDecimal("0.99")));
        products.add(new Product("Банан", 12, new BigDecimal("4.63")));
        products.add(new Product("Мандарин", 20, new BigDecimal("2.27")));
        products.add(new Product("Капуста", 13, new BigDecimal("0.99")));
        products.add(new Product("Апельсин", 12, new BigDecimal("4.63")));
        Product element = "Апельсин";
        products.add(element);
        products.remove(element);

        System.out.println("Список товара  " + Arrays.toString(products.toArray()));

        System.out.println(products);


        boolean containsElement =
                products.contains("Апельсин");
        System.out.println(containsElement);



}}




