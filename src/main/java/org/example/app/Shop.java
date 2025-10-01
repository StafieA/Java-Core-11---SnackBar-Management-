package org.example.app;

import org.example.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Shop
{
    public static void main( String[] args )
    {
        ProductManager pm = new ProductManager(Locale.US);

        Product p1 = pm.createProduct(101,"tea",BigDecimal.valueOf(1.99),Rating.THREE_STAR);
        Product p2 = pm.createProduct(102,"coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = pm.createProduct(103,"cake",BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = p1.applyRating(Rating.THREE_STAR);
        Product p5 = pm.createProduct(104,"chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p6 = pm.createProduct(104,"chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p7 = p3.applyRating(Rating.FOUR_STAR);
        Product p8 = p1.applyRating(Rating.TWO_STAR);


        System.out.println(p5.equals(p6));
        System.out.println(p1);
        System.out.println(p3);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println("=====================");
        System.out.println(p6);
        System.out.println(pm.reviewProduct(p6,Rating.FOUR_STAR,"E bun"));
        System.out.println(pm);
    }
}
