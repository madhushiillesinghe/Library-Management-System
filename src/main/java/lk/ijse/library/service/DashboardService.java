package lk.ijse.library.service;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.SQLException;

public interface DashboardService extends SuperService{
    ObservableList<PieChart.Data> getUserDataForPieChart() ;

}
