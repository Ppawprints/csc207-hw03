package com.mcfarevee.groceries;

public class GroceryTester {
  public static void main(String[] args) {
    BulkFood food = new BulkFood("Apples", Unit.KILOGRAM, 10, 10);
    BulkItem item = new BulkItem(food, Unit.KILOGRAM, 100);
    Weight weight = new Weight(Unit.GRAM, 100);
    Package pack = new Package("Package", weight, 17);
    ManyPackages packs = new ManyPackages(pack, 12);
    System.out.println(packs.toString());
    System.out.println(food.getClass());
  }
}
