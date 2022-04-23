package Gui;


import Client.Employee.EmployeeAdd;
import Client.Employee.EmployeeLogin;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField nameField;
    @FXML
    TextField idField;
    @FXML
    TextField postField;
    public void login(ActionEvent e){
        String name=nameField.getText();
        int id= Integer.parseInt(idField.getText());
        String post=postField.getText();
        EmployeeLogin empLogin=new EmployeeLogin();
        empLogin.Login(name,id,post);
    }
    public void Register(ActionEvent e){
        EmployeeAdd employeeRegister=new EmployeeAdd();
        employeeRegister.checkEmployee();
    }

}
