package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.LinkedList;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Unit;

public class Cart {
  
  
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  LinkedList<Item> items = new LinkedList<>();
  int numOfThings;
  int numOfEntries;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Cart() {
    numOfThings = 0;
    numOfEntries = 0;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  
  
  public void addItem(Item item) {
    items.add(item);
    if (item instanceof ManyPackages) {
      numOfThings += ((ManyPackages) item).count;
    } else {
      numOfThings++;
    }
    numOfEntries++;
  }
  
  public int numThings() {
    return numOfThings;
  }
  
  public int numEntries() {
    return numOfEntries;
  }
  
  public void printContent(PrintWriter pen) {
    
  }
  
  public int getPrice() {
    return 0;
  }
  
  public Weight[] getWeight() {
    
  }
  
  public boolean remove(String name) {
    
  }
  
  public int merge() {
    
    
  }
}
