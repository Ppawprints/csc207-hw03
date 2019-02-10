


package csc207.dongyila.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new BoxedBlock(new RightJustified(new VComposition(tb1, tb2), 15)));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);

    
    pen.close();
  } // main(String[])

} // class TBExpt
