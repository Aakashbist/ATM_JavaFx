package atm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ATM;
import model.MockCustomerFactory;

public class LoginController implements Initializable {

    @FXML
    private PasswordField txtPin;

    @FXML
    private TextField txtCustomerId;
    @FXML
    private Label lblmessage;

    private MockCustomerFactory customerFactory = new MockCustomerFactory();
    private ATM atm = new ATM(customerFactory);

    public void login(ActionEvent event) throws IOException {
     
        if (atm.logIn(Integer.parseInt(txtPin.getText()), Integer.parseInt(txtCustomerId.getText()))) {
            lblmessage.setText("Login successfull");
            
            Main.setRoot("AccountOption");
        } else {
            lblmessage.setText("Login unsuccessfull");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      lblmessage.setText("Welcome please use clintId 100 or 101");
    }

  

}
