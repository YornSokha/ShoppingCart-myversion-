package com.ckcc.javacourse;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private double qtyInStock;

    public Product(String id, String name, String description, double price, double qtyInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public String getId() {

        return id;
    }

    // check if product is enough
    public boolean isValidStock(double qty) {

        if(qty - this.qtyInStock > 0){
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return  "[" + id + "\t" +
                '\'' + name + '\'' + "\t" +
                price + "\t\t" +
                qtyInStock + "\t" +
                '\'' + description + '\'' +"]\n";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(double qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
}
