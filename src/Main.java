import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_CAPACITY = 10;
    private static String setNameRecipe;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        // Название салата
        setNameRecipe = " Фруктовый микс";

        Recipes[] busket = new Recipes[MAX_CAPACITY];
        int busketSize = 0;

        System.out.println("Список возможных продуктов для салата");
        for (int i = 1; i <= Recipes.PRODUCTS.length; i++) {
            System.out.println(i + ". " + Recipes.PRODUCTS[i - 1] + "(" + Recipes.PRICES[i - 1] + " р.)");
        }
        int productNumber = 0;
        int productCount = 0;
        int totalPrice = 0;
        do {
            System.out.println("Название салата" + setNameRecipe);
            System.out.println("Выберите продукт и введите количество или введите `end`");
            input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            try {
                String[] item = input.split(" ");
                productNumber = Integer.parseInt(item[0]) - 1;
                productCount = Math.abs(Integer.parseInt(item[1]));
                if (productNumber >= Recipes.PRODUCTS.length || productNumber < 0) {
                    throw new ArrayIndexOutOfBoundsException("Продукт с таким кодом не существует");
                }
                busket[busketSize] = new Recipes(productNumber, productCount);
                busketSize++;
                System.out.println("Продукт добавлен в ваш салат");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Продукт с таким кодом не существует");
            } catch (RuntimeException ex) {
                System.out.println("Вводите в одну строку номер из списка продуктов и требуемое количество");
                continue;
            }
        } while (true && busketSize < MAX_CAPACITY);

        System.out.println((busketSize > 0) ? "В салате лежат следующие продукты" : "В салате нет продуктов");
        for (int itemCount = 0; itemCount < busketSize; itemCount++) {
            System.out.println(busket[itemCount].getInfo());
            totalPrice += busket[itemCount].getSumm();
        }
        System.out.printf("\t\t\t\t\t\t\tИтого: %7d р. \n", totalPrice);

        System.out.println("===============================================================================");
        Set<Product> products = new HashSet<>(10);
        products.add(new Product("Яблоки", 12, new BigDecimal("4.63")));
        products.add(new Product("Груши", 20, new BigDecimal("2.27")));
        products.add(new Product("Киви", 13, new BigDecimal("0.99")));
        products.add(new Product("Огурцы", 12, new BigDecimal("4.63")));
        products.add(new Product("Помидоры", 20, new BigDecimal("2.27")));
        products.add(new Product("Гранат", 13, new BigDecimal("0.99")));
        products.add(new Product("Банан", 12, new BigDecimal("4.63")));
        products.add(new Product("Мандарин", 20, new BigDecimal("2.27")));
        //  products.add(new Product("Капуста", 13, new BigDecimal("0.99")));
        products.add(new Product("Апельсин", 12, new BigDecimal("4.63")));
        products.add(new Product("Апельсин", 12, new BigDecimal("4.63")));

        // Product element = ("Апельсин", 12, new BigDecimal("4.63"));
        // products.add(element);
        // products.remove(element);

        // System.out.println(products);
        System.out.println(Arrays.toString(products.toArray()));


        boolean sucses = Product.checkDate("Апельсин", 12, new BigDecimal("4.63"));
        if (sucses) {
            System.out.println("Данные верны");
        } else {
            System.out.println("Данные не верны");
        }

        boolean containsElement =
                products.contains("Апельсин");
        System.out.println(containsElement);
        System.out.println("---------------------------------------------------------------------");
        var random_end = 1000;
        int allСycles = 20;
        int countCycles;
        for (countCycles = 0; countCycles <= allСycles; countCycles++) {
            if (countCycles % 2 != 0) {

                int test = (int) Math.floor(Math.random() * (random_end + 1) + 1);
                System.out.println(test);
            }


        }

    }


}




