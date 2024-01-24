package com.hr.hrspring.patterDesign.Structural.flyweight.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    private final List<Book> books = new ArrayList<>();

    public void storeBook(String name, double price, String type,
                                            String distributor, String otherData){
        BookType bookType = BookFactory.getBookType(type, distributor, otherData);
        books.add(new Book(name, price, bookType));

    }

    public static String getRandomName(){
        Random random = new Random();
        return random.ints(97, 122)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Double getRandomPrice(){
        //leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
        return 10D + new Random().nextDouble() * (200D - 10D);
    }

}
