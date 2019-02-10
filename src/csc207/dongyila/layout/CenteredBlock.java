package csc207.dongyila.layout;

public class CenteredBlock implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock contents;
  int width;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public CenteredBlock(TextBlock _contents, int _width) throws Exception {
    this.contents = _contents;
    if (_width < this.contents.width()) {
      throw new Exception("Invalid width: " + _width);
    }
    this.width = _width;
  }


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String row(int i) throws Exception {
    if (i < 0 || i > contents.height()) {
      throw new Exception("Invalid row number: " + i);
    }
    
    int len = this.contents.width();
    String result = this.contents.row(i);
    
    if (len <= this.width) {
      String spaces = TBUtils.spaces((this.width - len) / 2);
      result = spaces.concat(result.concat(spaces));
    } else {
      throw new Exception("Updated contents does not fit into box at row " + i);
    }
    
    if (result.length() > this.width) {
      result = result.substring(0, this.width);
    }
    
    return result;
  }


  public int height() {
    return this.contents.height();
  }


  public int width() {
    return this.width;
  }

}
