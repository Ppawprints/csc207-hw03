package csc207.dongyila.layout;

public class RightJustified implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock contents;
  int width;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public RightJustified(TextBlock _contents, int _width) throws Exception {
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

    String result = this.contents.row(i);
    int len = result.length();

    if (len <= this.width) {
      result = TBUtils.spaces(this.width - len).concat(result);
    } else {
      throw new Exception("Updated string does not fit into the box at row: " + i);
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
