package lk.ijse.library.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.library.controller.AdminGlobalFormController;

import java.io.IOException;
import java.net.URL;

public class Navigation {

        private static Stage stage;
        private static Scene scene;
        private static Parent parent;

    public static void switchNavigation(String link, ActionEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + link));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void switchNavigation(String link, MouseEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + link));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void popupNavigation(String link) throws IOException {
        URL resource = Navigation.class.getResource("/view/" + link);
        Parent parent = FXMLLoader.load(resource);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }
    public static void close(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        AdminGlobalFormController.getInstance().paneId.setVisible(true);
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }
    public static void popupPane(String path) throws IOException {
        AdminGlobalFormController.getInstance().paneId.setVisible(true);
       // GlobalFormController.getInstance().CRUDPane.setVisible(true);
        //switchPaging(GlobalFormController.getInstance().CRUDPane, path);
    }
    public static void adminClosePane(){
       /* GlobalFormController.getInstance().CRUDPane.getChildren().clear();
        GlobalFormController.getInstance().CRUDPane.setVisible(false);*/
        //AdminGlobalFormController.getInstance().popupPane.setVisible(false);
    }
    public static void switchPagingManagerDashboard(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        AdminGlobalFormController.getInstance().paneId.setVisible(true);
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }
    public static void popupPaneManagerDashboard(String path) throws IOException {
        AdminGlobalFormController.getInstance().paneId.setVisible(true);
      //  ManagerGlobalFormController.getInstance().CRUDPane.setVisible(true);
      //  switchPaging(GlobalFormController.getInstance().CRUDPane, path);
    }
    public static void adminClosePaneManagerDashBoard(){
       // ManagerGlobalFormController.getInstance().CRUDPane.getChildren().clear();
       // ManagerGlobalFormController.getInstance().CRUDPane.setVisible(false);
        //AdminGlobalFormController.getInstance().popupPane.setVisible(false);
    }

}


