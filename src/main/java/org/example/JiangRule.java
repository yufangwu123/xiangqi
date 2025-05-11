package org.example;

/**
 * @author yufangwu
 */
public class JiangRule implements Rule {


  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = qiZi.getX();
    int y = qiZi.getY();
    int x1 = point.getX();
    int y1 = point.getY();
    if (Math.abs(x - x1) == 1 || Math.abs(y - y1) == 1) {
       if(point instanceof QiZi){
         if(!qiZi.getColor().equals(((QiZi) point).getColor())){
           return inJiu(qiZi.getColor(),x1,y1,chessBoard);
         }else{
           return false;
         }
       }else {
         return inJiu(qiZi.getColor(),x1,y1,chessBoard);
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
