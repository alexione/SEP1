package model;

import java.util.ArrayList;

public class Project
{
  private String title;
  private String description;
  private Team team;
  private RequirementList requirements;
  private TaskList tasks;
  private int customerID;
  public Project(String title, int customerID, String description, RequirementList requirements, Team team){
    this(title, customerID, requirements);
    setDescription(description);
    setTeam(team);
  }
  public Project(String title, int customerID, String description, RequirementList requirements, Team team, TaskList tasks){
    this(title, customerID, requirements, team, tasks);
    setDescription(description);

  }
  public Project(String title, int customerID, RequirementList requirements, Team team, TaskList tasks){
    this(title, customerID, requirements, tasks);
    setTeam(team);
    setDescription(null);
  }
  public Project(String title, int customerID, RequirementList requirements){
    setTitle(title);
    setCustomerID(customerID);
    setRequirements(requirements);
    setTeam(null);
    setTasks(null);
    setDescription(null);
  }
  public Project(String title, int customerID, RequirementList requirements, TaskList tasks){
    this(title, customerID, requirements);
    setTasks(tasks);
  }
  public String getTitle()
  {
    return title;
  }
  public String getDescription()
  {
    return description;
  }
  public TaskList getTasks()
  {
    return tasks;
  }
  public RequirementList getRequirements()
  {
    return requirements;
  }
  public Team getTeam()
  {
    return team;
  }
  public void setTitle(String title)
  {
    this.title = title;
  }
  public void setDescription(String description){
    this.description = description;
  }
  public void setTeam(Team team)
  {
    this.team = team;
  }
  public void setTasks(TaskList tasks)
  {
    this.tasks = tasks;
  }
  public void setRequirements(RequirementList requirements){
    this.requirements = requirements;
  }
  public void setCustomerID(int ID){this.customerID=ID;}
  public String toString()
  {
    String returnString = "Title: " + getTitle();
    if(getDescription()!=null)returnString += " Description: " + getDescription();
    if(getTeam()!=null)returnString+=" Assigned team: " + getTeam().getNumberOfTeamMembers();
    if(getRequirements()!=null)returnString+=" Requirements: " + getRequirements().getNumberOfRequirements();
    if(getTasks()!=null)returnString+=" Tasks: " + getTasks().getNumberOfTasks();
    return returnString;
  }
}
