/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.IOException;
import model.SavingAccountState;
import model.State;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Account;
import model.AccountState;
import model.NetSaving;
import model.Saving;

/**
 * FXML Controller class
 *
 * @author OEM
 */
public class AtmOperationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnWithdraw;

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnCheckBalance;

    @FXML
    private Button btnSetLimit;
    @FXML
    private Button btnCheckLimit;
    @FXML
    private TextField txtAmount;
    @FXML
    private Label lblAccountBalance;
    @FXML
    private Label lblMessage;

    private Account account;
    @FXML
    private AnchorPane lblmessage;
    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        State state = Main.state;
 AccountState data = (AccountState) state.getiState();
        switch (state.getAccountTypes()) {
            case SAVING:
                account = new Saving();
                account.deposit(100);
                setAmount(account.getAccountBalance());
                break;
            case CHEQUE:
                account = new Saving();
                account.deposit(100);
                btnCheckLimit.setDisable(data.checkWithDrawalLimit);
                btnSetLimit.setDisable(data.canSetWithDrawalLimit);
                setAmount(account.getAccountBalance());
                break;
            case NETSAVING:
                account = new Saving();
                account.deposit(100);
                btnSetLimit.setDisable(data.canSetWithDrawalLimit);
                setAmount(account.getAccountBalance());
                break;
            case FIXED:
                // SavingAccountState data = (SavingAccountState) state.getiState();
                account = new Saving();
                account.deposit(100);
                 btnCheckLimit.setDisable(data.checkWithDrawalLimit);
                btnSetLimit.setDisable(data.canSetWithDrawalLimit);
                setAmount(account.getAccountBalance());
                break;
        }

    }

    private void setAmount(double amount) {

        lblAccountBalance.setText(Double.toString(amount));
    }

    @FXML
    public void withdraw() {
        try {
            String _amount = txtAmount.getText();
            if (!checkTextField()) {
                double amount = Double.parseDouble(_amount);
                if (account.withdraw(amount)) {
                    setAmount(account.getAccountBalance());
                    txtAmount.setText("");
                } else {
                    lblMessage.setText("Amount should be combination of 100 50 20 OR Check limit");
                }
            } else {
                lblMessage.setText("please enter amount");
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void deposit() {
        try {
           
            String _amount = txtAmount.getText();
            if (!checkTextField()) {
                double amount = Double.parseDouble(_amount);
                if (account.deposit(amount)) {
                    setAmount(account.getAccountBalance());
                    txtAmount.setText("");
                } else {
                    lblMessage.setText("Amount should be combination of 100 50 20");
                }
            } else {
                lblMessage.setText("please enter amount");
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void setLimit() {

        Saving saving = new Saving();
        try {
            if (!checkTextField()) {
                String _amount = txtAmount.getText();
                double amount = Double.parseDouble(_amount);
                saving.changeWithdralLimit(amount);
                lblMessage.setText("New daily limit for this account is " + Double.toString(saving.getDailyWithdrawalLimit()));
                txtAmount.setText("");

            } else {
                lblMessage.setText("please enter amount");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void CheckLimit() {
        NetSaving netSaving = new NetSaving();
        lblMessage.setText("Daily limit for this account is " + Double.toString(netSaving.getDailyWithdrawalLimit()));
    }

    @FXML
    public void checkbalance() {
        lblMessage.setText("Your total Balance is: " +account.getAccountBalance());
       
    }

    public boolean checkTextField() {
        return txtAmount.getText().trim().isEmpty();
    }

    @FXML
    public void goBack() throws IOException {
        Main.setRoot("AccountOption");
    }
    
    @FXML
     public void processButtonText(ActionEvent event){         
           String value=((Button)event.getSource()).getText();
           txtAmount.setText(txtAmount.getText()+value);
       }
     
    @FXML
     public void clearButton(ActionEvent event) {
           txtAmount.clear();
    }
    @FXML
     public void logout() throws IOException
     {
           Main.setRoot("Login");
     }
}
