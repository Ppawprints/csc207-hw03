package csc207.dongyila.layout;

public class Grid implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  char ch;
  int width;
  int height;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Grid(int _width, int _height, char _ch) throws Exception {
    if (_width < 0 || _height < 0) {
      throw new Exception("Invalid arguments");
    }
    this.width = _width;
    this.height = _height;
    this.ch = _ch;
  }


  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String row(int i) throws Exception {
    if (i < 0 || i > this.height) {
      throw new Exception("Invalid row number: " + i);
    }
    String result = Character.toString(ch);
    while (result.length() < this.width) {
      result += result;
    }
    return result.substring(0, this.width);
  }

  public int height() {
    return this.height;
  }

  public int width() {
    return this.width;
  }


}
