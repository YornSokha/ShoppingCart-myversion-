package com.ckcc.javacourse;

public class Purchase {

    private String orderNo;
    private Product product;
    private double qty;
    private double discount;

    public double getPrice() {
        double subTotal = qty * product.getPrice();
        return (subTotal - (discount * subTotal));
    }

    @Override
    public String toString() {
        return  "[" + this.orderNo + "\t\t" +
                product.getName() + "\t\t" +
                qty + '\t' +
                '$' + product.getPrice() + "\t\t" +
                (discount*100) + '%' + "\t\t" +
                '$' + this.getPrice() + "]\n";
    }

    //

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public Purchase(String orderNo, Product product, double qty, double discount) {
        this.orderNo = orderNo;
        this.product = new Product();
        this.product = product;
        this.qty = qty;
        this.discount = discount;
    }
}
