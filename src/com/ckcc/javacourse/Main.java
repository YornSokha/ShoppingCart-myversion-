package com.ckcc.javacourse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

<<<<<<< .mine
    private static int orderNo = 2;
=======
    private static int orderNo = 3;
>>>>>>> .theirs
    private static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {

        Customer customer;
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        printContent();
        while (!quit) {
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:

                    do{
                        System.out.println("----------------- Create New Product --------------------\n");
                        scanner.nextLine();
                        System.out.print("Enter your product code:\n");
                        String code = scanner.nextLine();
                        System.out.print("Enter your product name:\n");
                        String name = scanner.nextLine();
                        System.out.print("Enter your product description:\n");
                        String description = scanner.nextLine();
                        System.out.print("Enter your product price:\n");
                        double price = scanner.nextDouble();
                        System.out.print("Enter your product quantity:\n");
                        double qty = scanner.nextDouble();
                        if(addNewProduct(new Product(code, name, description, price, qty)))
                            System.out.println("Product name : " + name + " with code " + code + " is added into stock.");
                        else
                            System.out.println("Product code : " + code + " is already existed!");
                        System.out.println("---------------------------------------------------\n" +
                                "Do you want to add more product? (Y/N)");
                        scanner.nextLine();
                    }while(scanner.next().equalsIgnoreCase("Y"));
                    break;
                case 2:
                    System.out.println("[ID\t\tName\t\tPrice\t\tQty\t\tDescription]\n" +
                            "---------------------------------------------------");
                    for(Product product : products)
                        System.out.println(product.toString());
                    break;
                case 3:
                    System.out.println("----------------- Let's go shopping products you want --------------------");
                    do{
                        scanner.nextLine();
                        System.out.println("Enter product's code you want to buy:");
                        String code = scanner.nextLine();
                        boolean existed = false;
                        if(findProduct(code) != null){
                            existed = true;
                        }
                        if(existed){
                            System.out.println("Enter product's QTY you want to buy:");
                            double qty = scanner.nextDouble();
                            Product p = findProduct(code);
                            if(qty > p.getQtyInStock()) {
                                System.out.println("Not enough stock!! product with code " + code + " has only " + p.getQtyInStock() + " in stock.");
                            }else{
                                p.setQtyInStock(p.getQtyInStock() - qty);
                                System.out.println("Enter percentage discount for this product if you have?");
                                double discount = scanner.nextDouble();
                                Product product = new Product(code, p.getName(), p.getDescription(), p.getPrice(), qty);
                                Purchase purchase = new Purchase("" + orderNo++ ,product, qty, discount);
                                cart.addItem(purchase);
                            }
                        }else{
                            System.out.println("Product with code " + code +" is not found in list to purchase.");
                        }
                        System.out.println("---------------------------------------------------\n" +
                                "Do you want to shop more product? (Y/N)");
                    }while (scanner.next().equalsIgnoreCase("Y"));
                    break;
                case 4:
                    System.out.println("----------------- My Shopping Cart --------------------\n" +
                            "\n" +
                            "[No     Name            Qty     UnitPrice   Discount    Price]\n" +
                            "---------------------------------------------------------");
                    System.out.println(cart.toString());
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("--------- Before Check out, Give me your information ---------\n");

                    System.out.println("Enter your identification number:");
                    String identification = scanner.nextLine();

                    System.out.println("Enter your name:");
                    String cusName = scanner.nextLine();

                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();

                    System.out.println("Enter your shipping address:");
                    String shipping = scanner.nextLine();

                    System.out.println("Enter your billing address:");
                    String billing = scanner.nextLine();

                    System.out.println("--------- Do you have discount card ---------\n");
                    System.out.println("Enter percentage on your discount card:");
                    double discount = scanner.nextDouble();
                    cart.setDiscount(discount);
                    customer = new Customer(identification, cusName, email, shipping, billing);
                    customer.placeOrder(cart);
                    System.out.println("--------------- Your Purchase Invoice-------------\n");
                    System.out.println(customer.checkOut());
                    System.out.println("Do you agree to pay?(y/n)");
                    String agree = scanner.next();
                    if(!agree.equalsIgnoreCase("Y")){
                        customer.cancelOrder();
                        ArrayList<Purchase> cancelledPurchase = cart.getPurchasedItems();
                        for(int j = 0; j < products.size(); j++)
                            for(int k = 0; k < cancelledPurchase.size(); k++){

                                Product product = products.get(j);
                                if((product.getId()).equals(cancelledPurchase.get(k).getProduct().getId())){
                                    products.set(j, new Product(
                                            product.getId(), product.getName(),
                                            product.getDescription(),
                                            product.getPrice(),
                                            product.getQtyInStock() + cancelledPurchase.get(k).getQty()));
                                }

                            }

                        System.out.println("You products have been cancelled!");
                    }else
                        System.out.println("Your products have been successfully purchased!");

                    cart.resetItems();
                    break;
            }
            System.out.print("Do you want to continue to Main Menu? (Y/N)\n");
            if(scanner.next().equalsIgnoreCase("Y"))
                printContent();
            else
                quit = true;
        }
    }

    private static boolean addNewProduct(Product product){

        if(findProduct(product.getId()) == null){
            products.add(product);
            return true;
        }
        return false;
    }

    private static Product findProduct(String id) {
        for(Product product : products)
            if(product.getId().equalsIgnoreCase(id))
                return product;
        return null;
    }

    private static void printContent() {

        System.out.println("---- Program Menus ----\n" +
                "| 1. New Product      |\n" +
                "| 2. List of Products |\n" +
                "| 3. Go to Shopping   |\n" +
                "| 4. My Shopping Cart |\n" +
                "| 5. Check Out        |\n" +
                "-----------------------");

    }


}
