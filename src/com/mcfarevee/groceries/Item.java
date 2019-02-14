package com.mcfarevee.groceries;

public interface Item {


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Return description of Item
   * 
   * @return String description
   */
  public String toString();

  /**
   * return Weight of Item
   * 
   * @return weight
   */
  public Weight getWeight();

  /**
   * Determine if the other Item can merge with this
   * 
   * @param other Item other for comparison
   * @return true if merge-able, otherwise false
   */
  public boolean canMerge(Item other);

  /**
   * Attempt to merge two items
   * 
   * @param other Item to merge
   * @return result of the merge; null if not merge-able;
   */
  public Item merge(Item other);

  /**
   * Return price of Item
   * 
   * @return price
   */
  public int getPrice();

  /**
   * Return name of Item
   * 
   * @return name
   */
  public String getName();

} // interface Item
