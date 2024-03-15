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
import javafx.scene.control.Label;


import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    DashboardService dashboardService= (DashboardService) BoFactory.getBoFactory().getBo(BoFactory.BOType.DASHBOARD);

    @FXML
    private Pane CRUDPane;
    @FXML
    private Pane CRUDPane1;
    @FXML
    private Label lblBookCount;

    @FXML
    private Label lblBranchCunt;

    @FXML
    private Label lblUserCount;
    private void pieChart() {
        PieChart piechart=new PieChart();
        try{
            ObservableList<PieChart.Data> pieChartData= dashboardService.getUserDataForPieChart();
            piechart.setData(pieChartData);
            piechart.getData().get(0).getNode().setStyle("-fx-pie-color: #06375e ");
            piechart.getData().get(1).getNode().setStyle("-fx-pie-color: #592b03 ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(piechart);

        CRUDPane.getChildren().add(stackPane);
        StackPane.setAlignment(stackPane, Pos.CENTER);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblBookCount.setText(String.valueOf(dashboardService.bookCount()));
        lblUserCount.setText(String.valueOf(dashboardService.userCount()));
        lblBranchCunt.setText(String.valueOf(dashboardService.branchCount()));
        pieChart();
        pieChart2();
    }

    private void pieChart2() {
        PieChart piechart=new PieChart();
        try{
            ObservableList<PieChart.Data> pieChartData= dashboardService.getTransactionPieChart();
            piechart.setData(pieChartData);
            piechart.getData().get(0).getNode().setStyle("-fx-pie-color: #412d17 ");
            piechart.getData().get(1).getNode().setStyle("-fx-pie-color: #1c378f ");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(piechart);

        CRUDPane1.getChildren().add(stackPane);
        StackPane.setAlignment(stackPane, Pos.CENTER);
    }
}
