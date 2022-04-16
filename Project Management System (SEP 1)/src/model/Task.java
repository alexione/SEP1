package model;

public class Task
{
  private int taskID;
  private String name;
  private String taskStatus;
  private String taskDescription;
  private RegisterTime taskTimeSpent;
  private Time estimateTime;
  private TeamMember teamMember;
  public Task(int taskID, String taskDescription){
    setDescription(taskDescription);
    setName("No name");
    this.taskID=taskID;
    this.taskTimeSpent = null;
    this.teamMember = null;
    this.taskStatus = "Waiting";
  }
  public Task(int taskID, String name, String taskDescription, Time estimateTime, TeamMember teamMember){
    this(taskID, name, taskDescription, estimateTime);
    setSpentTime(null);
    setStatus("Waiting");
    setTeamMember(teamMember);
  }
  public Task(int taskID, String name, String taskDescription){
    this.taskID = taskID;
    setName(name);
    setDescription(taskDescription);
    setStatus("Waiting");
    setSpentTime(null);
    setEstimateTime(null);
    setTeamMember(null);
  }
  public Task(int taskID, String name, String taskDescription, Time estimateTime){
      this(taskID,name, taskDescription);
      setEstimateTime(estimateTime);
      setSpentTime(null);
      setStatus("Waiting");
      setTeamMember(null);
  }
  public Task(int taskID, String name, Time estimateTime){
    setName(name);
    setEstimateTime(estimateTime);
    this.taskID=taskID;
    this.taskTimeSpent = null;
    this.taskDescription = null;
    this.teamMember = null;
    this.taskStatus = "Waiting";
  }
  public Task(int taskID, String name, Time estimateTime, TeamMember teamMember){
    this(taskID,name, estimateTime);
    setTeamMember(teamMember);
    this.taskTimeSpent = null;
    this.taskDescription = null;
    this.taskStatus = "Waiting";
  }

  public int getTaskID()
  {
    return taskID;
  }
  public String getName(){return name;}
  public String getTaskStatus()
  {
    return taskStatus;
  }
  public RegisterTime getTimeSpent()
  {
    return taskTimeSpent;
  }
  public String getDescription()
  {
    return taskDescription;
  }
  public Time getEstimateTime()
  {
    return estimateTime;
  }
  public void setSpentTime(RegisterTime taskTimeSpent){
    this.taskTimeSpent = taskTimeSpent;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public void setDescription(String taskDescription){
    this.taskDescription = taskDescription;
  }
  public void setStatus(String taskStatus){
    try{
      if(taskStatus.equals("Waiting") || taskStatus.equals("Started") || taskStatus.equals("Finished"))
        this.taskStatus = taskStatus;
      else throw new Exception("Not a string");
    }
    catch (Exception e)
    {
      System.out.println("Please input STRING value{\"Waiting\",\"Started\" or \"Finished\"}");
    }
  }
  public void setEstimateTime(Time estimateTime){
    this.estimateTime = estimateTime;
  }
  public TeamMember getTeamMember()
{
  return teamMember;
}
  public void setTeamMember(TeamMember teamMember){
    this.teamMember = teamMember;
    if(teamMember!=null)
    this.taskStatus = "Started";
  }
  public boolean isAvailable()
  {
    return teamMember == null;
  }
  public void removeTeamMember(){
    this.teamMember = null;
    this.taskStatus = "Waiting";
  }
  public String toString(){
    String returnString = "Name: " + getName();
    if(getDescription()!=null)returnString += " Description: " + getDescription();
    returnString+=" Status: " + getTaskStatus();
    if(getTimeSpent()!=null)returnString+=" Time spent: " + getTimeSpent();
    if(getEstimateTime()!=null)returnString+=" Task's estimated time: " + getEstimateTime();
    if(getTeamMember()!=null)returnString+=" Team member assigned: " + getTeamMember();
    return returnString;
  }
}
