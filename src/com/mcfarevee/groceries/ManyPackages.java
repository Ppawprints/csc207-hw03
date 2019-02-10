package com.mcfarevee.groceries;

public class ManyPackages implements Item {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  Package type;
  public int count;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public ManyPackages(Package aType, int aCount) {
    this.type = aType;
    this.count = aCount;
  }

  public String toString() {
    return Integer.toString(count) + " x " + this.type.toString();
  }


  public Weight getWeight() {
    return new Weight(this.type.weight.unit, this.count * this.type.weight.amount);
  }


  public int getPrice() {
    return this.count * this.type.price;
  }

  public boolean equals(Object other) {
    return other == this;
  }

}
