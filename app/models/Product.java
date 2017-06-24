package models;

import java.util.*;
import java.lang.*;

public class Product
{
    public String name;
    public String ean;

    private static ArrayList<Product> products;

    static{
        products = new ArrayList<Product>();
        products.add(new Product("Bottle-X1", "X1-123"));
        products.add(new Product("Bottle-X2", "X2-234"));
        products.add(new Product("Bottle-X3", "X3-738"));
        products.add(new Product("Bottle-X4", "X4-283"));
    }

    public Product(){}

    public Product(String name, String ean)
    {
        this.name = name;
        this.ean = ean;
    }

    public static ArrayList<Product> findAll()
    {
        return new ArrayList<Product>(products);
    }

    public static Product findByEan(String ean)
    {
        for (Product product : products){
            if(product.ean.equals(ean)){
                return product;
            }
        }
        return null;
    }
}