package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.LinkedList;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;

public class Cart {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  LinkedList<Item> items;

  int numOfThings;

  int numOfEntries;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Cart() {
    numOfThings = 0;
    numOfEntries = 0;
    items = new LinkedList<>();
  }


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public void addItem(Item item) {
    items.add(item);
  }

  public int numThings() {
    for (Item item : items) {
      if (item instanceof ManyPackages) {
        this.numOfThings += ((ManyPackages) item).count;
      } else {
        this.numOfThings++;
      }
    }
    return numOfThings;
  }

  public int numEntries() {
    return items.size();
  }

  public void printContent(PrintWriter pen) {
    pen.println("Current items in the cart:");
    for (Item item : items) {
      pen.println(item.toString());
    }
  }

  public int getPrice() {
    int totalPrice = 0;
    for (Item item : items) {
      totalPrice += item.getPrice();
    }
    return totalPrice;
  }

  public Weight[] getWeight() {
    Weight weights[] = {new Weight(Unit.GRAM, 0), new Weight(Unit.KILOGRAM, 0),
        new Weight(Unit.OUNCE, 0), new Weight(Unit.POUND, 0)};
    for (Item item : items) {
      if (item.getWeight().unit.equals(weights[0].unit)) {
        weights[0].amount += item.getWeight().amount;
      } else if (item.getWeight().unit.equals(weights[1].unit)) {
        weights[1].amount += item.getWeight().amount;
      } else if (item.getWeight().unit.equals(weights[2].unit)) {
        weights[2].amount += item.getWeight().amount;
      } else
        weights[3].amount += item.getWeight().amount;
    }
    return weights;
  }

  /**
   * Remove Item(s) with name identical to given name
   * 
   * @param name String of name of Item to be removed
   * @return entriesRemoved Integer value of Item(s) removed
   */
  public int remove(String name) {
    int index = 0;
    int entriesRemoved = 0;
    for (int i = 0; i < items.size(); i++) {
      if (name.equals(items.get(index).getName())) {
        entriesRemoved += 1;
        items.remove(index);
      } else
        index++; //increment index if no Item is removed
    }
    return entriesRemoved;
  }

  /**
   * Merge all merge-able Item(s)
   * 
   * @return count Integer value of pairs of Items merged
   */
  public int merge() {
	  /* Remember to change number of Things */
    int index = 0;
    int count = 0;
    while (index < items.size()) {
      int indexToCompare = index + 1;
      while (indexToCompare < items.size()) {
        if (items.get(index).canMerge(items.get(indexToCompare))) {
          items.addLast(items.get(index).merge(items.get(indexToCompare)));
          count++;
          items.remove(indexToCompare);
          items.remove(index);
        } else
          indexToCompare++; //increment indexToCompare if no merge happened
      }
      index++;
    }
    return count;
  }
}
