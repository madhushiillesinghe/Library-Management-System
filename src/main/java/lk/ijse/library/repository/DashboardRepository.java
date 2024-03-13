package lk.ijse.library.repository;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.hibernate.Session;

import java.sql.SQLException;

public interface DashboardRepository extends SuperRepository{
     ObservableList<PieChart.Data> getProductDataForPieChart();

    void setSession(Session session);

}
