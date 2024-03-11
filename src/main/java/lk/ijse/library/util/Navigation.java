package lk.ijse.library.util;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import lk.ijse.library.controller.AdminGlobalFormController;
import lk.ijse.library.controller.BookFormController;
import lk.ijse.library.controller.UserGlobalFormController;
import lk.ijse.library.controller.UserProfileFormController;


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
        //stage.initStyle(StageStyle.UNDECORATED);
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
        AdminGlobalFormController.getInstance().CRUDPane.setVisible(true);
        switchPaging(AdminGlobalFormController.getInstance().CRUDPane, path);
    }
    public static void adminClosePane(){
        AdminGlobalFormController.getInstance().CRUDPane.getChildren().clear();
        AdminGlobalFormController.getInstance().CRUDPane.setVisible(false);
        //AdminGlobalFormController.getInstance().popupPane.setVisible(false);
    }
   public static void switchPagingUser(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        UserGlobalFormController.getInstance().paneId.setVisible(true);
       FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
       Parent root = loader.load();
        pane.getChildren().add(root);
    }
    public static void switchPagingUserProfile(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        //UserProfileFormController.getInstance().AnchorPaneId.setVisible(false);
        UserProfileFormController.getInstance().userPaneId.setVisible(true);
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public static void popupPaneUser(String path) throws IOException {
        UserGlobalFormController.getInstance().paneId.setVisible(true);
        UserGlobalFormController.getInstance().CRUDPane.setVisible(true);
        switchPaging(UserGlobalFormController.getInstance().CRUDPane, path);
    }
    public static void adminClosePaneUser(){
        UserGlobalFormController.getInstance().CRUDPane.getChildren().clear();
        UserGlobalFormController.getInstance().CRUDPane.setVisible(false);
        //AdminGlobalFormController.getInstance().popupPane.setVisible(false);
    }

}


