package org.example.app;

import org.example.data.Product;
import org.example.data.Rating;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class Shop
{
    public static void main( String[] args )
    {
        Product p1 = new Product(101,"tea",BigDecimal.valueOf(1.99));
        Product p2 = new Product(102,"coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = new Product(103,"cake",BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
        Product p4 = p1.applyRating(Rating.THREE_STAR);

        System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice()+" "+p1.getDiscount()+" "+p1.getRating().getStars());
        System.out.println(p4.getRating().getStars());
        System.out.println("p1 = " + p1);

    }
}
