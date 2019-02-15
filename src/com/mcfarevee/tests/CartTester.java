package com.mcfarevee.tests;

import java.io.PrintWriter;
import java.util.LinkedList;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.NonFood;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.shopping.Cart;

public class CartTester {
    public static void main(String[] args) {
        /* Instanize object for testing */
        /* from https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/2019S/01/
                assignments/assignment03.html */
        Cart cart = new Cart();
        PenWriter pen = new PenWriter(System.out, true);

        BulkFood bananas = new BulkFood("bananas", Unit.POUNDS, 50, 20);
        BulkFood saffron = new BulkFood("saffron", Unit.GRAMS, 1000, 200);

        BulkItem bulkItemBananas = new BulkItem(bananas, Unit.POUNDS, 3);
        BulkItem bulkItemSaffron = new BulkItem(saffron, Unit.GRAMS, 1);
        Package packageAmazon = new Package("amazon", 
                                            new Weight(Unit.GRAMS, 100), 
                                            100);
        ManyPackage manyPackageAmazon = new ManyPackage(new Package("amazon", 
                                                 new Weight(Unit.GRAMS, 100), 
                                                 100), 5);
        NonFood nonFoodStone = new NonFood("stone", new Weight(Unit.POUNDS, 200), 
                                           99));
        
        /* Add them into Cart */
        cart.addItem(bulkItemBananas);
        cart.addItem(bulkItemSaffron);
        cart.addItem(packageAmazon);
        cart.addItem(manyPackageAmazon);
        cart.addItem(nonFoodStone);

        /* Test function of each class */

        /* BulkItem */
        pen.println("BulkItem Test");
        pen.println("toString(): " + bananas.toString());
        pen.println("getWeight(): " + bananas.getWeight().unit.name);
        pen.println("getPrice(): " + bananas.getPrice());
        pen.println("getName(): " + bananas.getName());
        pen.println("equals(): " + bananas.equals(saffron)); // should be false
        pen.println();

        /* ManyPackages */
        pen.println("ManyPackages Test");
        pen.println("toString(): " + manyPackageAmazon.toString());
        pen.println("getWeight(): " + manyPackageAmazon.getWeight().unit.name);
        pen.println("getPrice(): " + manyPackageAmazon.getPrice());
        pen.println("getName(): " + manyPackageAmazon.getName());
        pen.println("equals(): " + manyPackageAmazon.equals(manyPackageAmazon)); 
                                // should be true
        pen.println();

        /* NonFood */
        pen.println("NonFood Test");
        pen.println("toString(): " + nonFoodStone.toString());
        pen.println("getWeight(): " + nonFoodStone.getWeight().unit.name);
        pen.println("getPrice(): " + nonFoodStone.getPrice());
        pen.println("getName(): " + nonFoodStone.getName());
        pen.println("equals(): " + nonFoodStone.equals(new NonFood("stone", new Weight(Unit.POUNDS, 200), 99));)); 
                                    // should be true
        pen.println();

        /* Package */
        pen.println("Package Test");
        pen.println("toString(): " + packageAmazon.toString());
        pen.println("getWeight(): " + packageAmazon.getWeight().unit.name);
        pen.println("getPrice(): " + packageAmazon.getPrice());
        pen.println("getName(): " + packageAmazon.getName());
        pen.println("equals(): " + packageAmazon.equals(packageAmazon));
                                    // should be true
        pen.println();

        /* Cart Test */
        pen.println("numThings(): " + cart.numThings());
        pen.println("numEntries(): " + cart.numEntries());
        pen.println("Content in the cart");
        cart.printContents(pen);
        pen.println("getPrice(): " + cart.getPrice());
    }
}
