package com.ckcc.javacourse;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

    private ArrayList<Purchase> purchasedItems;
    private double discount;
    Scanner scanner = new Scanner(System.in);
    public Cart(double discount) {
        purchasedItems = new ArrayList<>();
        this.discount = discount;
    }

    public Cart() {
        this(0);
    }

    public void addItem(Purchase newPurchase) {
        if(findPurchase(newPurchase.getProduct().getId()) < 0){
            purchasedItems.add(newPurchase);
        }else {
            System.out.println("You already bought " + newPurchase.getProduct().getName() + " , would you like to buy more?(Y/N)");
            if(scanner.next().equalsIgnoreCase("Y")){
                purchasedItems.add(newPurchase);
                System.out.println("you buy " + newPurchase.getProduct().getName() + " " + newPurchase.getQty() + " more.");
            }else {
                System.out.println("You cancelled!");
            }
        }
    }

    private int findPurchase(String id) {
        for(int i = 0; i < purchasedItems.size(); i++)
            if(purchasedItems.get(i).getProduct().getId().equals(id))
                return i;
        return -1;
    }


    public void removeItem(Purchase purchase) {
        int foundPosition = findPurchase(purchase);
        if(foundPosition < 0 ){
            System.out.println("Purchase is not found!");
            return;
        }
        purchasedItems.remove(foundPosition);
    }

    private int findPurchase(Purchase purchase) {
        return purchasedItems.indexOf(purchase);

    }

    public ArrayList<Purchase> getPurchasedItems(){
        return purchasedItems;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double calculateSubTotal() {

        double subTotal = 0;
        for(Purchase purchase : purchasedItems){
            subTotal += purchase.getPrice();
        }
        return subTotal;
    }

    public double calculateTotal() {
        return (this.discount * this.calculateSubTotal());
    }

    @Override
    public String toString() {
        String purchaseList = "";
        for (Purchase purchase : getPurchasedItems()) {
            purchaseList += purchase.toString() + "\n";
        }
        return purchaseList;
    }

    //
    public void resetItems() {
        purchasedItems = new ArrayList<>();
    }
}
