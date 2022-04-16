package model;

public class ProjectModelManager implements ProjectModel
{
  private ProjectList projects;
  private Team team;
  private RequirementList requirements;
  private TaskList tasks;
  public ProjectModelManager(){
    projects = new ProjectList();
    team = new Team();
    requirements = new RequirementList();
    tasks = new TaskList();
  }

  // Projects //
  public ProjectList getProjectsList()
  {
    return projects;
  }
  public Project getProjectByID(int ID)
  {
    return projects.getProjectByID(ID);
  }
  public String getProjectByTitle(String title){
    return projects.getProjectByTitle(title);
  }
  public int getNumberOfProjects()
  {
    return projects.getAllProjects();
  }
  public void addProject(Project project)
  {
    projects.addProject(project);
  }
  public Project removeProjectByTitle(String title){
    return projects.removeProjectByTitle(title);
  }
  public void removeProjectByID(int ID)
  {
    projects.removeProjectByID(ID);
  }
  public String getProjectNameByID(int ID){
    return projects.getProjectNameByID(ID);
  }
  public String getProjectDescByID(int ID){
    return projects.getProjectDescByID(ID);
  }
  public Requirement getProjectRequirementByID(int ID, int reqID){
    return projects.getProjectRequirementByID(ID, reqID);
  }
  public TeamMember getProjectTeamMemberByID(int ID, int tmID){
    return projects.getProjectTeamMemberByID(ID, tmID);
  }
  public Task getProjectTaskByID(int ID, int taskID){
    return projects.getProjectTaskByID(ID, taskID);
  }
  public void editProjectNameByID(int ID, String title){
    projects.editProjectNameByID(ID, title);
  }
  public void editProjectDescByID(int ID, String description){
    projects.editProjectDescByID(ID, description);
  }

  // Requirements //
  public Requirement getReqByID(int ID)
  {
    return requirements.getReqByID(ID);
  }
  public Requirement getReqByIndex(int index){return requirements.getReqByIndex(index);}
  public int getNumberOfRequirements(){
    return requirements.getNumberOfRequirements();
  }
  public RequirementList getRequirementsList()
  {
    return requirements;
  }
  public void addRequirement(Requirement requirement){
    requirements.addRequirement(requirement);
  }
  public void removeRequirement(Requirement requirement){
    requirements.removeRequirement(requirement);
  }
  public Requirement removeRequirement(int ID){
    return requirements.removeRequirement(ID);
  }
  public String getReqNameByID(int ID){
    return requirements.getReqNameByID(ID);
  }
  public String getReqDescByID(int ID){
    return requirements.getReqDescByID(ID);
  }
  public MyDate getReqDeadlineByID(int ID){
    return requirements.getReqDeadlineByID(ID);
  }
  public String getReqStatusByID(int ID){
    return requirements.getReqStatusByID(ID);
  }
  public Time getReqEstimateTimeByID(int ID){
    return requirements.getReqEstimateTimeByID(ID);
  }
  public RegisterTime getReqSpentTimeByID(int ID){
    return requirements.getReqSpentTimeByID(ID);
  }
  public TeamMember getReqTeamMemberByID(int ID){
    return requirements.getReqTeamMemberByID(ID);
  }
  public void editReqNameByID(int ID, String name){
    requirements.editReqNameByID(ID, name);
  }
  public void editReqDescByID(int ID, String description){
    requirements.editReqDescByID(ID, description);
  }
  public void editReqDeadlineByID(int ID, MyDate deadline){
    requirements.editReqDeadlineByID(ID, deadline);
  }
  public void editReqStatusByID(int ID, String status){
    requirements.editReqStatusByID(ID, status);
  }
  public void editReqEstimateTimeByID(int ID, Time estimateTime){
    requirements.editReqEstimateTimeByID(ID, estimateTime);
  }
  public void editReqSpentTimeByID(int ID, RegisterTime registerTime){
    requirements.editReqSpentTimeByID(ID, registerTime);
  }
  public void editReqTeamMemberByID(int ID, TeamMember teamMember){
    requirements.editReqTeamMemberByID(ID, teamMember);
  }
  public void editReqTeamByID(int ID, Team team){
    requirements.editReqTeamByID(ID, team);
  }
  public void removeReqTeamMemberByID(int ID){
    requirements.removeReqTeamMemberByID(ID);
  }
  public void addTaskOnReqID(int ID, Task task){
    requirements.addTaskOnReqID(ID, task);
  }
  public Task getTaskOnReqID(int ID, int taskID){
    return requirements.getTaskOnReqID(ID, taskID);
  }
  public Task removeTaskOnReqID(int ID, int taskID){
    return requirements.removeTaskOnReqID(ID, taskID);
  }
  public void removeTaskOnReqID(int ID, Task task){
    requirements.removeTaskOnReqID(ID, task);
  }

  //Team//
  public Team getTeamList()
  {
    return team;
  }
  public TeamMember getTeamMemberByID(int ID){
    return team.getTeamMemberByID(ID);
  }
  public TeamMember getTeamMemberByFullName(String fullName){
    return team.getTeamMemberByFullName(fullName);
  }
  public int getNumberOfTeamMembers()
  {
    return team.getNumberOfTeamMembers();
  }
  public void addTeamMember(TeamMember teamMember){
    team.addTeamMember(teamMember);
  }
  public TeamMember removeTeamMember(int ID){
    return team.removeTeamMember(ID);
  }
  public void removeTeamMember(TeamMember teamMember){
    team.removeTeamMember(teamMember);
  }
  public String getTeamMemberNameByID(int ID){
    return team.getTeamMemberNameByID(ID);
  }
  public RegisterTime getTeamMemberSpentTimeByID(int ID){
    return team.getTeamMemberSpentTimeByID(ID);
  }
  public String getTeamMemberRoleByID(int ID){
    return team.getTeamMemberRoleByID(ID);
  }
  public Task getTeamMemberTaskByID(int ID){
    return team.getTeamMemberTaskByID(ID);
  }
  public void editTeamMemberNameByID(int ID, String name){
    team.editTeamMemberNameByID(ID, name);
  }
  public void editTeamSpentTimeByID(int ID, RegisterTime registerTime){
    team.editTeamSpentTimeByID(ID, registerTime);
  }
  public void removeTeamMemberRoleByID(int ID){
    team.removeTeamMemberRoleByID(ID);
  }
  public void removeTeamMemberTaskByID(int ID){
    team.removeTeamMemberTaskByID(ID);
  }
  public void setTeamMemberRoleByID(int ID, String role){
    team.setTeamMemberRoleByID(ID, role);
  }
  public void setTeamMemberTaskByID(int ID, Task task){
    team.setTeamMemberTaskByID(ID, task);
  }

  // Tasks //
  public TaskList getTaskList()
  {
    return tasks;
  }
  public Task getTaskByIndex(int index)
  {
    return tasks.getTaskByIndex(index);
  }
  public Task getTaskByID(int ID){return tasks.getTaskByID(ID);}
  public int getNumberOfTasks()
  {
    return tasks.getNumberOfTasks();
  }
  public void addTask(Task task)
  {
    tasks.addTask(task);
  }
  public Task removeTask(int ID)
  {
    return tasks.removeTask(ID);
  }
  public void removeTask(Task task){
    tasks.removeTask(task);
  }
  public String getTaskNameByID(int ID){
    return tasks.getTaskNameByID(ID);
  }
  public String getTaskDescByID(int ID){
    return tasks.getTaskDescByID(ID);
  }
  public String getTaskStatusByID(int ID){
    return tasks.getTaskStatusByID(ID);
  }
  public Time getTaskEstimateTimeByID(int ID){
    return tasks.getTaskEstimateTimeByID(ID);
  }
  public RegisterTime getTaskSpentTimeByID(int ID){
    return tasks.getTaskSpentTimeByID(ID);
  }
  public TeamMember getTaskTeamMemberByID(int ID){
    return tasks.getTaskTeamMemberByID(ID);
  }
  public void editTaskNameByID(int ID, String name){
    tasks.editTaskNameByID(ID, name);
  }
  public void editTaskDescByID(int ID, String description){
    tasks.editTaskDescByID(ID, description);
  }
  public void editTaskStatusByID(int ID, String status){
    tasks.editTaskStatusByID(ID, status);
  }
  public void editTaskEstimateTimeByID(int ID, Time estimateTime){
    tasks.editTaskEstimateTimeByID(ID, estimateTime);
  }
  public void editTaskSpentTimeByID(int ID, RegisterTime registerTime){
    tasks.editTaskSpentTimeByID(ID, registerTime);
  }
  public boolean isTaskAvailable(int ID){
    return tasks.getTaskByID(ID).isAvailable();
  }
  public void assignTM(int ID, TeamMember teamMember){
    tasks.assignTM(ID, teamMember);
  }
  public void removeTaskTeamMemberByID(int ID){
    tasks.removeTaskTeamMemberByID(ID);
  }
  public String getAvailableTasks(){
    return tasks.getAvailableTasks();
  }

  //To string//
  public String getTasks(){
    return tasks.toString();
  }
  public String getRequirements(){
    return requirements.toString();
  }
  public String getTeam(){
    return team.toString();
  }
  public String getProjects(){
    return projects.toString();
  }
}
