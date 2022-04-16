package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ProjectModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ProjectModel model;

  public ViewHandler(ProjectModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("Project");
  }

  public void openView(String id)
  {
    Region root = null;

    switch (id)
    {
      case "Project":
        root = loadProjectView("Project.fxml");
        break;
      case "Add Project":
        root = loadAddProjectView("AddProject.fxml");
        break;
      case "Modify Project":
        root = loadModifyProjectView("ModifyProject.fxml");
        break;
      case "Add a requirement":
        root = loadAddRequirementView("AddRequirement.fxml");
        break;
      case "Add a task":
        root = loadAddTaskView("AddTask.fxml");
        break;
      case "Modify a task":
        root = loadModifyTaskView("ModifyTask.fxml");
        break;
      case "Set deadline":
        root = loadSetDeadlineView("setDeadline.fxml");
        break;
      case "Requirement":
        root = loadRequirementsView("Requirements.fxml");
        break;
      case "Tasks":
        root = loadTasksView("Tasks.fxml");
        break;
      case "Team":
        root = loadTeamView("Team.fxml");
        break;
      case "Add a team member":
        root = loadAddTeamMemberView("AddTeamMember.fxml");
        break;
      case "Assign a team member":
        root = loadAddTeamMemberView("AssignTM.fxml");
        break;
      case "Modify a team member":
        root = loadAddTeamMemberView("ModifyTeamMember.fxml");
        break;
      case "Modify a requirement":
        root = loadAddTeamMemberView("ModifyRequirement.fxml");
        break;
      case "Set spent time":
        root = loadRegisterTimeView("RegisterTime.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadModifyTaskView(String s)
  {
  }

  private Region loadRegisterTimeView(String s)
  {
  }

  private Region loadAddTeamMemberView(String s)
  {
  }

  private Region loadTeamView(String s)
  {
  }

  private Region loadTasksView(String s)
  {
  }

  private Region loadRequirementsView(String s)
  {
  }

  private Region loadSetDeadlineView(String s)
  {
  }

  private Region loadAddTaskView(String s)
  {
  }

  private Region loadAddRequirementView(String s)
  {
  }

  private Region loadModifyProjectView(String s)
  {
  }

  private Region loadAddProjectView(String s)
  {
  }

  private Region loadProjectView(String s)
  {
  }

  public void closeView()
  {
    primaryStage.close();
  }



}