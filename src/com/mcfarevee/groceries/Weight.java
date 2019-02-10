package com.mcfarevee.groceries;

import csc207.dongyila.layout.TextBlock;

public class Weight {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  Unit unit;

  int amount;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Weight(Unit _unit, int _amount) {
    this.unit = _unit;
    this.amount = _amount;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public boolean equals(Object other) {
    if (other instanceof Weight) {
      Weight weight = (Weight) other;
      if (weight.unit.equals(this.unit) && (weight.amount == this.amount))
        return true;
    }
    return false;
  }
}
