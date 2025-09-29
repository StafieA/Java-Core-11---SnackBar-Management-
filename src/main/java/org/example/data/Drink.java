package org.example.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Drink extends Product{

    public Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }
}
