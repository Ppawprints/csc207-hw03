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
    PrintWriter pen = new PrintWriter(System.out, true);
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 20);

    Cart cart = new Cart();
    cart.addItem(new BulkItem(bananas, Unit.POUND, 3));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new ManyPackages(new Package("macncheez", new Weight(Unit.OUNCE, 6), 77), 5));
    cart.addItem(new BulkItem(bananas, Unit.POUND, 13));
    cart.addItem(new NonFood("stone", new Weight(Unit.OUNCE, 11), 19));
    cart.addItem(new BulkItem(saffron, Unit.GRAM, 3));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new ManyPackages(new Package("oreos", new Weight(Unit.OUNCE, 12), 399), 4));

    Weight[] weight = cart.getWeight();
    for (int i = 0; i < weight.length; i++) {
      pen.println(weight[i].unit.toString() + " " + weight[i].amount);
    }

    
  }
}
