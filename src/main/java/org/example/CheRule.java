package org.example;

/**
 * @author yufangwu
 */
public class CheRule implements Rule {


  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = point.getX();
    int y = point.getY();
    int x1 = qiZi.getX();
    int y1 = qiZi.getY();
    if (x == x1 && y != y1) {
      int count = 0;
      int y2 = Math.max(y, y1);
      int y3 = Math.min(y, y1);
      for (int i = y3; i <= y2; i++) {
        if (i != y1 && chessBoard[x][i] instanceof QiZi) {
          count++;
        }
      }
      if (count == 0) {
        return true;
      }

      if (count == 1) {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) point).getColor());
        } else {
          return true;
        }
      }
    }
    if (x != x1 && y == y1) {

      int count = 0;
      int x2 = Math.max(x, x1);
      int x3 = Math.min(x, x1);
      for (int i = x3; i <= x2; i++) {
        if (i != x1 && chessBoard[i][y] instanceof QiZi) {
          count++;
        }
      }
      if (count == 0) {
        return true;
      }

      if (count == 1) {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) point).getColor());
        } else {
          return true;
        }
      }


    }
    return false;
  }
}
