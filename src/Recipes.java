
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Recipes {
    public String nameRecipe;
    private int productCount;
    private int productNumber;
    private int count;
    private int position;

    public Recipes(int productNumber, int productCount) {
        this.productNumber = position;
        this.productCount = count;

    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public int getCount() {
        return count;
    }

    public int getPosition() {
        return position;
    }

    public static final String[] PRODUCTS = new String[]{"Груши", "Яблоки", "Киви", "Гранат", "Огурцы", "Апельсин", "Банан"};
    public static final int[] PRICES = new int[]{10, 20, 30, 20, 15, 14, 11};


    public void Recipes(int position, int count) {
        this.position = position;

        if (count >= 0) {
            this.count = count;
        }


    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(PRODUCTS[this.position] + " по цене " + PRICES[this.position] + " за шт. = " + PRICES[this.position] * this.count + " р.");
        return sb.toString();
    }

    public int getSumm() {
        return PRICES[this.position] * this.count;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getProductNumber() {
        return productNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return productCount == recipes.productCount && productNumber == recipes.productNumber && count == recipes.count && position == recipes.position && nameRecipe.equals(recipes.nameRecipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRecipe, productCount, productNumber, count, position);
    }
}
