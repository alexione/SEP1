package model;

import java.util.ArrayList;

public class Team
{
  private ArrayList<TeamMember> team;
  public Team()
  {
    this.team = new ArrayList<>();
  }
  public TeamMember getTeamMemberByID(int ID){return team.get(ID);}
  public TeamMember getTeamMemberByFullName(String fullName){
    for (int i = 0; i < team.size(); i++)
    {
      if(team.get(i).getFullName().equals(fullName))return team.get(i);
    }
    return null;
  }
  public int getNumberOfTeamMembers(){
    return team.size();
  }
  public void addTeamMember(TeamMember teamMember){
    team.add(teamMember);
  }
  public TeamMember removeTeamMember(int ID){return team.remove(ID);}
  public void removeTeamMember(TeamMember teamMember){team.remove(teamMember);}
  public String getTeamMemberNameByID(int ID){return team.get(ID).getFullName();}
  public RegisterTime getTeamMemberSpentTimeByID(int ID){return team.get(ID).getRegisterTime();}
  public String getTeamMemberRoleByID(int ID){return team.get(ID).getRole();}
  public Task getTeamMemberTaskByID(int ID){return team.get(ID).getGivenTask();}
  public void editTeamMemberNameByID(int ID, String name){team.get(ID).setFullName(name);}
  public void editTeamSpentTimeByID(int ID, RegisterTime registerTime){team.get(ID).setRegisterTime(registerTime);}
  public void removeTeamMemberRoleByID(int ID){team.get(ID).removeRole();}
  public void removeTeamMemberTaskByID(int ID){team.get(ID).removeGivenTask();}
  public void setTeamMemberRoleByID(int ID, String role){team.get(ID).setRole(role);}
  public void setTeamMemberTaskByID(int ID, Task task){
    if(task.isAvailable())
    team.get(ID).setGivenTask(task);
  }
  public String toString(){
    int counter=1;
    String returnString="";
    for(TeamMember teamMember : team)
    {
      returnString += counter + ") " + teamMember + "\n";
      counter++;
    }
    return returnString;
  }
}
