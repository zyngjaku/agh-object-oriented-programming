package pl.edu.agh.student.zyngier;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.Arrays;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private void init(Stage primaryStage) {
        HBox root = new HBox();
        primaryStage.setScene(new Scene(root));

        final TextField add_value_1 = new TextField();
        final TextField add_value_2 = new TextField();
        final TextField add_value_3 = new TextField();
        final Button add_button = new Button("Add value");

        add_value_1.setMaxWidth(100);
        add_value_2.setMaxWidth(100);
        add_value_3.setMaxWidth(100);
        add_button.setMaxWidth(100);
        root.getChildren().addAll(add_value_1, add_value_2, add_value_3, add_button, createChart(add_button, add_value_1, add_value_2, add_value_3));
    }

    protected BarChart<String, Number> createChart(final Button add_button, final TextField add_value_1, final TextField add_value_2, final TextField add_value_3) {
        final String[] specialities = {"1", "2", "3"};
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);

        bc.setTitle("Histogram");
        bc.setLegendVisible(false);

        xAxis.setLabel("x");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(specialities)));

        yAxis.setLabel("y");

        final XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.setName("1");
        final XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.setName("2");
        final XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.setName("3");

        add_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                series1.getData().clear();

                series1.getData().add(new XYChart.Data<String,Number>(specialities[0], Integer.parseInt(add_value_1.getText())));
                series1.getData().add(new XYChart.Data<String,Number>(specialities[1], Integer.parseInt(add_value_2.getText())));
                series1.getData().add(new XYChart.Data<String,Number>(specialities[2], Integer.parseInt(add_value_3.getText())));
            }
        });

        bc.getData().add(series1);

        return bc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
