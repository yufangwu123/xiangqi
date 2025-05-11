package org.example;

/**
 * @author yufangwu
 */
public class PaoRule implements Rule {


  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = qiZi.getX();
    int y = qiZi.getY();
    int x1 = point.getX();
    int y1 = point.getY();

    if (x == x1 && y != y1) {
      int count = 0;
      int y2 = Math.max(y, y1);
      int y3 = Math.min(y, y1);
      for (int i = y3; i <= y2; i++) {
        if (i != y && chessBoard[x][i] instanceof QiZi) {
          count++;
        }
      }
      if (count == 0) {
        return true;
      }
      if (count == 2) {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) point).getColor());
        }
      }
    }

    if (x != x1 && y == y1) {
      int count = 0;
      int x2 = Math.max(x, x1);
      int x3 = Math.min(x, x1);
      for (int i = x3; i <= x2; i++) {
        if (i != x && chessBoard[i][y] instanceof QiZi) {
          count++;
        }
      }
      if (count == 0) {
        return true;
      }
      if (count == 2) {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) point).getColor());
        }
      }
    }
    return false;
  }
}
