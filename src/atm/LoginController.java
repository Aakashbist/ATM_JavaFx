package atm;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ATM;
import model.MockCustomerFactory;

public class LoginController implements Initializable {

    @FXML
    private TextField txtCustomerId;

    @FXML
    private PasswordField txtPin;

    private TextField focusedfield;

    @FXML
    private Label lblmessage;

    @FXML
    private Button btnClose;

    private MockCustomerFactory customerFactory = new MockCustomerFactory();
    private ATM atm = new ATM(customerFactory);
    
    
   

    @FXML
    public void login(ActionEvent event) throws IOException {

        if (atm.logIn(Integer.parseInt(txtPin.getText()), Integer.parseInt(txtCustomerId.getText()))) {

            Main.setRoot("AccountOption");
        } else {
            lblmessage.setText("Login unsuccessfull");
        }
    }

    @FXML
    public void processButtonText(ActionEvent event) {
     
        String value = ((Button) event.getSource()).getText();
        focusedfield.setText(focusedfield.getText() + value);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        focusedfield=txtCustomerId;
        txtCustomerId.setFocusTraversable(false);
        txtPin.setFocusTraversable(false);
    }

    @FXML
    public void clearButton(ActionEvent event) throws IOException {
        focusedfield.clear();

    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

   

    @FXML
    private void onPinTextClicked(javafx.scene.input.MouseEvent event) {
         focusedfield=txtPin;
    }

    @FXML
    private void onClientClick(javafx.scene.input.MouseEvent event) {
         focusedfield=txtCustomerId;
    }
}
