package com.mcfarevee.groceries;

import csc207.dongyila.layout.TextBlock;

public class BulkItem implements Item {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  BulkFood food;
  Unit unit;
  int amount;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BulkItem(BulkFood aFood, Unit aUnit, int aAmount) {
    this.food = aFood;
    this.unit = aUnit;
    this.amount = aAmount;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String toSrting() {
    return Integer.toString(amount) + " " + unit.toString() + " of " + food.name;
  }

  public Weight getWeight() {
    return new Weight(unit, amount);
  }

  public int getPrice() {
    return food.pricePerUnit * amount;
  }

  public boolean equals(Object other) {
    if (other instanceof BulkItem) {
      BulkItem otherItem = (BulkItem) other;
      if (otherItem.food.equals(this.food) && otherItem.unit.equals(this.unit)
          && (otherItem.amount == this.amount))
        return true;
    }
    return false;
  }
}
