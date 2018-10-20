package com.ckcc.javacourse;

public class Customer {

    private String id;
    private String name;
    private String email;
    private String shippingAddress;
    private String billingAddress;
    private Cart shoppingCart;

    public Customer(String id, String name, String email, String shippingAddress, String billingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    public void placeOrder(Cart shoppingCard) {
        this.shoppingCart = shoppingCard;
    }

    public void cancelOrder() {
        this.shoppingCart = null;
    }

    public String checkOut() {
        String p = "";
        for(Purchase purchase : shoppingCart.getPurchasedItems())
            p += purchase.toString();

        String checkOut =  "[ ID            : " + this.id + " ]\n" +
                "[ Name          : " + this.name + " ]\n" +
                "[ Email : " + this.email + " ]\n" +
                "[ Ship To       : " + this.shippingAddress + " ]\n" +
                "[ Bill To       : " + this.billingAddress + " ]\n" +
                "--------------------------------------------------\n";
        checkOut += "[No     Name            Qty     UnitPrice   Discount    Price]\n" +
                    "--------------------------------------------------\n" +
                    p + "\n" +
                    "Sub Total : $" + shoppingCart.calculateSubTotal() + "\n" +
                    "Discount : " + (shoppingCart.getDiscount() * 100) + "%\n" +
                    "Total : $" + shoppingCart.calculateTotal();
        return checkOut;
    }

    public String toString() {
        return null;
    }
}
