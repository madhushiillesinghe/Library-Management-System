package lk.ijse.library.service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.DashboardRepository;
import lk.ijse.library.repository.TransactionRepository;
import lk.ijse.library.repository.UserRepository;
import lk.ijse.library.repository.impl.DashboardRepositoryImpl;
import lk.ijse.library.repository.impl.TransactionRepositoryImpl;
import lk.ijse.library.repository.impl.UserRepositoryImpl;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.DashboardService;
import org.hibernate.Session;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DashboardServiceImpl implements DashboardService  {
    private Session session;
    private final DashboardRepository dashboardRepository;
        private static DashboardService dashboardService;

    public DashboardServiceImpl (){
        dashboardRepository= DashboardRepositoryImpl.getInstance();
    }
    public static DashboardService getInstance() {
        return null ==dashboardService
                ? dashboardService = (DashboardService) BoFactory.getBoFactory().getBo(BoFactory.BOType.DASHBOARD)
                : dashboardService;
    }


    @Override
    public ObservableList<PieChart.Data> getUserDataForPieChart() {
        session= PropertiesConfig.getInstance().getSession();
        try{
           dashboardRepository.setSession(session);
            return  dashboardRepository.getProductDataForPieChart();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
