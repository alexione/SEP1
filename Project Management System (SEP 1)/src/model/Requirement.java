package model;

public class Requirement
{
  private int ID;
  private String name;
  private String status;
  private String description;
  private MyDate deadline;
  private TaskList tasks;
  private Time estimateTime;
  private RegisterTime spentTime;
  private TeamMember responsibleTM;
  private Team team;
  public Requirement(int ID, String name, MyDate deadline){
    this.ID = ID;
    setName(name);
    setDeadline(deadline);
    setEstimateTime(new Time(0));
    this.status="Waiting";
    this.description=null;
    this.tasks=null;
    this.spentTime=null;
    this.responsibleTM=null;
    this.team=null;
    setCurrentDate();
  }
  public Requirement(int ID, String name, MyDate deadline, String description, Time estimateTime, TeamMember responsibleTM, TaskList tasks){
    this(ID,name, deadline, estimateTime, tasks);
    setDescription(description);
    setStatus("Started");
    setResponsibleTM(responsibleTM);
    setSpentTime(new RegisterTime(new Time(0)));
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime){
    this(ID, name, deadline);
    setEstimateTime(estimateTime);
    this.description=null;
    this.tasks=null;
    this.spentTime=null;
    this.responsibleTM=null;
    this.team=null;
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime, TaskList tasks){
    this(ID, name, deadline, estimateTime);
    this.description=null;
    setTasks(tasks);
    this.spentTime=null;
    this.responsibleTM=null;
    this.team=null;
  }
  public Requirement(int ID, String name, MyDate deadline, Time estimateTime, Team team, TaskList tasks){
    this(ID,name, deadline, estimateTime, tasks);
    this.status="Started";
    this.description=null;
    this.spentTime=null;
    this.responsibleTM=null;
    setResponsibleTeam(team);
  }
  public Requirement(int ID, String name, MyDate deadline, String description, Time estimateTime, Team team, TaskList tasks){
    this(ID,name, deadline, estimateTime, team, tasks);
    setStatus("Started");
    setSpentTime(null);
    setDescription(description);
  }
  public void removeResponsibleTeam(){this.team=null;}
  public void removeResponsibleTM(){
  this.responsibleTM=null;
}
  public TeamMember getResponsibleTM()
  {
    return responsibleTM;
  }
  public int getID()
  {
    return ID;
  }
  public Team getResponsibleTeam(){return team;}
  public String getName()
  {
    return name;
  }
  public TaskList getTasks()
  {
    return tasks;
  }
  public String getStatus()
  {
    return status;
  }
  public String getDescription()
  {
    return description;
  }
  public MyDate getDeadline()
  {
    return deadline;
  }
  public Time getEstimateTime()
  {
    return estimateTime;
  }
  public RegisterTime getSpentTime()
  {
    return spentTime;
  }
  public void setStatus(String status)
  {
    this.status = status;
  }
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline.copy();
  }
  public void setSpentTime(RegisterTime spentTime){
    this.spentTime = spentTime;
    if(this.spentTime.getTimeInSeconds()==this.getEstimateTime().getTimeInSeconds() && this.estimateTime.getTimeInSeconds()!=0)this.status="Finished";
    else this.status="Started";
  }
  public void setName(String name)
{
  this.name = name;
}
  public void setDescription(String description){
    this.description = description;
  }
  public void setCurrentDate()
  {
    MyDate currentDate = new MyDate();
  }
  public void setTasks(TaskList tasks)
  {
    this.tasks = tasks;
  }
  public void setEstimateTime(Time estimateTime){
    this.estimateTime = estimateTime;
  }
  public void setResponsibleTM(TeamMember responsibleTM){
  this.responsibleTM = responsibleTM;
  this.team=null;
}
  public void setResponsibleTeam(Team team){
    this.team = team;
    this.responsibleTM=null;
  }
  public String toString(){
    String returnString = "Name: " + getName();
    if (getDescription() != null)
      returnString += " Description: " + getDescription();
    returnString += " Status: " + getStatus();
    if (getSpentTime() != null)
      returnString += " Time spent: " + getSpentTime();
    if (getEstimateTime() != null)
      returnString += " Task's estimated time: " + getEstimateTime();
    if (getResponsibleTM() != null)
      returnString += " Team member assigned: " + getResponsibleTM();
    else if(getResponsibleTeam()!=null)returnString+=" Team assigned: " + getResponsibleTeam();
    return returnString;
  }
}
