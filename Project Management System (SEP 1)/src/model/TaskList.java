package model;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> tasks;
  public TaskList()
  {
    this.tasks = new ArrayList<>();
  }
  public Task getTaskByIndex(int index){return tasks.get(index);}
  public Task getTaskByID(int ID){
    for (int i = 0; i < tasks.size(); i++)
    {
      if(tasks.get(i).getTaskID()==ID)return tasks.get(i);
    }
    return null;
  }
  public int getNumberOfTasks(){return tasks.size();}
  public void addTask(Task task){tasks.add(task);}
  public Task removeTask(int ID){
    return tasks.remove(ID);}
  public void removeTask(Task task)
  {
    tasks.remove(task);
  }
  public String getTaskNameByID(int ID){return tasks.get(ID).getName();}
  public String getTaskDescByID(int ID){return tasks.get(ID).getDescription();}
  public String getTaskStatusByID(int ID){return tasks.get(ID).getTaskStatus();}
  public Time getTaskEstimateTimeByID(int ID){return tasks.get(ID).getEstimateTime();}
  public RegisterTime getTaskSpentTimeByID(int ID){return tasks.get(ID).getTimeSpent();}
  public TeamMember getTaskTeamMemberByID(int ID){return tasks.get(ID).getTeamMember();}
  public void editTaskNameByID(int ID, String name){tasks.get(ID).setName(name);}
  public void editTaskDescByID(int ID, String description){tasks.get(ID).setDescription(description);}
  public void editTaskStatusByID(int ID, String status){tasks.get(ID).setStatus(status);}
  public void editTaskEstimateTimeByID(int ID, Time estimateTime){tasks.get(ID).setEstimateTime(estimateTime);}
  public void editTaskSpentTimeByID(int ID, RegisterTime registerTime){tasks.get(ID).setSpentTime(registerTime);}
  public void assignTM(int ID, TeamMember teamMember){
    tasks.get(ID).setTeamMember(teamMember);
  }
  public void removeTaskTeamMemberByID(int ID){tasks.get(ID).removeTeamMember();}
  public boolean isTaskAvailable(int ID){return tasks.get(ID).isAvailable();}
  public String getAvailableTasks(){
    String returnString = "";
    for (int i = 0; i < tasks.size(); i++)
    {
      if(tasks.get(i).isAvailable())
      returnString += i + ") " + tasks.get(i) + "\n";
    }
    return returnString;
  }
  public String toString()
  {
    int counter=1;
    String returnString="";
    for(Task task : tasks)
    {
      returnString += counter + ") " + task + "\n";
      counter++;
    }
    return returnString;
  }
}
