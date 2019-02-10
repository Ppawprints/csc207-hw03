package csc207.dongyila.layout;
public class TruncatedBlock implements TextBlock{
  
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  
  TextBlock contents;
  int maxWidth;
  
  
  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public TruncatedBlock(TextBlock _contents, int _maxWidth) throws Exception {
    if (_maxWidth < 0) {
      throw new Exception("Invalid maxWidth: " + _maxWidth);
    }
    this.contents = _contents;
    this.maxWidth = _maxWidth;
  }
  
  
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
 
  public String row(int i) throws Exception {
    if (i < 0 || i > contents.height()) {
      throw new Exception("Invalid row number: " + i);
    }
    
    String result = this.contents.row(i);
    if (this.contents.width() > this.maxWidth) {
      result = result.substring(0, maxWidth);
    }
    if (this.contents.width() < this.maxWidth) {
      result = result.concat(TBUtils.spaces(this.maxWidth - this.contents.width()));
    }
    return result;
  }

  
  public int height() {
    return this.contents.height();
  }

  
  public int width() {
    return this.maxWidth;
  }

}
