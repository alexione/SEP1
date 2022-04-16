package model;

import java.util.ArrayList;

public class RequirementList
{
  private ArrayList<Requirement> requirements;
  public RequirementList()
  {
    this.requirements = new ArrayList<>();
  }
  public Requirement getReqByID(int ID){
    for (int i = 0; i < getNumberOfRequirements(); i++)
    {
      if(requirements.get(i).getID()==ID)return requirements.get(i);
    }
    return null;
  }
  public Requirement getReqByIndex(int index){return requirements.get(index);}
  public int getNumberOfRequirements(){return requirements.size();}
  public void addRequirement(Requirement requirement){
    requirements.add(requirement);
  }
  public void removeRequirement(Requirement requirement){
    requirements.remove(requirement);
  }
  public Requirement removeRequirement(int ID){
    return requirements.remove(ID);
  }
  public String getReqNameByID(int ID){return requirements.get(ID).getName();}
  public String getReqDescByID(int ID){return requirements.get(ID).getDescription();}
  public MyDate getReqDeadlineByID(int ID){return requirements.get(ID).getDeadline();}
  public String getReqStatusByID(int ID){return requirements.get(ID).getStatus();}
  public Time getReqEstimateTimeByID(int ID){return requirements.get(ID).getEstimateTime();}
  public RegisterTime getReqSpentTimeByID(int ID){return requirements.get(ID).getSpentTime();}
  public TeamMember getReqTeamMemberByID(int ID){return requirements.get(ID).getResponsibleTM();}
  public void editReqNameByID(int ID, String name){requirements.get(ID).setName(name);}
  public void editReqDescByID(int ID, String description){requirements.get(ID).setDescription(description);}
  public void editReqDeadlineByID(int ID, MyDate deadline){requirements.get(ID).setDeadline(deadline);}
  public void editReqStatusByID(int ID, String status){requirements.get(ID).setStatus(status);}
  public void editReqEstimateTimeByID(int ID, Time estimateTime){requirements.get(ID).setEstimateTime(estimateTime);}
  public void editReqSpentTimeByID(int ID, RegisterTime registerTime){requirements.get(ID).setSpentTime(registerTime);}
  public void editReqTeamMemberByID(int ID, TeamMember teamMember){requirements.get(ID).setResponsibleTM(teamMember);}
  public void editReqTeamByID(int ID, Team team){requirements.get(ID).setResponsibleTeam(team);}
  public void removeReqTeamMemberByID(int ID){requirements.get(ID).removeResponsibleTM();}
  public void addTaskOnReqID(int ID, Task task){
    requirements.get(ID).getTasks().addTask(task);
  }
  public Task getTaskOnReqID(int ID, int taskID){return requirements.get(ID).getTasks()
      .getTaskByID(taskID);}
  public Task removeTaskOnReqID(int ID, int taskID){return requirements.get(ID).getTasks().removeTask(taskID);}
  public void removeTaskOnReqID(int ID, Task task){requirements.get(ID).getTasks().removeTask(task);}
  public String toString()
  {
    int counter=1;
    String returnString="";
    for(Requirement requirement : requirements)
    {
      returnString += counter + ") " + requirement + "\n";
      counter++;
    }
    return returnString;
  }
}
