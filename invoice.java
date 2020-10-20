package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //catalog
        ArrayList<String> product = new ArrayList<String>();
        ArrayList<Double> price = new ArrayList<Double>();

        //shopping cart
        ArrayList<String> myproduct = new ArrayList<String>();
        ArrayList<Double> myprice = new ArrayList<Double>();
        
        // add items to catalog
        product.add("Bison Sweater");
        price.add(55.99);
        product.add("Bison Tee");
        price.add(14.99);
        product.add("Bison Hoodie");
        price.add(23.99);
        product.add("Bison Bumpersticker");
        price.add(4.99);

        Scanner input = new Scanner(System.in);
        String choice;
        String item;
        String edit;

        //prompt users to add input until they are ready to complete their transaction
        do {
            System.out.println("1.) Add Purchase 2.) Change Purchase 3.) Show Purchases 4.) Complete Transaction");
            choice = input.nextLine();

            if (choice.equals("1"))
            {
                System.out.println("Name of Product?: ");
                item = input.nextLine();
                for (int i = 0; i < product.size(); i++)
                {
                    if (product.get(i).equals(item))
                    {
                        myproduct.add(product.get(i));
                        myprice.add(price.get(i));
                        System.out.println("Success");
                    }
                }
            } else if(choice.equals("2"))
            {
                System.out.println("Which item would you like to change?");
                item = input.nextLine();
                for (int i = 0; i < myproduct.size(); i++)
                {
                    if (myproduct.get(i).equals(item))
                    {
                        System.out.println("Remove(1) or Exchange(2)?");
                        edit = input.nextLine();
                        if (edit.equals("1"))
                        {
                            myproduct.remove(i);
                            myprice.remove(i);
                            System.out.println("Success");
                            item = null;
                        } else if (edit.equals("2"))
                        {
                            System.out.println("What would you like to exchange this product with?");
                            item = input.nextLine();
                            for (int j = 0; j < product.size(); j++)
                            {
                                if (product.get(j).equals(item))
                                {
                                    myproduct.set(i, product.get(j));
                                    myprice.set(i, price.get(j));
                                    System.out.println("Success");
                                    item = null;
                                }
                            }
                        }
                    }
                }
            } else if(choice.equals("3"))
            {
                System.out.println("Invoice: ");
                for (int i = 0; i < myproduct.size(); i++) {
                    System.out.println(myproduct.get(i) + " -- " + myprice.get(i));
                }
            }
        } while ( ! choice.equals("4") );
        double total = 0;
        for (int i = 0; i < myproduct.size(); i++) {
            total += myprice.get(i);
        }
        System.out.println("Thank you for shopping with us! Your total came out to " + total);
    }
}
