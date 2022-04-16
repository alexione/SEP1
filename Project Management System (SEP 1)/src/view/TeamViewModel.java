package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectModel;
import model.TeamMember;

public class TeamViewModel
{
  private ProjectModel model;
  private ObservableList<TeamMemberViewModel> list;
  public TeamViewModel(ProjectModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public ObservableList<TeamMemberViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getNumberOfTeamMembers(); i++)
    {
      list.add(new TeamMemberViewModel(model.getTeamMemberByID(i)));
    }
  }
  public void addTeamMember(TeamMember teamMember){
    list.add(new TeamMemberViewModel(teamMember));
  }
  public void removeTeamMember(TeamMember teamMember){
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getFirstNameProperty().get().equals(teamMember.getFirstName()) &&
      list.get(i).getLastNameProperty().get().equals(teamMember.getLastName()) &&
      list.get(i).getRoleProperty().get().equals(teamMember.getRole()) &&
      list.get(i).getTaskProperty().get() == teamMember.getGivenTask().getTaskID() &&
      list.get(i).getRegTime().get() == (teamMember.getRegisterTime().getHours()*60+teamMember.getRegisterTime().getMinutes()))
      {
        list.remove(i);
        break;
      }
    }
  }
}
