package org.example.app;

import org.example.data.Drink;
import org.example.data.Food;
import org.example.data.Product;
import org.example.data.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class Shop
{
    public static void main( String[] args )
    {
        Product p1 = new Drink(101,"tea",BigDecimal.valueOf(1.99),Rating.THREE_STAR);
        Product p2 = new Drink(102,"coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = new Food(103,"cake",BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = p1.applyRating(Rating.THREE_STAR);
        Product p5 = new Drink(104,"chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p6 = new Food(104,"chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));

        System.out.println(p5.equals(p6));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }
}
