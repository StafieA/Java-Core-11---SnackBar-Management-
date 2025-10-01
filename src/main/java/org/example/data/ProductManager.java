package org.example.data;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Product product;
    private Review review;

    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resources = ResourceBundle.getBundle("resources",locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);

    }

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
                ", locale=" + locale +
                ", resources=" + resources +
                ", dateFormat=" + dateFormat +
                ", moneyFormat=" + moneyFormat +
                '}';
    }
}
