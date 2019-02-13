package com.mcfarevee.groceries;

public class BulkFood {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  public String name;

  Unit unit;

  int pricePerUnit;

  int supply;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+


  public BulkFood(String _name, Unit _unit, int _pricePerUnit, int _supply) {
    this.name = _name;
    this.unit = _unit;
    this.pricePerUnit = _pricePerUnit;
    this.supply = _supply;  

  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public boolean equals(Object other) {
    if (other instanceof BulkFood) {
      BulkFood otherFood = (BulkFood) other;
      if (otherFood.name.equals(this.name) && (otherFood.pricePerUnit == this.pricePerUnit)
          && otherFood.unit.equals(this.unit) && (otherFood.supply == this.supply))
        return true;
    }
    return false;
  }

}
