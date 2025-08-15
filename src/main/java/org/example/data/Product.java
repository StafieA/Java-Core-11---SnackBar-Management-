package org.example.data;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import static org.example.data.Rating.*;

public class Product {

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public Product(){
        this(0,"no name",BigDecimal.ZERO);
    };

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this(id, name, price);
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = NOT_RATED;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public BigDecimal getPrice() {
        return price;
    }



    public BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public Rating getRating(){
        return rating;
    }

    public Product applyRating(Rating newRating){
        return new Product(this.id,this.name,this.price,newRating);
    }
}
