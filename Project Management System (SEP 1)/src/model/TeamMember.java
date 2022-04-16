package model;

public class TeamMember
{
  private String firstName;
  private String lastName;
  private String role;
  private Task givenTask;
  private RegisterTime registerTime;
  public TeamMember(String firstName, String lastName){
    setFirstName(firstName);
    setLastName(lastName);
    this.role = null;
    this.givenTask = null;
    this.registerTime = null;
  }
  public TeamMember(String firstName, String lastName, String role){
    this(firstName, lastName);
    setRole(role);
  }
  public TeamMember(String firstName, String lastName, String role, Task givenTask){
    this(firstName, lastName, role);
    setGivenTask(givenTask);
  }
  public TeamMember(String firstName, String lastName, String role, Task givenTask, RegisterTime registerTime){
    this(firstName, lastName, role, givenTask);
    setRegisterTime(registerTime);
  }
  public void setFullName(String fullName){
    int i=0;
    while(fullName.charAt(i)!=' ')
    {
      i++;
    }
    this.firstName = fullName.substring(0,i);
    this.lastName = fullName.substring(i);
  }
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
  public String getFullName(){return this.firstName+" "+this.lastName;}
  public String getFirstName()
  {
    return firstName;
  }
  public String getLastName()
  {
    return lastName;
  }
  public RegisterTime getRegisterTime()
  {
    return registerTime;
  }
  public void setRegisterTime(RegisterTime registerTime){
    this.registerTime = registerTime;
  }
  public void setRole(String role){this.role=role;}
  public void removeRole(){this.role=null;}
  public String getRole(){return role;}
  public void setGivenTask(Task task){
    if(task.isAvailable())
    this.givenTask = task;
    else this.givenTask=null;
  }
  public Task getGivenTask(){return givenTask;}
  public void removeGivenTask(){this.givenTask=null; }
  public String toString() {
  String returnString="Name: " + getFullName();
  if(getRole()!=null)returnString+=" Role: " + getRole();
  return returnString;}
}
