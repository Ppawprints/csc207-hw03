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
        PrintWriter pen = new PrintWriter(System.out, true);

        BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
        BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 200);

        BulkItem bulkItemBananas = new BulkItem(bananas, Unit.POUND, 3);
        BulkItem bulkItemSaffron = new BulkItem(saffron, Unit.GRAM, 1);
        Package packageAmazon = new Package("amazon", 
                                            new Weight(Unit.GRAM, 100),
                                            100);
        ManyPackages manyPackageAmazon = new ManyPackages(new Package("amazon",
                                                 new Weight(Unit.GRAM, 100),
                                                 100), 5);
        NonFood nonFoodStone = new NonFood("stone", new Weight(Unit.POUND, 200),
                                           99);
        
        /* Add them into Cart */
        cart.addItem(bulkItemBananas);
        cart.addItem(bulkItemSaffron);
        cart.addItem(packageAmazon);
        cart.addItem(manyPackageAmazon);
        cart.addItem(nonFoodStone);

        /* Test function of each class */

        /* BulkItem */
        pen.println("BulkItem Test");
        pen.println("toString(): " + bulkItemBananas.toString());
        pen.println("getWeight(): " + bulkItemBananas.getWeight().unit.plural());
        pen.println("getPrice(): " + bulkItemBananas.getPrice());
        pen.println("getName(): " + bulkItemBananas.getName());
        pen.println("equals(): " + bulkItemBananas.equals(saffron)); // should be false
        pen.println();

        /* ManyPackages */
        pen.println("ManyPackages Test");
        pen.println("toString(): " + manyPackageAmazon.toString());
        pen.println("getWeight(): " + manyPackageAmazon.getWeight().unit.plural());
        pen.println("getPrice(): " + manyPackageAmazon.getPrice());
        pen.println("getName(): " + manyPackageAmazon.getName());
        pen.println("equals(): " + manyPackageAmazon.equals(manyPackageAmazon)); 
                                // should be true
        pen.println();

        /* NonFood */
        pen.println("NonFood Test");
        pen.println("toString(): " + nonFoodStone.toString());
        pen.println("getWeight(): " + nonFoodStone.getWeight().unit.plural());
        pen.println("getPrice(): " + nonFoodStone.getPrice());
        pen.println("getName(): " + nonFoodStone.getName());
        pen.println("equals(): " + nonFoodStone.equals(new NonFood("stone", new Weight(Unit.POUND, 200), 99)));
                                    // should be true
        pen.println();

        /* Package */
        pen.println("Package Test");
        pen.println("toString(): " + packageAmazon.toString());
        pen.println("getWeight(): " + packageAmazon.getWeight().unit.plural());
        pen.println("getPrice(): " + packageAmazon.getPrice());
        pen.println("getName(): " + packageAmazon.getName());
        pen.println("equals(): " + packageAmazon.equals(packageAmazon));
                                    // should be true
        pen.println();

        /* Cart Test */
        pen.println("numThings(): " + cart.numThings());
        pen.println("numEntries(): " + cart.numEntries());
        pen.println("Content in the cart");
        cart.printContent(pen);
        pen.println("getPrice(): " + cart.getPrice());
    }
}
