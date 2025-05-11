package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

/**
 * @author yufangwu, lgh
 */
public class ChineseChessGame extends Application {
  private static final int ROWS = 9;
  private static final int COLS = 8;
  private static final int CELL_SIZE = 60;
  private static final String CHE = "车";
  private static final String CHE_AGAINST = "车";
  private static final String MA = "马";
  private static final String MA_AGAINST = "马";
  private static final String PAO = "炮";
  private static final String PAO_AGAINST = "炮";
  private static final String XIANG = "象";
  private static final String XIANG_AGAINST = "相";
  private static final String SHI = "士";
  private static final String SHI_AGAINST = "仕";
  private static final String JIANG = "将";
  private static final String SHUAI = "帅";
  private static final String PING = "兵";
  private static final String PING_AGAINST = "卒";

  private static final Point[][] CHESS_BOARD = new Point[COLS + 1][ROWS + 1];

  private static final List<List<Integer>> LOCAL = new ArrayList<>();

  private static final Integer RANGE = 30;

  private static final Map<String, Rule> RULE_MAP = new HashMap<>(7);

  private static final Map<String, Pane> CHESS_MAP = new HashMap<>(7);

  private static final Pane CHE_ONE_STACK_PANE = new Pane();

  private static final Pane CHE_TWO_STACK_PANE = new Pane();

  private static final Pane CHE_ONE_AGAINST_STACK_PANE = new Pane();

  private static final Pane CHE_TWO_AGAINST_STACK_PANE = new Pane();

  private static final Pane MA_ONE_STACK_PANE = new Pane();

  private static final Pane MA_TWO_STACK_PANE = new Pane();

  private static final Pane MA_ONE_AGAINST_STACK_PANE = new Pane();

  private static final Pane MA_TWO_AGAINST_STACK_PANE = new Pane();

  private static final Pane PAO_ONE_STACK_PANE = new Pane();

  private static final Pane PAO_TWO_STACK_PANE = new Pane();

  private static final Pane PAO_ONE_AGAINST_STACK_PANE = new Pane();

  private static final Pane PAO_TWO_AGAINST_STACK_PANE = new Pane();

  private static final Pane XIANG_ONE_STACK_PANE = new Pane();

  private static final Pane XIANG_TWO_STACK_PANE = new Pane();

  private static final Pane XIANG_ONE_AGANST_STACK_PANE = new Pane();

  private static final Pane XIANG_TWO_AGANST_STACK_PANE = new Pane();


  private static final Pane SHI_ONE_STACK_PANE = new Pane();

  private static final Pane SHI_TWO_STACK_PANE = new Pane();

  private static final Pane SHI_ONE_AGAINST_STACK_PANE = new Pane();

  private static final Pane SHI_TWO_AGAINST_STACK_PANE = new Pane();

  private static final Pane JIANG_STACK_PANE = new Pane();

  private static final Pane SHUAI_STACK_PANE = new Pane();


  private static final Pane PING_ONE_STACK_PANE = new Pane();

  private static final Pane PING_TWO_STACK_PANE = new Pane();

  private static final Pane PING_THREE_STACK_PANE = new Pane();

  private static final Pane PING_FOUR_STACK_PANE = new Pane();

  private static final Pane PING_FIVE_STACK_PANE = new Pane();

  private static final Pane PING_AGAINST_ONE_STACK_PANE = new Pane();

  private static final Pane PING_AGAINST_TWO_STACK_PANE = new Pane();

  private static final Pane PING_AGAINST_THREE_STACK_PANE = new Pane();

  private static final Pane PING_AGAINST_FOUR_STACK_PANE = new Pane();

  private static final Pane PING_AGAINST_FIVE_STACK_PANE = new Pane();

  private static final List<Pane> panes = new ArrayList<>(32);

  static {
    panes.add(CHE_ONE_STACK_PANE);
    panes.add(CHE_TWO_STACK_PANE);
    panes.add(CHE_ONE_AGAINST_STACK_PANE);
    panes.add(CHE_TWO_AGAINST_STACK_PANE);
    panes.add(MA_ONE_STACK_PANE);
    panes.add(MA_TWO_STACK_PANE);
    panes.add(MA_ONE_AGAINST_STACK_PANE);
    panes.add(MA_TWO_AGAINST_STACK_PANE);
    panes.add(PAO_ONE_STACK_PANE);
    panes.add(PAO_TWO_STACK_PANE);
    panes.add(PAO_ONE_AGAINST_STACK_PANE);
    panes.add(PAO_TWO_AGAINST_STACK_PANE);
    panes.add(XIANG_ONE_STACK_PANE);
    panes.add(XIANG_TWO_STACK_PANE);
    panes.add(XIANG_ONE_AGANST_STACK_PANE);
    panes.add(XIANG_TWO_AGANST_STACK_PANE);
    panes.add(SHI_ONE_STACK_PANE);
    panes.add(SHI_TWO_STACK_PANE);
    panes.add(SHI_ONE_AGAINST_STACK_PANE);
    panes.add(SHI_TWO_AGAINST_STACK_PANE);
    panes.add(JIANG_STACK_PANE);
    panes.add(SHUAI_STACK_PANE);
    panes.add(PING_ONE_STACK_PANE);
    panes.add(PING_TWO_STACK_PANE);
    panes.add(PING_THREE_STACK_PANE);
    panes.add(PING_FOUR_STACK_PANE);
    panes.add(PING_FIVE_STACK_PANE);
    panes.add(PING_AGAINST_ONE_STACK_PANE);
    panes.add(PING_AGAINST_TWO_STACK_PANE);
    panes.add(PING_AGAINST_THREE_STACK_PANE);
    panes.add(PING_AGAINST_FOUR_STACK_PANE);
    panes.add(PING_AGAINST_FIVE_STACK_PANE);
  }

  static {
    Circle circle = new Circle(30, 30, 30);
    circle.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    circle.setStroke(Color.BLACK);

    Text cheText = new Text(CHE);
    cheText.setFont(new Font("KaiTi", 40));
    setTextXY(cheText, circle);
    // 使用 Pane 将圆形和文字叠加在一起
    CHE_ONE_STACK_PANE.getChildren().addAll(circle, cheText);


    Circle circleAgainst = new Circle(30 + 60 * 8, 30, 30);
    circleAgainst.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    circleAgainst.setStroke(Color.BLACK);

    Text cheTextAgainst = new Text(CHE_AGAINST);
    cheTextAgainst.setFont(new Font("KaiTi", 40));
    setTextXY(cheTextAgainst, circleAgainst);
    // 使用 Pane 将圆形和文字叠加在一起
    CHE_TWO_STACK_PANE.getChildren().addAll(circleAgainst, cheTextAgainst);

    Circle maCircle = new Circle(30 + 60 * 1, 30, 30);
    maCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    maCircle.setStroke(Color.BLACK);

    Text maText = new Text(MA);
    maText.setFont(new Font("KaiTi", 40));
    setTextXY(maText, maCircle);

    // 使用 Pane 将圆形和文字叠加在一起
    MA_ONE_STACK_PANE.getChildren().addAll(maCircle, maText);

    Circle maCircleAgainst = new Circle(30 + 60 * 7, 30, 30);
    maCircleAgainst.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    maCircleAgainst.setStroke(Color.BLACK);

    Text maTextAgainst = new Text(MA_AGAINST);
    maTextAgainst.setFont(new Font("KaiTi", 40));
    setTextXY(maTextAgainst, maCircleAgainst);
    // 使用 Pane
    MA_TWO_STACK_PANE.getChildren().addAll(maCircleAgainst, maTextAgainst);

    Circle xiangCircle = new Circle(30 + 60 * 2, 30, 30);
    xiangCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    xiangCircle.setStroke(Color.BLACK);

    Text xiangText = new Text(XIANG);
    xiangText.setFont(new Font("KaiTi", 40));
    setTextXY(xiangText, xiangCircle);

    // 使用 Pane 将圆形和文字叠加在一起
    XIANG_ONE_STACK_PANE.getChildren().addAll(xiangCircle, xiangText);

    Circle xiangCircleAgainst = new Circle(30 + 60 * 6, 30, 30);
    xiangCircleAgainst.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    xiangCircleAgainst.setStroke(Color.BLACK);

    Text xiangTextAgainst = new Text(XIANG);
    xiangTextAgainst.setFont(new Font("KaiTi", 40));
    setTextXY(xiangTextAgainst, xiangCircleAgainst);
    // 使用 Pane
    XIANG_TWO_STACK_PANE.getChildren().addAll(xiangCircleAgainst, xiangTextAgainst);

    Circle shiCircle = new Circle(30 + 60 * 3, 30, 30);
    shiCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    shiCircle.setStroke(Color.BLACK);

    Text shiText = new Text(SHI);
    shiText.setFont(new Font("KaiTi", 40));
    setTextXY(shiText, shiCircle);

    SHI_ONE_STACK_PANE.getChildren().addAll(shiCircle, shiText);


    Circle shiCircleAgainst = new Circle(30 + 60 * 5, 30, 30);
    shiCircleAgainst.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    shiCircleAgainst.setStroke(Color.BLACK);

    Text shiTextAgainst = new Text(SHI);
    shiTextAgainst.setFont(new Font("KaiTi", 40));
    setTextXY(shiTextAgainst, shiCircleAgainst);
    // 使用 Pane
    SHI_TWO_STACK_PANE.getChildren().addAll(shiCircleAgainst, shiTextAgainst);

    Circle jiangCircle = new Circle(30 + 60 * 4, 30, 30);
    jiangCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    jiangCircle.setStroke(Color.BLACK);

    Text jiangText = new Text(JIANG);
    jiangText.setFont(new Font("KaiTi", 40));
    setTextXY(jiangText, jiangCircle);
    // 使用 Pane 将圆形和文字叠加在一起
    JIANG_STACK_PANE.getChildren().addAll(jiangCircle, jiangText);

    Circle paoCircle = new Circle(30 + 60 * 1, 30 + 60 * 2, 30);
    paoCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    paoCircle.setStroke(Color.BLACK);

    Text paoText = new Text(PAO);
    paoText.setFont(new Font("KaiTi", 40));
    setTextXY(paoText, paoCircle);
    // 使用 Pane 将
    PAO_ONE_STACK_PANE.getChildren().addAll(paoCircle, paoText);

    Circle paoCircleAgainst = new Circle(30 + 60 * 7, 30 + 60 * 2, 30);
    paoCircleAgainst.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    paoCircleAgainst.setStroke(Color.BLACK);

    Text paoTextAgainst = new Text(PAO_AGAINST);
    paoTextAgainst.setFont(new Font("KaiTi", 40));
    setTextXY(paoTextAgainst, paoCircleAgainst);
    // 使用 Pane
    PAO_TWO_STACK_PANE.getChildren().addAll(paoCircleAgainst, paoTextAgainst);


    Circle pingOneCircle = new Circle(30, 30 + 60 * 3, 30);
    pingOneCircle.setFill(new Color(220d / 255, 220d / 255
            , 220d / 255, 1d));
    pingOneCircle.setStroke(Color.BLACK);

    Text pingText = new Text(PING);
    pingText.setFont(new Font("KaiTi", 40));
    setTextXY(pingText, pingOneCircle);
    // 使用 Pane 将圆形和文字叠加在一起
    PING_ONE_STACK_PANE.getChildren().addAll(pingOneCircle, pingText);

    Circle pingTwoCircle = new Circle(30 + 60 * 2, 30 + 60 * 3, 30);
    pingTwoCircle.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    pingTwoCircle.setStroke(Color.BLACK);

    Text pingTextTwo = new Text(PING);
    pingTextTwo.setFont(new Font("KaiTi", 40));
    setTextXY(pingTextTwo, pingTwoCircle);

    PING_TWO_STACK_PANE.getChildren().addAll(pingTwoCircle, pingTextTwo);

    Circle pingThreeCircle = new Circle(30 + 60 * 4, 30 + 60 * 3, 30);
    pingThreeCircle.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    pingThreeCircle.setStroke(Color.BLACK);

    Text pingTextThree = new Text(PING);
    pingTextThree.setFont(new Font("KaiTi", 40));
    setTextXY(pingTextThree, pingThreeCircle);
    PING_THREE_STACK_PANE.getChildren().addAll(pingThreeCircle, pingTextThree);

    Circle pingFourCircle = new Circle(30 + 60 * 6, 30 + 60 * 3, 30);
    pingFourCircle.setFill(new Color(220d / 255, 220d /
            255, 220d / 255, 1d));
    pingFourCircle.setStroke(Color.BLACK);

    Text pingTextFour = new Text(PING);
    pingTextFour.setFont(new Font("KaiTi", 40));

    setTextXY(pingTextFour, pingFourCircle);
    PING_FOUR_STACK_PANE.getChildren().addAll(pingFourCircle, pingTextFour);

    Circle pingFiveCircle = new Circle(30 + 60 * 8, 30 + 60 * 3, 30);
    pingFiveCircle.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    pingFiveCircle.setStroke(Color.BLACK);

    Text pingTextFive = new Text(PING);
    pingTextFive.setFont(new Font("KaiTi", 40));

    setTextXY(pingTextFive, pingFiveCircle);
    PING_FIVE_STACK_PANE.getChildren().addAll(pingFiveCircle, pingTextFive);


    Circle cheAgainstCircle = new Circle(30 + 60 * 0, 30 + 60 * 9, 30);
    cheAgainstCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    cheAgainstCircle.setStroke(Color.BLACK);

    Text cheAgainstText = new Text(CHE);
    cheAgainstText.setFont(new Font("KaiTi", 40));
    cheAgainstText.setFill(Color.RED);

    setTextXY(cheAgainstText, cheAgainstCircle);
    CHE_ONE_AGAINST_STACK_PANE.getChildren().addAll(cheAgainstCircle, cheAgainstText);

    Circle cheAgainstCircleTwo = new Circle(30 + 60 * 8, 30 + 60 * 9, 30);
    cheAgainstCircleTwo.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    cheAgainstCircleTwo.setStroke(Color.BLACK);

    Text cheAgainstTextTwo = new Text(CHE);
    cheAgainstTextTwo.setFont(new Font("KaiTi", 40));
    cheAgainstTextTwo.setFill(Color.RED);
    setTextXY(cheAgainstTextTwo, cheAgainstCircleTwo);
    CHE_TWO_AGAINST_STACK_PANE.getChildren().addAll(cheAgainstCircleTwo, cheAgainstTextTwo);


    Circle maAgainstCircle = new Circle(30 + 60 * 1, 30 + 60 * 9, 30);
    maAgainstCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    maAgainstCircle.setStroke(Color.BLACK);

    Text maAgainstText = new Text(MA);
    maAgainstText.setFont(new Font("KaiTi", 40));
    maAgainstText.setFill(Color.RED);
    setTextXY(maAgainstText, maAgainstCircle);
    MA_ONE_AGAINST_STACK_PANE.getChildren().addAll(maAgainstCircle, maAgainstText);

    Circle maAgainstCircleTwo = new Circle(30 + 60 * 7, 30 + 60 * 9, 30);
    maAgainstCircleTwo.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    maAgainstCircleTwo.setStroke(Color.BLACK);

    Text maAgainstTextTwo = new Text(MA);
    maAgainstTextTwo.setFont(new Font("KaiTi", 40));
    maAgainstTextTwo.setFill(Color.RED);

    setTextXY(maAgainstTextTwo, maAgainstCircleTwo);
    MA_TWO_AGAINST_STACK_PANE.getChildren().addAll(maAgainstCircleTwo, maAgainstTextTwo);

    Circle xiangAgainstCircle = new Circle(30 + 60 * 2, 30 + 60 * 9, 30);
    xiangAgainstCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    xiangAgainstCircle.setStroke(Color.BLACK);

    Text xiangAgainstText = new Text(XIANG_AGAINST);
    xiangAgainstText.setFont(new Font("KaiTi", 40));
    xiangAgainstText.setFill(Color.RED);

    setTextXY(xiangAgainstText, xiangAgainstCircle);
    XIANG_ONE_AGANST_STACK_PANE.getChildren().addAll(xiangAgainstCircle, xiangAgainstText);

    Circle xiangAgainstCircleTwo = new Circle(30 + 60 * 6, 30 + 60 * 9, 30);
    xiangAgainstCircleTwo.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    xiangAgainstCircleTwo.setStroke(Color.BLACK);

    Text xiangAgainstTextTwo = new Text(XIANG_AGAINST);
    xiangAgainstTextTwo.setFont(new Font("KaiTi", 40));
    xiangAgainstTextTwo.setFill(Color.RED);

    setTextXY(xiangAgainstTextTwo, xiangAgainstCircleTwo);
    XIANG_TWO_AGANST_STACK_PANE.getChildren().addAll(xiangAgainstCircleTwo, xiangAgainstTextTwo);

    Circle shiAgainstCircle = new Circle(30 + 60 * 3, 30 + 60 * 9, 30);
    shiAgainstCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    shiAgainstCircle.setStroke(Color.BLACK);

    Text shiAgainstText = new Text(SHI_AGAINST);
    shiAgainstText.setFont(new Font("KaiTi", 40));
    shiAgainstText.setFill(Color.RED);
    setTextXY(shiAgainstText, shiAgainstCircle);
    SHI_ONE_AGAINST_STACK_PANE.getChildren().addAll(shiAgainstCircle, shiAgainstText);

    Circle shiAgainstCircleTwo = new Circle(30 + 60 * 5, 30 + 60 * 9, 30);
    shiAgainstCircleTwo.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    shiAgainstCircleTwo.setStroke(Color.BLACK);

    Text shiAgainstTextTwo = new Text(SHI_AGAINST);
    shiAgainstTextTwo.setFont(new Font("KaiTi", 40));
    shiAgainstTextTwo.setFill(Color.RED);
    setTextXY(shiAgainstTextTwo, shiAgainstCircleTwo);
    SHI_TWO_AGAINST_STACK_PANE.getChildren().addAll(shiAgainstCircleTwo, shiAgainstTextTwo);

    Circle paoAgainstCircle = new Circle(30 + 60 * 1, 30 + 60 * 7, 30);
    paoAgainstCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    paoAgainstCircle.setStroke(Color.BLACK);

    Text paoAgainstText = new Text(PAO_AGAINST);
    paoAgainstText.setFont(new Font("KaiTi", 40));
    paoAgainstText.setFill(Color.RED);

    setTextXY(paoAgainstText, paoAgainstCircle);
    PAO_ONE_AGAINST_STACK_PANE.getChildren().addAll(paoAgainstCircle, paoAgainstText);

    Circle paoAgainstCircleTwo = new Circle(30 + 60 * 7, 30 + 60 * 7, 30);
    paoAgainstCircleTwo.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    paoAgainstCircleTwo.setStroke(Color.BLACK);

    Text paoAgainstTextTwo = new Text(PAO_AGAINST);
    paoAgainstTextTwo.setFont(new Font("KaiTi", 40));
    paoAgainstTextTwo.setFill(Color.RED);

    setTextXY(paoAgainstTextTwo, paoAgainstCircleTwo);
    PAO_TWO_AGAINST_STACK_PANE.getChildren().addAll(paoAgainstCircleTwo, paoAgainstTextTwo);

    Circle pingAgainstOneCircle = new Circle(30, 30 + 60 * 6, 30);
    pingAgainstOneCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    pingAgainstOneCircle.setStroke(Color.BLACK);

    Text pingAgainstText = new Text(PING_AGAINST);
    pingAgainstText.setFont(new Font("KaiTi", 40));
    pingAgainstText.setFill(Color.RED);

    setTextXY(pingAgainstText, pingAgainstOneCircle);
    PING_AGAINST_ONE_STACK_PANE.getChildren().addAll(pingAgainstOneCircle, pingAgainstText);

    Circle pingAgainstTwoCircle = new Circle(30 + 60 * 2, 30 + 60 * 6, 30);
    pingAgainstTwoCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    pingAgainstTwoCircle.setStroke(Color.BLACK);

    Text pingAgainstTextTwo = new Text(PING_AGAINST);
    pingAgainstTextTwo.setFont(new Font("KaiTi", 40));
    pingAgainstTextTwo.setFill(Color.RED);

    setTextXY(pingAgainstTextTwo, pingAgainstTwoCircle);
    PING_AGAINST_TWO_STACK_PANE.getChildren().addAll(pingAgainstTwoCircle, pingAgainstTextTwo);

    Circle pingAgainstThreeCircle = new Circle(30 + 60 * 4, 30 + 60 * 6, 30);
    pingAgainstThreeCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    pingAgainstThreeCircle.setStroke(Color.BLACK);

    Text pingAgainstTextThree = new Text(PING_AGAINST);
    pingAgainstTextThree.setFont(new Font("KaiTi", 40));
    pingAgainstTextThree.setFill(Color.RED);

    setTextXY(pingAgainstTextThree, pingAgainstThreeCircle);
    PING_AGAINST_THREE_STACK_PANE.getChildren().addAll(pingAgainstThreeCircle, pingAgainstTextThree);

    Circle pingAgainstFourCircle = new Circle(30 + 60 * 6, 30 + 60 * 6, 30);
    pingAgainstFourCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    pingAgainstFourCircle.setStroke(Color.BLACK);

    Text pingAgainstTextFour = new Text(PING_AGAINST);
    pingAgainstTextFour.setFont(new Font("KaiTi", 40));
    pingAgainstTextFour.setFill(Color.RED);

    setTextXY(pingAgainstTextFour, pingAgainstFourCircle);
    PING_AGAINST_FOUR_STACK_PANE.getChildren().addAll(pingAgainstFourCircle, pingAgainstTextFour);

    Circle pingAgainstFiveCircle = new Circle(30 + 60 * 8, 30 + 60 * 6, 30);
    pingAgainstFiveCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    pingAgainstFiveCircle.setStroke(Color.BLACK);

    Text pingAgainstTextFive = new Text(PING_AGAINST);
    pingAgainstTextFive.setFill(Color.RED);
    pingAgainstTextFive.setFont(new Font("KaiTi", 40));

    setTextXY(pingAgainstTextFive, pingAgainstFiveCircle);
    PING_AGAINST_FIVE_STACK_PANE.getChildren().addAll(pingAgainstFiveCircle, pingAgainstTextFive);

    Circle shuaiCircle = new Circle(30 + 60 * 4, 30 + 60 * 9, 30);
    shuaiCircle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    shuaiCircle.setStroke(Color.BLACK);

    Text shuaiText = new Text(SHUAI);
    shuaiText.setFill(Color.RED);
    shuaiText.setFont(new Font("KaiTi", 40));

    setTextXY(shuaiText, shuaiCircle);
    SHUAI_STACK_PANE.getChildren().addAll(shuaiCircle, shuaiText);

  }

  static {

    CHESS_MAP.put("0,0", CHE_ONE_STACK_PANE);
    CHESS_MAP.put("8,0", CHE_TWO_STACK_PANE);
    CHESS_MAP.put("1,0", MA_ONE_STACK_PANE);
    CHESS_MAP.put("7,0", MA_TWO_STACK_PANE);
    CHESS_MAP.put("1,2", PAO_ONE_STACK_PANE);
    CHESS_MAP.put("7,2", PAO_TWO_STACK_PANE);
    CHESS_MAP.put("2,0", XIANG_ONE_STACK_PANE);
    CHESS_MAP.put("6,0", XIANG_TWO_STACK_PANE);
    CHESS_MAP.put("3,0", SHI_ONE_STACK_PANE);
    CHESS_MAP.put("5,0", SHI_TWO_STACK_PANE);
    CHESS_MAP.put("4,0", JIANG_STACK_PANE);
    CHESS_MAP.put("0,9", CHE_ONE_AGAINST_STACK_PANE);
    CHESS_MAP.put("8,9", CHE_TWO_AGAINST_STACK_PANE);
    CHESS_MAP.put("1,9", MA_ONE_AGAINST_STACK_PANE);
    CHESS_MAP.put("7,9", MA_TWO_AGAINST_STACK_PANE);
    CHESS_MAP.put("1,7", PAO_ONE_AGAINST_STACK_PANE);
    CHESS_MAP.put("7,7", PAO_TWO_AGAINST_STACK_PANE);
    CHESS_MAP.put("2,9", XIANG_ONE_AGANST_STACK_PANE);
    CHESS_MAP.put("6,9", XIANG_TWO_AGANST_STACK_PANE);
    CHESS_MAP.put("3,9", SHI_ONE_AGAINST_STACK_PANE);
    CHESS_MAP.put("5,9", SHI_TWO_AGAINST_STACK_PANE);
    CHESS_MAP.put("4,9", SHUAI_STACK_PANE);

    CHESS_MAP.put("0,3", PING_ONE_STACK_PANE);
    CHESS_MAP.put("2,3", PING_TWO_STACK_PANE);
    CHESS_MAP.put("4,3", PING_THREE_STACK_PANE);
    CHESS_MAP.put("6,3", PING_FOUR_STACK_PANE);
    CHESS_MAP.put("8,3", PING_FIVE_STACK_PANE);

    CHESS_MAP.put("0,6", PING_AGAINST_ONE_STACK_PANE);
    CHESS_MAP.put("2,6", PING_AGAINST_TWO_STACK_PANE);
    CHESS_MAP.put("4,6", PING_AGAINST_THREE_STACK_PANE);
    CHESS_MAP.put("6,6", PING_AGAINST_FOUR_STACK_PANE);
    CHESS_MAP.put("8,6", PING_AGAINST_FIVE_STACK_PANE);

  }

  static {
    Rule cheRule = new CheRule();
    Rule maRule = new MaRule();
    Rule paoRule = new PaoRule();
    Rule xiangRule = new XiangRule();
    Rule shiRule = new ShiRule();
    Rule jiangRule = new JiangRule();
    Rule pingRule = new PingRule();

    RULE_MAP.put("1", cheRule);
    RULE_MAP.put("2", maRule);
    RULE_MAP.put("3", paoRule);
    RULE_MAP.put("4", xiangRule);
    RULE_MAP.put("5", shiRule);
    RULE_MAP.put("6", jiangRule);
    RULE_MAP.put("7", pingRule);


  }

  static {
    for (int i = 0; i < COLS + 1; i++) {
      for (int j = 0; j < ROWS + 1; j++) {
        LOCAL.add(Arrays.asList(CELL_SIZE * i, CELL_SIZE * j));
      }
    }
  }

  static {
    for (int i = 0; i < CHESS_BOARD.length; i++) {
      for (int j = 0; j < CHESS_BOARD[i].length; j++) {
        CHESS_BOARD[i][j] = new Point(i, j);
      }
    }
    Point redCheOne = new QiZi(CHE, "red", "1", 0, 9);
    Point redCheTwo = new QiZi(CHE, "red", "1", 8, 9);
    Point redMaOne = new QiZi(MA, "red", "2", 1, 9);
    Point redMaTwo = new QiZi(MA, "red", "2", 7, 9);
    Point paoRedOne = new QiZi(PAO, "red", "3", 1, 7);
    Point paoRedTwo = new QiZi(PAO, "red", "3", 7, 7);
    Point xiangRedOne = new QiZi(XIANG_AGAINST, "red", "4", 2, 9);
    Point xiangRedTwo = new QiZi(XIANG_AGAINST, "red", "4", 6, 9);
    Point shiRedOne = new QiZi(SHI_AGAINST, "red", "5", 3, 9);
    Point shiRedTwo = new QiZi(SHI_AGAINST, "red", "5", 5, 9);
    Point shuaiRed  = new QiZi(SHUAI, "red", "6", 4, 9);


    Point pingRedOne = new QiZi(PING_AGAINST, "red", "7", 0, 6);
    Point pingRedTwo = new QiZi(PING_AGAINST, "red", "7", 2, 6);
    Point pingRedThree = new QiZi(PING_AGAINST, "red", "7", 4, 6);
    Point pingRedFour = new QiZi(PING_AGAINST, "red", "7", 6, 6);
    Point pingRedFive = new QiZi(PING_AGAINST, "red", "7", 8, 6);

    Point blackChe = new QiZi(CHE, "black", "1", 0, 0);
    Point blackCheTwo = new QiZi(CHE, "black", "1", 8, 0);
    Point backMaTwo = new QiZi(MA, "black", "2", 1, 0);
    Point blackMaOne = new QiZi(MA, "black", "2", 7, 0);
    Point paoBlackOne = new QiZi(PAO, "black", "3", 1, 2);
    Point paoBlackTwo = new QiZi(PAO, "black", "3", 7, 2);
    Point xiangBlackOne = new QiZi(XIANG, "black", "4", 2, 0);
    Point xiangBlackTwo = new QiZi(XIANG, "black", "4", 6, 0);
    Point shiBlackOne = new QiZi(SHI, "black", "5", 3, 0);
    Point shiBlackTwo = new QiZi(SHI, "black", "5", 5, 0);
    Point blackJiang = new QiZi(JIANG, "black", "6", 4, 0);

    Point pingBlackOne = new QiZi(PING, "black", "7", 0, 3);
    Point pingBlackTwo = new QiZi(PING, "black", "7", 2, 3);
    Point pingBlackThree = new QiZi(PING, "black", "7", 4, 3);
    Point pingBlackFour = new QiZi(PING, "black", "7", 6, 3);
    Point pingBlackFive = new QiZi(PING, "black", "7", 8, 3);

    CHESS_BOARD[0][0] = blackChe;
    CHESS_BOARD[COLS][0] = blackCheTwo;
    CHESS_BOARD[1][0] = backMaTwo;
    CHESS_BOARD[COLS - 1][0] = blackMaOne;
    CHESS_BOARD[1][2] = paoBlackOne;
    CHESS_BOARD[COLS - 1][2] = paoBlackTwo;
    CHESS_BOARD[2][0] = xiangBlackOne;
    CHESS_BOARD[COLS - 2][0] = xiangBlackTwo;
    CHESS_BOARD[3][0] = shiBlackOne;
    CHESS_BOARD[COLS - 3][0] = shiBlackTwo;
    CHESS_BOARD[4][0] = blackJiang;
    CHESS_BOARD[4][ROWS] = shuaiRed;
    CHESS_BOARD[0][3] = pingBlackOne;
    CHESS_BOARD[2][3] = pingBlackTwo;
    CHESS_BOARD[4][3] = pingBlackThree;
    CHESS_BOARD[6][3] = pingBlackFour;
    CHESS_BOARD[8][3] = pingBlackFive;

    CHESS_BOARD[0][ROWS] = redCheOne;
    CHESS_BOARD[COLS][ROWS] = redCheTwo;
    CHESS_BOARD[1][ROWS] = redMaOne;
    CHESS_BOARD[COLS - 1][ROWS] = redMaTwo;
    CHESS_BOARD[1][ROWS - 2] = paoRedOne;

    CHESS_BOARD[COLS - 1][ROWS - 2] = paoRedTwo;
    CHESS_BOARD[2][ROWS] = xiangRedOne;
    CHESS_BOARD[COLS - 2][ROWS] = xiangRedTwo;
    CHESS_BOARD[3][ROWS] = shiRedOne;
    CHESS_BOARD[COLS - 3][ROWS] = shiRedTwo;
    CHESS_BOARD[0][6] = pingRedOne;
    CHESS_BOARD[2][6] = pingRedTwo;
    CHESS_BOARD[4][6] = pingRedThree;
    CHESS_BOARD[6][6] = pingRedFour;
    CHESS_BOARD[8][6] = pingRedFive;

    for (int i = 0; i < CHESS_BOARD.length; i++) {
      for (int j = 0; j < CHESS_BOARD[i].length; j++) {
        if (CHESS_BOARD[i][j] ==null) {
            CHESS_BOARD[i][j] = new Point(i, j);
        }
      }
    }
  }


  @Override
  public void start(Stage primaryStage) {
    Pane root = new Pane();
    GridPane chessBoard = createChessBoard();
    root.getChildren().add(chessBoard);

    //红方九宫格
    drawAdvisorMoves(root, 3, 0);
    //黑方九宫格
    drawAdvisorMoves(root, 3, 7);

    initQiZi(root);
    final Boolean[] flag = {false};
    final Point[] before = new QiZi[1];
    final int[] count = {0};
    Scene scene = new Scene(root, COLS * CELL_SIZE + 60, ROWS * CELL_SIZE + 60);
    // 为场景添加鼠标点击事件处理器
    scene.setOnMouseClicked(event -> {
      count[0]++;
      if (count[0] > 2) {
        count[0] = 1;
      }
      double x = event.getX(); // 获取鼠标点击的 X 坐标
      double y = event.getY(); // 获取鼠标点击的 Y 坐标
      List<Integer> range = findRange(Double.valueOf(x).intValue(), Double.valueOf(y).intValue(), LOCAL, RANGE);
      if (CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE] instanceof QiZi) {
        before[0] = CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE];
      }

      // 如果点击的是不同的棋子，一是颜色相同则换成其他棋子， 二是颜色不同则before不变保持原来的状态
      if ((CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE] instanceof QiZi) &&
              !before[0].equals(CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE])) {
        if (((QiZi) before[0]).getColor().equals(((QiZi) CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE]).getColor())) {
          before[0] = CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE];
          count[0] = 0;
          flag[0] = !flag[0];
        } else {
          count[0] = 1;
        }
      }

      if (count[0] == 2 && before[0] instanceof QiZi
              &&((!flag[0]&&((QiZi) before[0]).getColor().equals("red"))||
                  (flag[0]&&((QiZi) before[0]).getColor().equals("black")))){

        Point after = CHESS_BOARD[range.get(0) / CELL_SIZE][range.get(1) / CELL_SIZE];
        QiZi qiZi = (QiZi) before[0];
        // 如果点击的是棋子，则将棋子移动到新的位置
        if (RULE_MAP.get(qiZi.getRule()).isLegal(qiZi, CHESS_BOARD, after)) {
          CHESS_BOARD[range.get(0)/CELL_SIZE][range.get(1)/CELL_SIZE] = new QiZi(((QiZi) before[0]).getName(),((QiZi) before[0]).getColor(),((QiZi) before[0]).getRule(),range.get(0)/CELL_SIZE,range.get(1)/CELL_SIZE);
          CHESS_BOARD[before[0].getX()][before[0].getY()] = new Point(before[0].getX(), before[0].getY());
          Pane beforePane = CHESS_MAP.get(before[0].getX() + "," + before[0].getY());
          CHESS_MAP.remove(before[0].getX() + "," + before[0].getY());
          root.getChildren().remove(beforePane);
          Pane pane = createPane(((QiZi) before[0]).getColor(), ((QiZi) before[0]).getName(), range.get(0) / CELL_SIZE, range.get(1) / CELL_SIZE);
          CHESS_MAP.put(range.get(0) / CELL_SIZE + "," + range.get(1) / CELL_SIZE, pane);
          root.getChildren().add(pane);
          flag[0] = !flag[0];
        } else {
          count[0] = 1;
        }
      }
    });

    primaryStage.setTitle("象棋棋盘");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private GridPane createChessBoard() {
    GridPane gridPane = new GridPane();
    gridPane.setLayoutX(30);
    gridPane.setLayoutY(30);

    for (int row = 0; row < ROWS; row++) {
      for (int col = 0; col < COLS; col++) {
        Pane cell = new Pane();
        cell.setPrefSize(CELL_SIZE, CELL_SIZE);
        setCellStyle(cell, row, col);
        gridPane.add(cell, col, row);
      }
    }
    gridPane.setStyle("-fx-background-color: burlywood");
    return gridPane;
  }

  private void setCellStyle(Pane cell, int row, int col) {
    String border = "-fx-border-width: 0 1 1 0; -fx-border-color: black;";
    if (row == 0 && col == 0) {
      border = "-fx-border-width: 1; -fx-border-color: black;";
    } else if (row == 0) {
      border = "-fx-border-width: 1 1 1 0; -fx-border-color: black;";
    } else if (col == 0) {
      if (row == 4) {
        border = "-fx-border-width: 0 0 1 1; -fx-border-color: black;";
      } else {
        border = "-fx-border-width: 0 1 1 1; -fx-border-color: black;";
      }
    } else if (row == 4) {
      if (col == COLS - 1) {
        border = "-fx-border-width: 0 1 1 0; -fx-border-color: black;";
      } else {
        border = "-fx-border-width: 0 0 1 0; -fx-border-color: black;";
      }
    }
    cell.setStyle(border);
  }

  private void drawAdvisorMoves(Pane root, int startCol, int startRow) {
    // 九宫格四角点
    double[][] corners = {
            {startCol * CELL_SIZE + 30, startRow * CELL_SIZE + 30},
            {(startCol + 2) * CELL_SIZE + 30, startRow * CELL_SIZE + 30},
            {startCol * CELL_SIZE + 30, (startRow + 2) * CELL_SIZE + 30},
            {(startCol + 2) * CELL_SIZE + 30, (startRow + 2) * CELL_SIZE + 30},
    };

    double centerX = (startCol + 1) * CELL_SIZE + 30;
    double centerY = (startRow + 1) * CELL_SIZE + 30;

    for (double[] point : corners) {
      Line line = new Line(point[0], point[1], centerX, centerY);
      line.setStroke(Color.BLACK);
      line.setStrokeWidth(1);
      root.getChildren().add(line);
    }
  }

  public void initQiZi(Pane root) {

    Text chuText = new Text("楚河");
    chuText.setFont(new Font("KaiTi", 30));
    chuText.setX(100);
    chuText.setY(310);

    Text hanText = new Text("汉界");
    hanText.setFont(new Font("KaiTi", 30));
    hanText.setX(400);
    hanText.setY(310);

    root.getChildren().addAll(chuText, hanText);

    root.getChildren().addAll(panes);

  }

  public List<Integer> findRange(int x, int y, List<List<Integer>> board, int range) {
    for (List<Integer> list : board) {
      int x1 = list.get(0);
      int y1 = list.get(1);
      if (x1 - range < x - range && x1 + range > x - range && y1 - range < y - range && y1 + range > y - range) {
        return list;
      }
    }
    return new ArrayList<>();
  }

  public static void setTextXY(Text text, Circle circle) {
    // 将文字居中放置在圆形内
    double textWidth = text.getLayoutBounds().getWidth();
    double textHeight = text.getLayoutBounds().getHeight();
    text.setX(circle.getCenterX() - textWidth / 2);
    text.setY(circle.getCenterY() + textHeight / 4);
  }

  public Pane createPane(String color, String name, int x, int y) {
    Pane pane = new Pane();

    Circle circle = new Circle(30 + 60 * x, 30 + 60 * y, 30);
    if ("red".equals(color)) {
      circle.setFill(new Color(245d / 255, 222d / 255, 179d / 255, 1d));
    } else {
      circle.setFill(new Color(220d / 255, 220d / 255, 220d / 255, 1d));
    }

    circle.setStroke(Color.BLACK);

    Text text = new Text(name);

    if ("red".equals(color)) {
      text.setFill(Color.RED);
    } else {
      text.setFill(Color.BLACK);
    }
    text.setFont(new Font("KaiTi", 40));

    setTextXY(text, circle);
    pane.getChildren().addAll(circle, text);
    return pane;
  }


  public static void main(String[] args) {
    launch(args);
  }
}

