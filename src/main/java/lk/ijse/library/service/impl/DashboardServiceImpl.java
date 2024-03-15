package lk.ijse.library.service.impl;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.DashboardRepository;
import lk.ijse.library.service.DashboardService;
import org.hibernate.Session;

public class DashboardServiceImpl implements DashboardService  {
    private Session session;
    private final DashboardRepository dashboardRepository;
        private static DashboardService dashboardService;

    public DashboardServiceImpl (){
        dashboardRepository= (DashboardRepository) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.DASHBOARD);
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
    @Override
    public ObservableList<PieChart.Data> getTransactionPieChart() {
        session= PropertiesConfig.getInstance().getSession();
        try{
            dashboardRepository.setSession(session);
            return  dashboardRepository.getTransactionData();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public Long bookCount() {
        session=PropertiesConfig.getInstance().getSession();
        try {
            dashboardRepository.setSession(session);
            return dashboardRepository.bookCount();
        }catch (Exception e){
            e.printStackTrace();
            return (long) -1;
        }
        finally {
            session.close();
        }
    }

    @Override
    public  Long branchCount() {
        session=PropertiesConfig.getInstance().getSession();
        try {
            dashboardRepository.setSession(session);
            return dashboardRepository.branchCount();
        }catch (Exception e){
            e.printStackTrace();
            return (long) -1;
        }
        finally {
            session.close();
        }
    }

    @Override
    public Long userCount() {
        session=PropertiesConfig.getInstance().getSession();
        try {
            dashboardRepository.setSession(session);
            return dashboardRepository.userCount();
        }catch (Exception e){
            e.printStackTrace();
            return (long) -1;
        }
        finally {
            session.close();
        }
    }
}
