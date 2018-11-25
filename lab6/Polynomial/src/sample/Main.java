package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        List<Integer> coeff = new ArrayList<Integer>();

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        VBox root2 = new VBox();
        root2.setPadding(new Insets(10));
        root2.setSpacing(10);

        Label label1 = new Label("Podaj współczynnika przy x^0");
        TextField read_coeff = new TextField();

        Label label2 = new Label("Zakres od:");
        TextField read_from = new TextField();

        Label label3 = new Label("Zakres do:");
        TextField read_until = new TextField();

        Label label4 = new Label("Czestotliwosc probkowania:");
        TextField read_frequency = new TextField();

        Button button = new Button("Dodaj");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                coeff.add(Integer.valueOf(read_coeff.getText()));
                label1.setText("Podaj współczynnika przy x^" + coeff.size());
            }
        });


        Button button_draw = new Button("Rysuj wykres");

        button_draw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final NumberAxis xAxis = new NumberAxis();
                final NumberAxis yAxis = new NumberAxis();

                final LineChart<Number,Number> lineChart =
                        new LineChart<Number,Number>(xAxis,yAxis);

                XYChart.Series series = new XYChart.Series();

                for(int i=Integer.parseInt(read_from.getText()); i<=Integer.parseInt(read_until.getText()); i+=((Integer.parseInt(read_until.getText())-Integer.parseInt(read_from.getText()))/(Integer.parseInt(read_frequency.getText())))) {
                    int value_y = 0;

                    for(int j=0; j<coeff.size(); j++){
                        value_y+=coeff.get(j)*pow(i,j);
                    }

                    System.out.println(value_y);

                    series.getData().add(new XYChart.Data(i, value_y));
                }

                lineChart.getData().addAll(series);

                Scene scene2  = new Scene(lineChart,800,600);
                stage.setScene(scene2);
            }
        });


        root.getChildren().addAll(label1, read_coeff, button, label2, read_from, label3, read_until, label4, read_frequency, button_draw);
        Scene scene = new Scene(root);


        stage.setTitle("Polynomial");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}