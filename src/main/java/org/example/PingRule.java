package org.example;

/**
 * @author yufangwu
 */
public class PingRule implements Rule {


  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = point.getX();
    int y = point.getY();
    int x1 = qiZi.getX();
    int y1 = qiZi.getY();
    if ("red".equals(qiZi.getColor())) {
      if (y < 6 && x == x1) {
        return y1 - y == 1;
      } else {
        if (Math.abs(x - x1) == 1 || Math.abs(y - y1) == 1) {
          if(point instanceof QiZi){
            return !qiZi.getColor().equals(((QiZi) point).getColor());
          }else{
            return true;
          }
        }
      }
    } else {
      if (y > 5 && x == x1) {
        return y - y1 == 1;
      } else {
        if (Math.abs(x - x1) == 1 || Math.abs(y - y1) == 1) {
          if(point instanceof QiZi){
            return !qiZi.getColor().equals(((QiZi) point).getColor());
          }else{
            return true;
          }
        }
      }
    }
    return false;
  }
}
