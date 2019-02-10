package csc207.dongyila.layout;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.io.PrintWriter;

/**
 * A few simple experiments with our utilities. Version 1.1 of February 2019.
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);


    int numInt = 2;
    float numFloat = 14;
    BigInteger numBigInt = new BigInteger("10");
    BigDecimal numBigDec = new BigDecimal("20");

    System.out.println("root of int 2: "+MathUtils.squareRoot(numInt));
    System.out.println("root of float 14: " + MathUtils.squareRoot(numFloat));
    System.out.println("root of big integer 10: "+MathUtils.squareRoot(numBigInt));
    System.out.println("root of big decimal 20: "+MathUtils.squareRoot(numBigDec));
    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
