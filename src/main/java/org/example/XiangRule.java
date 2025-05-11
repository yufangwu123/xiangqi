package org.example;

/**
 * @author yufangwu
 */
public class XiangRule implements Rule{



  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = point.getX();
    int y = point.getY();
    int x1 = qiZi.getX();
    int y1 = qiZi.getY();
    if(Math.abs(x-x1)==2&&Math.abs(y-y1)==2) {
      if(inMyself(qiZi.getColor(), x, y, chessBoard)) {
         if(point instanceof QiZi){
           return shaiXiangYan(x,y,x1,y1,chessBoard)&&!qiZi.getColor().equals(((QiZi) point).getColor());
         }else{
           return true;
         }
      }
    }
    return false;
  }

  public boolean inMyself(String color, int x, int y, Point[][] chessBoard) {
    if("red".equals(color)) {
       return y>=5&&x>=0&&x<=8;
    }else{
      return y<5&&x>=0&&x<=8;
    }
  }
  public boolean shaiXiangYan(int x,int y, int x1, int y1, Point[][] chessBoard) {
    int x2 = (x+x1)/2;
    int y2 = (y+y1)/2;
    return !(chessBoard[x2][y2] instanceof QiZi);
  }
}
