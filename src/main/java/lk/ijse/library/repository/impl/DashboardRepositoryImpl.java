package lk.ijse.library.repository.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.DashboardRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.ResultSet;

public class DashboardRepositoryImpl implements DashboardRepository {
    private Session session;
    private static DashboardRepositoryImpl dashboardRepository;
    public DashboardRepositoryImpl(){

    }

    @Override
    public ObservableList<PieChart.Data> getProductDataForPieChart() {
        ObservableList<PieChart.Data> piechartdata= FXCollections.observableArrayList();
        String JPQLqueryUser="SELECT COUNT(A.id) AS book_count FROM Book A";
        Query query=session.createQuery(JPQLqueryUser);
        Long userCount= (Long) query.uniqueResult();
        if(userCount>0){
            int subscriptiontotal= query.getFirstResult();
            piechartdata.add(new PieChart.Data("Book count",userCount));
        }
        String JPQLqueryBook="SELECT COUNT(A.id) AS total_transaction FROM Transaction A";
        Query queryuser=session.createQuery(JPQLqueryBook);
        Long bookCount= (Long) queryuser.uniqueResult();
        if(bookCount>0){
            int subscriptiontotal2= queryuser.getFirstResult();
            piechartdata.add(new PieChart.Data("Transaction count",bookCount));
        }
        return piechartdata;
    }
    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
