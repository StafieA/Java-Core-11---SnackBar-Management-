package org.example.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static org.example.data.Rating.*;

public abstract class Product implements Rateable<Product>{

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

     Product(){
        this(0,"no name",BigDecimal.ZERO);
    };

     Product(int id, String name, BigDecimal price, Rating rating) {
        this(id, name, price);
        this.rating = rating;
    }

     Product(int id, String name, BigDecimal price) {
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

    @Override
    public Rating getRating(){
        return rating;
    }



    public LocalDate getBestBefore(){
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return
                 id +
                ", name='" + name + '\'' +
                ", price=" + price +", discount=" +
                getDiscount() +
                ", rating=" + rating.getStars()+" "+ getBestBefore()
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
