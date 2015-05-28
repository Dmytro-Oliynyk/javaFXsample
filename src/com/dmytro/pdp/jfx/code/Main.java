package com.dmytro.pdp.jfx.code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class Main extends Application {
    GraphicsContext graphicsContext;
    List<Color> colors = Arrays.asList(Color.AQUA, Color.BROWN, Color.CYAN, Color.DARKKHAKI);
    int colorId = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World use canvas.");
        FlowPane flowNode = new FlowPane();
        flowNode.setAlignment(Pos.CENTER);

        Scene scene = new Scene(flowNode, 450, 450);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(400, 400);
        graphicsContext = canvas.getGraphicsContext2D();

        Button btnCangeColor = new Button("Change Color");
        btnCangeColor.setOnAction((ActionEvent event) -> {
            graphicsContext.setStroke(colors.get(colorId));
            graphicsContext.setFill(colors.get(colorId));

            graphicsContext.strokeLine(0, 0, 200, 200);
            graphicsContext.fillText("Some text 1", 60, 50);

            graphicsContext.fillRect(100, 320, 300, 40);
            colorId++;
            if (colorId == colors.size()) {
                colorId = 0;
            }
        });

        graphicsContext.strokeLine(0, 0, 200, 200);
        graphicsContext.strokeOval(100, 100, 200, 200);
        graphicsContext.strokeRect(0, 200, 50, 200);
        graphicsContext.fillOval(0, 0, 20, 20);
        graphicsContext.fillRect(100, 320, 300, 40);
        graphicsContext.setFont(new Font(20));
        graphicsContext.fillText("Some text 2", 60, 50);

        flowNode.getChildren().addAll(canvas,btnCangeColor);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
