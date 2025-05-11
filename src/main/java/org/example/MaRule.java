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
    if ("red".equals(qiZi.getColor())) {
      //row right up
      if (x - x1 == 2 && y - y1 == 1) {
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
      if (x - x1 == -2 && y - y1 == 1) {
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
      if (x - x1 == 2 && y - y1 == -1) {
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
      if (x - x1 == -2 && y - y1 == -1) {
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
      //col right up
      if (x - x1 == 1 && y - y1 == 2) {
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
      if (x - x1 == 1 && y - y1 == -2) {
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
      if (x - x1 == -1 && y - y1 == 2) {
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
      //col left down
      if (x - x1 == -1 && y - y1 == -2) {
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
    } else {
      //1
      if (x1 - x == 2 && y1 - y == -1) {

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
      //2
      if (x1 - x == -2 && y1 - y == -1) {
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

      //3
      if (x1 - x == 2 && y1 - y == 1) {
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
      //4
      if (x1 - x == -2 && y1 - y == 1) {
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

      //5
      if (x1 - x == 1 && y1 - y == 2) {
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

      //6
      if (x1 - x == 1 && y1 - y == -2) {
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

      //7
      if (x1 - x == -1 && y1 - y == 2) {
        if (chessBoard[x1][y1 - 1] instanceof QiZi) {
          return false;
        }else{
          if (point instanceof QiZi) {
            return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
          }else{
            return true;
          }
        }
      }

      //8
      if (x1 - x == -1 && y1 - y == -2) {
        if (chessBoard[x1][y1 + 1] instanceof QiZi) {
          return false;
        }else{
          if (point instanceof QiZi) {
            return !qiZi.getColor().equals(((QiZi) chessBoard[x][y]).getColor());
          }else{
            return true;
          }
        }
      }
    }
    return false;
  }
}
