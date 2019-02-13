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

  public int remove(String name) {
    int index = 0;
    int entriesRemoved = 0;
    int thingsRemoved = 0;
    for (int i = 0; i < this.numOfEntries; i++) {
      if (name.equals(items.get(index).getName())) {
        entriesRemoved += 1;
        if (items.get(index) instanceof ManyPackages) {
          thingsRemoved += ((ManyPackages) items.get(index)).count;
        } else {
          thingsRemoved += 1;
        }
        items.remove(index);
      } else
        index++;
    }
    this.numOfEntries -= entriesRemoved;
    this.numOfThings -= thingsRemoved;
    
    return entriesRemoved;
  }

  public int merge() {
    int index = 0;
    int count = 0;
    while (index < this.numOfEntries) {
      int indexToCompare = index + 1;
      while (indexToCompare < this.numOfEntries) {
        if (items.get(index).canMerge(items.get(indexToCompare))) {
          items.addLast(items.get(index).merge(items.get(indexToCompare)));
          this.numOfEntries--;
          count++;
          items.remove(indexToCompare);
          items.remove(index);
        } else
          indexToCompare++;
      }
      index++;
    }

    return count;

  }
}
