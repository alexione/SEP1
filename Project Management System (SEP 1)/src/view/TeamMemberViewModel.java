package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TeamMember;

public class TeamMemberViewModel
{
  private StringProperty firstNameProperty;
  private StringProperty lastNameProperty;
  private StringProperty roleProperty;
  private IntegerProperty taskProperty;
  private IntegerProperty regTime;

  public TeamMemberViewModel(TeamMember teamMember)
  {
    this.firstNameProperty = new SimpleStringProperty(teamMember.getFirstName());
    this.lastNameProperty = new SimpleStringProperty(teamMember.getLastName());
    this.roleProperty = new SimpleStringProperty(teamMember.getRole());
    this.taskProperty = new SimpleIntegerProperty(teamMember.getGivenTask().getTaskID());
    this.regTime = new SimpleIntegerProperty(teamMember.getRegisterTime().getHours()*60+teamMember.getRegisterTime().getMinutes());
  }

  public StringProperty getFirstNameProperty(){return firstNameProperty;}
  public StringProperty getLastNameProperty(){return lastNameProperty;}
  public StringProperty getRoleProperty(){return roleProperty;}
  public IntegerProperty getTaskProperty(){return taskProperty;}
  public IntegerProperty getRegTime(){return regTime;}
}
