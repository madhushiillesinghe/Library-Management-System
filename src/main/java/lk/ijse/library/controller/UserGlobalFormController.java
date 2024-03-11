package lk.ijse.library.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.library.util.DateTimeUtil;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserGlobalFormController implements Initializable {

    @FXML
    public AnchorPane CRUDPane;

    @FXML
    public AnchorPane paneId;

    @FXML
    private Label txtPassword;

    @FXML
    private Label txtUserName;

    @FXML
    private Label txtdate;

    @FXML
    private Label txttime;
   private static UserGlobalFormController controller;
   public UserGlobalFormController(){
       controller=this;
   }
   public static UserGlobalFormController getInstance(){
       return controller;
   }

    @FXML
    void addcustomer(MouseEvent event) {

    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        Navigation.switchPagingUser(paneId,"BookUserForm.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        Navigation.switchPagingUser(paneId,"UserDashBoardForm.fxml");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("UserOrAdminForm.fxml",event);
    }

    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Navigation.switchPagingUser(paneId,"UserProfileForm.fxml");
    }

    @FXML
    void btnBorrowandReturnOnAction(ActionEvent event) throws IOException {
        Navigation.switchPagingUser(paneId,"TransactionForm.fxml");

    }
    @FXML
    void btnchangepasswordOrUsername(ActionEvent event) throws IOException {
    Navigation.switchPagingUser(paneId,"UpdateUserProfileForm.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtdate.setText(DateTimeUtil.dateNow());
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txttime.setText(DateTimeUtil.timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        try {
            Navigation.switchPagingUser(paneId,"UserDashBoardForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
