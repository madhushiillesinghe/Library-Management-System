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
    public static DashboardRepositoryImpl getInstance() {
        return null == dashboardRepository
                ? dashboardRepository = (DashboardRepositoryImpl) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.DASHBOARD)
                : dashboardRepository;
    }
    @Override
    public ObservableList<PieChart.Data> getProductDataForPieChart() {
        ObservableList<PieChart.Data> productdata= FXCollections.observableArrayList();
        String JPQLqueryUser="SELECT COUNT(A.Id) AS total_User_count FROM Users A";
        Query query=session.createQuery(JPQLqueryUser);
        Long userCount= (Long) query.uniqueResult();
        if(userCount>0){
            int subscriptiontotal= query.getFirstResult();
            productdata.add(new PieChart.Data("user count",subscriptiontotal));
        }
        String JPQLqueryBook="SELECT COUNT(A.id) AS total_Book_count FROM Book A";
        Query queryuser=session.createQuery(JPQLqueryBook);
        Long bookCount= (Long) queryuser.uniqueResult();
        if(bookCount>0){
            int subscriptiontotal2= queryuser.getFirstResult();
            productdata.add(new PieChart.Data("Book count",subscriptiontotal2));
        }
        return productdata;
    }
    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
