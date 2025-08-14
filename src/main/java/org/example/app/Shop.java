package org.example.app;

import org.example.data.Product;

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

        System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice()+" "+p1.getDiscount());
    }
}
