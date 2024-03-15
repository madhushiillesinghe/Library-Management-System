package lk.ijse.library.service;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface DashboardService extends SuperService{
    ObservableList<PieChart.Data> getUserDataForPieChart() ;
    ObservableList<PieChart.Data> getTransactionPieChart() ;
    Long bookCount();
    Long branchCount();
    Long userCount();

}
