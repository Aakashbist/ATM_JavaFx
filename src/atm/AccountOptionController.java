/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import model.State;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Enum.AccountTypes;
import model.AccountState;

/**
 * FXML Controller class
 *
 * @author OEM
 */
public class AccountOptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Label lblmessage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void clickSavingButton() throws IOException {
        State state = new State(AccountTypes.SAVING, new AccountState());
        Main.state = state;
        Main.setRoot("AtmOperation");
    }

    @FXML
    public void clickChequeButton() throws IOException {
        State state = new State(AccountTypes.CHEQUE, new AccountState());
        Main.state = state;
        Main.setRoot("AtmOperation");
    }

    @FXML
    public void clickNetSavingButton() throws IOException {
        State state = new State(AccountTypes.NETSAVING, new AccountState());
        Main.state = state;
        Main.setRoot("AtmOperation");
    }

    @FXML
    public void clickFixedButton() throws IOException {
        State state = new State(AccountTypes.FIXED, new AccountState());
        Main.state = state;
        Main.setRoot("AtmOperation");
    }

}
