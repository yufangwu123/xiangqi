package org.example;


/**
 * @author yufangwu
 */
public class ShiRule implements Rule{


  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = point.getX();
    int y = point.getY();
    int x1 = qiZi.getX();
    int y1 = qiZi.getY();
    if(Math.abs(x-x1)==1&&Math.abs(y-y1)==1) {
      if(inJiu(qiZi.getColor(), x, y, chessBoard)) {
         if(point instanceof QiZi){
           return !qiZi.getColor().equals(((QiZi) point).getColor());
         }else{
           return true;
         }
      }
    }
    return false;
  }

  public boolean inJiu(String color, int x, int y, Point[][] chessBoard) {
    if ("red".equals(color)) {
      return x >= 3 && x < 6 && y >= 7 && y <= 9;
    } else {
      return x >= 3 && x < 6 && y >= 0 && y <= 2;
    }
  }
}
