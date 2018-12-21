package pl.edu.agh.student.zyngier;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Circle circle = new Circle(200, 200, 50);
    Polygon  triangle = new Polygon(50.0, 0.0,  0.0, 50.0,100.0, 50.0);
    Rectangle rectangle = new Rectangle(100,100, 50, 50);

    private Text text = new Text();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.getChildren().addAll(circle, rectangle, triangle, text);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();

        circle.setOnMouseDragged(e -> {
            if (circle.contains(e.getX(), e.getY())) {
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
        });

        rectangle.setOnMouseDragged(e -> {
            if (rectangle.contains(e.getX(), e.getY())) {
                rectangle.setX(e.getX()-rectangle.getWidth()/2);
                rectangle.setY(e.getY()-rectangle.getHeight()/2);
            }
        });

        final ObjectProperty<Point2D> mousePosition = new SimpleObjectProperty<>();

        triangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
            }
        });

        triangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double deltaX = event.getSceneX() - mousePosition.get().getX();
                double deltaY = event.getSceneY() - mousePosition.get().getY();
                triangle.setLayoutX(triangle.getLayoutX()+deltaX);
                triangle.setLayoutY(triangle.getLayoutY()+deltaY);
                mousePosition.set(new Point2D(event.getSceneX(), event.getSceneY()));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}