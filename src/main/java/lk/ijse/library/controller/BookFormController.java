package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookFormController implements Initializable {
    @FXML
    public Pane addBookPaneId;
    @FXML
    private TextField txtSearch;
    @FXML
    private VBox vBoxBookManage;
    BookService bookService= (BookService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BOOK);
    private static BookFormController controller;
    public BookFormController(){
        controller=this;
    }
    public static BookFormController getInstance(){
        return controller;
    }

    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Navigation.popupPane("AddBookForm.fxml");

    }
    @FXML
    void btnSearchOnAction(ActionEvent event) throws IOException {
    List<Integer> bookDtoList=bookService.getAllBookName();
        System.out.println("book dto list "+bookDtoList);

        for(int i=0;i<bookDtoList.size();i++){
            if(txtSearch.getText().equalsIgnoreCase(String.valueOf(bookDtoList.get(i)))){
                ViewBookFormController.id= Integer.parseInt((txtSearch.getText()));
                Navigation.popupPane("viewBookForm.fxml");
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getAllIds();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void getAllIds() {
        vBoxBookManage.getChildren();
        List<BookDto> bookList=null;
        bookList=bookService.getAllBookId();
        for(int i=0;i<bookList.size();i++){
            loadTableData(bookList.get(i).getId());
        }
    }

    private void loadTableData(int id) {
        try{
            FXMLLoader loader=new FXMLLoader(BookFormController.class.getResource("/view/BookBarForm.fxml"));
            Parent root=loader.load();
            BookBarFormController controller=loader.getController();
            controller.setData(id);
            vBoxBookManage.getChildren().add(root);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
