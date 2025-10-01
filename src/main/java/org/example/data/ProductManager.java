package org.example.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ProductManager {

    private Product product;
    private Review[] reviews = new Review[5];
    Map<Product, List<Review>> products = new HashMap<>();

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
       Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product, new ArrayList<>()) ;
       return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating ){
      Product product =  new Drink(id, name, price, rating);
        products.putIfAbsent(product, new ArrayList<>()) ;
       return product;
    }

    public Product reviewProduct(Product p, Rating rat, String comment){

         if(reviews[reviews.length-1] != null){
             reviews = Arrays.copyOf(reviews, reviews.length + 5);
         }
         int i = 0, sum = 0;
         boolean reviewed = false;
         while (i < reviews.length && !reviewed){
             if(reviews[i] == null){
                 reviews[i] = new Review(rat,comment);
                 reviewed = true;
             }
             sum += reviews[i].getRating().ordinal();
             i++;
         }

//        System.out.println("i inainte sa fie suma calculata "+ i );
         int averageRating = Math.round((float) sum /i);
         this.product = p.applyRating(averageRating);
         return this.product;
    }

    public void printProductReport(){
        StringBuilder txt = new StringBuilder();
        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName().substring(0,1).toUpperCase()+product.getName().substring(1).toLowerCase(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        txt.append('\n');
        if(reviews[0] == null){
            txt.append(resources.getString("no.reviews"));
            txt.append("\n");
        }
        for(int i = 0; i < reviews.length; i++){
            if(reviews[i] != null) {
                txt.append(MessageFormat.format(resources.getString("review"),
                        reviews[i].getRating().getStars(),"#"+
                        reviews[i].getComments()));
                txt.append("\n");
            }
        }

//        txt.append('\n');
        System.out.println(txt);
    }


}
