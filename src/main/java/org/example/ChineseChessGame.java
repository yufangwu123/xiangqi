package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author yufangwu,lgh
 */
public class ChineseChessGame extends Application {
    private static final int ROWS = 9;
    private static final int COLS = 8;
    private static final int CELL_SIZE = 60;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        GridPane chessBoard = createChessBoard();
        root.getChildren().add(chessBoard);

        //红方九宫格
        drawAdvisorMoves(root, 3, 0);
        //黑方九宫格
        drawAdvisorMoves(root, 3, 7);

        Text chuText = new Text("楚河");
        chuText.setFont(new Font("KaiTi", 30));
        chuText.setX(100);
        chuText.setY(310);

        Text hanText = new Text("汉界");
        hanText.setFont(new Font("KaiTi", 30));
        hanText.setX(400);
        hanText.setY(310);

        root.getChildren().addAll(chuText, hanText);


        Scene scene = new Scene(root, COLS * CELL_SIZE + 60, ROWS * CELL_SIZE + 60);
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

    public static void main(String[] args) {
        launch(args);
    }
}

