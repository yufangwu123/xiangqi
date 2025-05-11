package org.example;

/**
 * @author yufangwu
 */
public class MaRule implements Rule {

  @Override
  public boolean isLegal(QiZi qiZi, Point[][] chessBoard, Point point) {
    int x = point.getX();
    int y = point.getY();
    int x1 = qiZi.getX();
    int y1 = qiZi.getY();
    //row  right up
    if (x1 - x == 2 && y1 - y == 1) {
      if (chessBoard[x1 + 1][y1] instanceof QiZi) {
        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //row left up
    if (x1 - x == -2 && y1 - y == 1) {
      if (chessBoard[x1 - 1][y1] instanceof QiZi) {
        return false;
      } else {

        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //row right down
    if (x1 - x == 2 && y1 - y == -1) {
      if (chessBoard[x1 + 1][y1] instanceof QiZi) {
        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //row left down
    if (x1 - x == -2 && y1 - y == -1) {
      if (chessBoard[x1][y1 + 1] instanceof QiZi) {
        return false;
      } else {

        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //col right up
    if (x1 - x == 1 && y1 - y == 2) {
      if (chessBoard[x1][y1 + 1] instanceof QiZi) {
        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //col right down
    if (x1 - x == 1 && y1 - y == -2) {
      if (chessBoard[x1][y1 - 1] instanceof QiZi) {

        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //col left up
    if (x1 - x == -1 && y1 - y == 2) {
      if (chessBoard[x1][y1 - 1] instanceof QiZi) {

        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    //col left down
    if (x1 - x == -1 && y1 - y == -2) {
      if (chessBoard[x1][y1 + 1] instanceof QiZi) {
        return false;
      } else {
        if (point instanceof QiZi) {
          return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
        } else {
          return true;
        }
      }
    }
    return false;
  }
}
