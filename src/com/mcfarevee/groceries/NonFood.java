package com.mcfarevee.groceries;

public class NonFood implements Item {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  String name;
  
  Weight weight;
  
  int price;
  

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public NonFood(String aName, Weight aWeight, int aPrice) {
    name = aName;
    weight = aWeight;
    price = aPrice;
  }
  

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String toString() {
    return this.name;
  }

  public Weight getWeight() {
    return this.weight;
  }

  public int getPrice() {
    return this.price;
  }
  
  public String getName() {
    return this.name;
  }

  public boolean equals(Object other) {
    if (other instanceof NonFood) {
      NonFood otherNonFood = (NonFood) other;
      if (otherNonFood.name.equals(this.name) && otherNonFood.weight.equals(this.weight)
          && (otherNonFood.price == this.price))
        return true;
    }
    return false;
  }

  public boolean canMerge(Item other) {
    return false;
  }

  public Item merge(Item other) {
    return null;
  }

}
