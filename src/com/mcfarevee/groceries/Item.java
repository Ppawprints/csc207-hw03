package com.mcfarevee.groceries;

public interface Item {

  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+


  public String toString();

  public Weight getWeight();
  
  public boolean canMerge(Item other);
  
  public Item merge(Item other);
  
  public int getPrice();
  
  public String getName();
   

} // interface Item
