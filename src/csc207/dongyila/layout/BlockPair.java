package csc207.dongyila.layout;



public class BlockPair implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  private TextBlock content;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BlockPair(TextBlock block) {
    this.content = block;
  }


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String row(int rownum) throws Exception {
    if (rownum < 0 || rownum > content.height()) {
      throw new Exception("Invalid row number: " + rownum);
    }
    return content.row(rownum).concat(content.row(rownum));
  }

  public int height() {
    return content.height();
  }

  public int width() {
    return content.width() * 2;
  }
}

