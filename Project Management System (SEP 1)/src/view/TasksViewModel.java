package view;

import javafx.beans.property.*;
import model.Task;

public class TasksViewModel
{
  private IntegerProperty idProperty;
  private StringProperty descProperty;
  private StringProperty statusProperty;
  private StringProperty resTeamMember;
  private IntegerProperty estTime;
  private IntegerProperty spentTime;

  public TasksViewModel(Task task)
  {
    this.idProperty = new SimpleIntegerProperty(task.getTaskID());
    this.descProperty = new SimpleStringProperty(task.getDescription());
    this.statusProperty = new SimpleStringProperty(task.getTaskStatus());
    this.resTeamMember = new SimpleStringProperty(task.getTeamMember().getFullName());
    this.estTime = new SimpleIntegerProperty(task.getEstimateTime().getHour()*60+task.getEstimateTime().getMinute());
    this.spentTime = new SimpleIntegerProperty(task.getTimeSpent().getHours()*60+task.getTimeSpent().getMinutes());
  }

  public IntegerProperty getIdProperty(){return idProperty;}
  public StringProperty getDescProperty(){return  descProperty;}
  public StringProperty getStatusProperty(){return statusProperty;}
  public StringProperty getResTeamMember(){return resTeamMember;}
  public IntegerProperty getEstTime(){return estTime;}
  public IntegerProperty getSpentTime(){return spentTime;}
}
