package org.example.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductManager {

    private Product product;
    private Review review;

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore ){
       this.product =  new Food(id, name, price, rating, bestBefore);
       return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating ){
       product =  new Drink(id, name, price, rating);
       return product;
    }

    public Product reviewProduct(Product p, Rating rat, String comment){
         review =  new Review(rat,comment);
         this.product = p.applyRating(rat);
         return this.product;
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "product=" + product +
                ", review=" + review +
                '}';
    }
}
