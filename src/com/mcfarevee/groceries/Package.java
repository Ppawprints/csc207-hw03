package com.mcfarevee.groceries;

public class Package implements Item {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  String name;
  
  Weight weight;
  
  int price;
  

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Package(String aName, Weight aWeight, int aPrice) {
    name = aName;
    weight = aWeight;
    price = aPrice;
  }
  

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String toString() {
    return weight.amount + " " + weight.unit.abbrev() + " package of " + name;
  }

  public Weight getWeight() {
    return weight;
  }

  public int getPrice() {
    return price;
  }
  
  public String getName() {
    return this.name;
  }

  public boolean equals(Object other) {
    if (other instanceof Package) {
      Package otherPackage = (Package) other;
      if (otherPackage.name.equals(this.name) && (otherPackage.price == this.price)
          && otherPackage.weight.equals(this.weight))
        return true;
    }
    return false;
  }
  
  public boolean canMerge(Item other) {
    if (other instanceof Package) {
      return this.equals(other);
    } else if (other instanceof ManyPackages) {
      return this.equals(((ManyPackages) other).type);
    } else
      return false;
  }

  public Item merge(Item other) {
    if (this.canMerge(other)) {
      if (other instanceof Package) {
        return new ManyPackages(this, 2);
      } else {
        return new ManyPackages(this, (((ManyPackages) other).count + 1));
      }
    }
    return null;
  }
}
