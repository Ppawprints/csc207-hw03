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
  
  public String getName() {
    return type.getName();
  }

  public boolean equals(Object other) {
    return other == this;
  }

  public boolean canMerge(Item other) {
    if (other instanceof ManyPackages) {
      return (this.type.equals(((ManyPackages) other).type));
    }
    return false;
  }

  public Item merge(Item other) {
    if (this.canMerge(other)) {
      return new ManyPackages(this.type, this.count + ((ManyPackages) other).count);
    }
    return null;
  }
}
