package org.example.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ProductManager {

//    private Product product;

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


        List<Review> reviews = products.get(p);
          products.remove(p);
          reviews.add(new Review(rat,comment));
          int sum = 0;
          for(Review review : reviews){
              sum += review.getRating().ordinal();
          }

         int averageRating = Math.round((float) sum /reviews.size());
         Product product = p.applyRating(Rateable.convert(averageRating));
         products.put(product,reviews);
         return product;
    }

    public void printProductReport(Product product){
        StringBuilder txt = new StringBuilder();
        List<Review> reviews = products.get(product);

        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName().substring(0,1).toUpperCase()+product.getName().substring(1).toLowerCase(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        txt.append('\n');
        if(reviews.isEmpty()){
            txt.append(resources.getString("no.reviews"));
            txt.append("\n");
        }
        for(Review review : reviews){
            if(review != null) {
                txt.append(MessageFormat.format(resources.getString("review"),
                        review.getRating().getStars(),"#"+
                        review.getComments()));
                txt.append("\n");
            }
        }

//        txt.append('\n');
        System.out.println(txt);
    }


}
