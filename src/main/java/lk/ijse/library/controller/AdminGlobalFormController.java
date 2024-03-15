package lk.ijse.library.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.library.util.DateTimeUtil;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminGlobalFormController implements Initializable {
    @FXML
    public AnchorPane CRUDPane;
    @FXML
    public AnchorPane paneId;
    @FXML
    private Label txtdate;

    @FXML
    private Label txttime;
    private static AdminGlobalFormController controller;

    public AdminGlobalFormController(){
        controller=this;
    }

    public static AdminGlobalFormController getInstance() {
        return controller;
    }

    @FXML
    void addcustomer(MouseEvent event) {

    }
    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"BookForm.fxml");
    }

    @FXML
    void btnBrachesOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"BranchesForm.fxml");

    }
    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"DashboardForm.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("UserOrAdminForm.fxml",event);

    }
    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"UserForm.fxml");
    }
    @FXML
    void btnBorrowandReturnOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneId,"TransactionForm.fxml");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtdate.setText(DateTimeUtil.dateNow());
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txttime.setText(DateTimeUtil.timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        try {
            Navigation.switchPaging(paneId,"DashboardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
