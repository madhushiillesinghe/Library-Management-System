package lk.ijse.library.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.DashboardService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    DashboardService dashboardService= (DashboardService) BoFactory.getBoFactory().getBo(BoFactory.BOType.DASHBOARD);

    @FXML
    private Pane pieChartPane;
    private void pieChart() {
       /* PieChart piechart=new PieChart();
        try{
            ObservableList<PieChart.Data> pieChartData= dashboardService.getUserDataForPieChart();
            piechart.setData(pieChartData);
            piechart.getData().get(0).getNode().setStyle("-fx-pie-color: #151B8D ");
            piechart.getData().get(1).getNode().setStyle("-fx-pie-color: #046307 ");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // stackPane to center the PieChart
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(piechart);

        pieChartPane.getChildren().add(stackPane);
        StackPane.setAlignment(stackPane, Pos.CENTER);*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pieChart();
    }
}
