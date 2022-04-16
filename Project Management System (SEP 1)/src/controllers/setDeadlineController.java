package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.MyDate;
import model.ProjectModel;
import view.ViewHandler;

public class setDeadlineController {
  @FXML private TextField dayTextField;
  @FXML private TextField monthTextField;
  @FXML private TextField yearTextField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;

  public setDeadlineController(){}
  public void init(ViewHandler viewHandler,Region root,ProjectModel model){
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    reset();
  }
  public void reset(){
    dayTextField.setText("");
    monthTextField.setText("");
    yearTextField.setText("");
    errorLabel.setText("");
  }
  @FXML private void setButton(){
    MyDate deadline = new MyDate();
    deadline.set(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
    viewHandler.closeView();
  }
  @FXML private void cancelButton(){
    viewHandler.closeView();
  }
}
