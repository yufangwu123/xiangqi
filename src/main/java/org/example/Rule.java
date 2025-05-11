package org.example;

/**
 * @author yufangwu
 */
public interface Rule {

  boolean isLegal(QiZi qiZi,Point[][] chessBoard, Point point);
}
