package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ProjectModel;
import model.TeamMember;
import view.TeamMemberViewModel;
import view.TeamViewModel;
import view.ViewHandler;

import java.util.Optional;

public class TeamViewController
{
  @FXML private TableColumn<TeamMemberViewModel, String> firstNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> lastNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> roleColumn;
  @FXML private TableColumn<TeamMemberViewModel, Number> taskIDColumn;
  @FXML private TableColumn<TeamMemberViewModel, Number> spentTimeColumn;
  @FXML private TableView<TeamMemberViewModel> teamTable;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectModel model;
  private TeamViewModel view;
  public TeamViewController(){}
  public void init(ProjectModel model, Region root, ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.view = new TeamViewModel(model);
    firstNameColumn.setCellValueFactory(cellData-> cellData.getValue().getFirstNameProperty());
    lastNameColumn.setCellValueFactory(cellData-> cellData.getValue().getLastNameProperty());
    roleColumn.setCellValueFactory(cellData-> cellData.getValue().getRoleProperty());
    taskIDColumn.setCellValueFactory(cellData-> cellData.getValue().getTaskProperty());
    spentTimeColumn.setCellValueFactory(cellData-> cellData.getValue().getRegTime());
    teamTable.setItems(view.getList());
  }

  public Region getRoot()
  {
    return root;
  }
  public void reset()
  {
    view.update();
  }
  @FXML private void addMember(){
    viewHandler.openView("Add a team member");
  }
  @FXML private void assignMember(){
    viewHandler.openView("Assign a team member");
  }
  @FXML private void modifyMember(){
    viewHandler.openView("Modify a team member");
  }
  @FXML private void deleteMember(){
    errorLabel.setText("");
    try{
      TeamMemberViewModel selectedItem = teamTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();
      if (remove){
        TeamMember teamMember = new TeamMember(selectedItem.getFirstNameProperty().get(),selectedItem.getLastNameProperty().get());
        model.removeTeamMember(teamMember);
        view.removeTeamMember(teamMember);
        teamTable.getSelectionModel().clearSelection();
      }
    }catch (Exception e){
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }
  private boolean confirmation(){
    int index = teamTable.getSelectionModel().getSelectedIndex();
    TeamMemberViewModel selectedItem = teamTable.getItems().get(index);
    if (index < 0 || index >= teamTable.getItems().size()){
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing team member {" + selectedItem.getFirstNameProperty().get() + selectedItem.getLastNameProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
}
