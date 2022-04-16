import model.*;
import model.ProjectModel;
import java.util.Scanner;

public class ProjectConsoleView
{
  public ProjectModel model;

  public ProjectConsoleView(ProjectModel model){this.model = model;}
  public void modifyTask(TaskList tasks){
      Scanner input = new Scanner(System.in);
      String taskName = "";
      String taskDesc = "";
      Time estimateTime = new Time(0);
      boolean loop = true;
      while (loop)
      {
        System.out.println(
            "Choose one of available options: {REMOVE}, {EDIT} or {ASSIGN}");
        String chosenOption = input.nextLine().toUpperCase();
        System.out
            .println("This is the current list of tasks: \n" + model.getTasks());
        System.out
            .println("Choose a task that you want to " + chosenOption);
        int chosenID = input.nextInt();
        input.nextLine();
        chosenID--;
        switch (chosenOption)
        {
          case "REMOVE":
            model.removeTask(chosenID);
            break;
          case "EDIT":
            System.out.println(
                "Choose what you want to edit {NAME}, {DESCRIPTION}, {STATUS}, {ESTIMATE TIME} or {SPENT TIME}");
            chosenOption = input.nextLine().toUpperCase();
            switch (chosenOption)
            {

              case "NAME":
                System.out.print("Insert new value for " + (chosenID + 1)
                    + " task's name: [STRING]");
                taskName = input.nextLine();
                model.editTaskNameByID(chosenID, taskName);
                break;
              case "DESCRIPTION":
                System.out.print("Insert new value for " + (chosenID + 1)
                    + " task's description: [STRING]");
                taskDesc = input.nextLine();
                model.editTaskDescByID(chosenID, taskDesc);
                break;
              case "STATUS":
                System.out.print("Insert new value for " + (chosenID + 1)
                    + " task's status: [STRING]");
                String taskStatus = input.nextLine();
                if (taskStatus.equals("Waiting") || taskStatus
                    .equals("Started") || taskStatus.equals("Finished"))
                  model.editTaskStatusByID(chosenID, taskStatus);
                else
                  System.out.println("Wrong status value. Try again");
                break;
              case "ESTIMATE TIME":
                estimateTime = new Time(0);
                System.out.print("Insert new values for " + (chosenID + 1)
                    + " task's estimate time:");
                System.out.println("Please input time in this format:");
                System.out.print("1. Input hours: ");
                int hours = input.nextInt();
                input.nextLine();
                System.out.print("2. Input minutes: ");
                int minutes = input.nextInt();
                input.nextLine();
                estimateTime.set(hours, minutes);
                model.editTaskEstimateTimeByID(chosenID, estimateTime);
                break;
              case "SPENT TIME":
                RegisterTime spentTime = new RegisterTime(new Time(0));
                System.out.println(
                    "Insert new values for " + (chosenID + 1)
                        + " task's time spent:");
                System.out.println("Please input time in this format:");
                System.out.print("1. Input hours spent: ");
                hours = input.nextInt();
                input.nextLine();
                System.out.print("2. Input minutes: ");
                minutes = input.nextInt();
                input.nextLine();
                spentTime.setHours(hours);
                spentTime.setMinutes(minutes);
                model.editTaskSpentTimeByID(chosenID, spentTime);
                break;
            }
            break;
          case "ASSIGN":
            if (model.getNumberOfTeamMembers() == 0)
              System.out.println(
                  "Warning! You need at least 1 team member in [Team] list to assign a team member to a task");
            else
            {
              System.out.println(
                  "This is the current list of team members:\n" + model.getTeam());
              System.out.println(
                  "Choose a team member to assign to task " + (chosenID
                      + 1));
              int choseTMID = input.nextInt();
              input.nextLine();
              model.assignTM(chosenID, model.getTeamMemberByID(choseTMID));
              System.out.println("Task assigned.");
            }
            break;
        }
        System.out.println("Are you done modifying tasks? Yes/No");
        String IO = input.nextLine();
        if (IO.equals("Yes"))
          loop = false;
      }
    }
  public void modifyRequirement(RequirementList requirements){
    Scanner input = new Scanner(System.in);
    String reqName="";
    String reqDesc = "";
    Time estimateTime = new Time(0);
    boolean loop = true;
    while (loop)
    {
      System.out.println(
          "Choose one of available options: {REMOVE}, {EDIT}, {ASSIGN}");
      String chosenOption = input.nextLine().toUpperCase();
      System.out
          .println("This is the current list of requirements: \n" + model.getRequirementsList());
      System.out
          .println("Choose a task that you want to " + chosenOption);
      int chosenID = input.nextInt();
      input.nextLine();
      chosenID--;
      switch (chosenOption)
      {
        case "REMOVE":
          model.removeRequirement(chosenID);
          break;
        case "EDIT":
          System.out.println(
              "Choose what you want to edit {NAME}, {DESCRIPTION}, {STATUS}, {ESTIMATE TIME}, {SPENT TIME}, {DEADLINE}, {TEAM}, {TASKS}");
          chosenOption = input.nextLine().toUpperCase();
          switch (chosenOption)
          {

            case "NAME":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " requirement's name: [STRING]");
              reqName = input.nextLine();
              model.editReqNameByID(chosenID, reqName);
              break;
            case "DESCRIPTION":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " requirement's description: [STRING]");
              reqDesc = input.nextLine();
              model.editReqDescByID(chosenID, reqDesc);
              break;
            case "STATUS":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " requirement's status: [STRING]");
              String reqStatus = input.nextLine();
              if (reqStatus.equals("Waiting") || reqStatus
                  .equals("Started") || reqStatus.equals("Finished"))
                model.editReqStatusByID(chosenID, reqStatus);
              else
                System.out.println("Wrong status value. Try again");
              break;
            case "ESTIMATE TIME":
              estimateTime = new Time(0);
              System.out.print("Insert new values for " + (chosenID + 1)
                  + " requirement's estimate time:");
              System.out.println("Please input time in this format:");
              System.out.print("1. Input hours: ");
              int hours = input.nextInt();
              input.nextLine();
              System.out.print("2. Input minutes: ");
              int minutes = input.nextInt();
              input.nextLine();
              estimateTime.set(hours, minutes);
              model.editReqEstimateTimeByID(chosenID, estimateTime);
              break;
            case "SPENT TIME":
              RegisterTime spentTime = new RegisterTime(new Time(0));
              System.out.println(
                  "Insert new values for " + (chosenID + 1)
                      + " requirement's time spent:");
              System.out.println("Please input time in this format:");
              System.out.print("1. Input hours spent: ");
              hours = input.nextInt();
              input.nextLine();
              System.out.print("2. Input minutes: ");
              minutes = input.nextInt();
              input.nextLine();
              spentTime.setHours(hours);
              spentTime.setMinutes(minutes);
              model.editReqSpentTimeByID(chosenID, spentTime);
              break;
            case "DEADLINE":
              MyDate deadline = new MyDate();
              System.out.println("Insert new values for " + (chosenID + 1) + "requirement's deadline: \nPlease input date in this format:");
              System.out.print("1. Day: ");
              int day = input.nextInt();
              input.nextLine();
              deadline.setDay(day);
              System.out
                  .print("2. Month (if you want to insert month name type 0: ");
              int month = input.nextInt();
              input.nextLine();
              if (month == 0)
              {
                String monthString = input.nextLine();
                deadline.setMonth(monthString);
              }
              else
                deadline.setMonth(month);
              System.out.print("3. Year: ");
              int year = input.nextInt();
              input.nextLine();
              deadline.setYear(year);
              model.editReqDeadlineByID(chosenID, deadline);
              break;
            case "TEAM":
              System.out.println("Currently this application runs only with 1 team. Apologies");
              break;
            case "TASKS":
              if(model.getReqByID(chosenID).getTasks()==null)
                System.out.println("This requirement has no tasks to show");
              else
                modifyTask(model.getReqByID(chosenID).getTasks());
          }
        case "ASSIGN":
          if (model.getNumberOfTeamMembers() == 0)
            System.out.println(
                "Warning! You need at least 1 team member in [Team] list to assign a team member to a requirement");
          else
          {
            System.out.println(
                "This is the current list of team members:\n" + model.getTeam());
            System.out.println(
                "Do you want to assign your whole team to this requirement? Yes/No");
            String IO = input.nextLine();
            if (IO.equals("Yes"))
              model.editReqTeamByID(chosenID, model.getTeamList());
            else
            {
              System.out.println(
                  "Choose a team member to assign to a requirement " + (chosenID
                      + 1));
              int choseTMID = input.nextInt();
              input.nextLine();
              model.editReqTeamMemberByID(chosenID, model.getTeamMemberByID(choseTMID));
              System.out.println("Requirement assigned.");
            }
          }
          break;
      }
      System.out.println("Are you done modifying requirements? Yes/No");
      String IO = input.nextLine();
      if (IO.equals("Yes"))
        loop = false;
    }
  }
  public void modifyTeam(Team team){
    Scanner input = new Scanner(System.in);
    String firstName = "";
    String lastName = "";
    String role = "";
    boolean loop = true;
    while (loop)
    {
      System.out.println("Choose one of available options: {REMOVE}, {EDIT}");
      String chosenOption = input.nextLine().toUpperCase();
      System.out.println("This is the current list of team members: \n" + model.getTeam());
      System.out
          .println("Choose a team member that you want to " + chosenOption);
      int chosenID = input.nextInt();
      input.nextLine();
      chosenID--;
      switch (chosenOption)
      {
        case "REMOVE":
          model.removeTeamMember(chosenID);
          break;
        case "EDIT":
          System.out.println(
              "Choose what you want to edit {NAME}, {ROLE}, {TASK} or {REGISTER TIME}");
          chosenOption = input.nextLine().toUpperCase();
          switch (chosenOption)
          {
            case "NAME":
              System.out.print("Insert new values for " + (chosenID + 1)
                  + " team member's name: [STRING]");
              System.out.print("Insert first name: ");
              firstName = input.nextLine();
              System.out.print("Insert last name: ");
              lastName = input.nextLine();
              model.editTeamMemberNameByID(chosenID, (firstName + " " + lastName));
              break;
            case "ROLE":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " team member's role: [STRING]");
              role = input.nextLine();
              model.setTeamMemberRoleByID(chosenID, role);
              break;
            case "TASK":
              System.out.println(
                  "This is the list of current available tasks: " + model.getAvailableTasks());
              System.out.println(
                  "Choose a [int] value for tasks you want to assign to " + (
                      chosenID + 1) + " team member");
              int chosenAvTaskID = input.nextInt();
              input.nextLine();
              model.setTeamMemberTaskByID(chosenID, model.getTaskByID(chosenAvTaskID));
              break;
            case "REGISTER TIME":
              System.out.println("Insert ne value for " + (chosenID + 1) + " team member's registered time");
              RegisterTime spentTime = new RegisterTime(new Time(0));
              System.out.println("Please input time in this format:");
              System.out.print("1. Input hours spent: ");
              int hours = input.nextInt();
              input.nextLine();
              System.out.print("2. Input minutes: ");
              int minutes = input.nextInt();
              input.nextLine();
              spentTime.setHours(hours);
              spentTime.setMinutes(minutes);
              model.editTeamSpentTimeByID(chosenID, spentTime);
              break;
          }
          break;
      }
      System.out.println("Are you done modifying team members? Yes/No");
      String IO = input.nextLine();
      if (IO.equals("Yes"))
        loop = false;
    }
  }
  private void modifyProjects(ProjectList projectsList) {
    Scanner input = new Scanner(System.in);
    String projectName = "";
    String projectDesc = "";
    boolean loop = true;
    while (loop)
    {
      System.out.println(
          "Choose one of available options: {REMOVE} or {EDIT}");
      String chosenOption = input.nextLine().toUpperCase();
      System.out
          .println("This is the current list of projects: \n" + model.getProjectsList());
      System.out
          .println("Choose a project that you want to " + chosenOption);
      int chosenID = input.nextInt();
      input.nextLine();
      chosenID--;
      switch (chosenOption)
      {
        case "REMOVE":
          model.removeRequirement(chosenID);
          break;
        case "EDIT":
          System.out.println(
              "Choose what you want to edit {NAME}, {DESCRIPTION}, {REQUIREMENTS}, {TEAM} or {TASKS}");
          chosenOption = input.nextLine().toUpperCase();
          switch (chosenOption)
          {

            case "NAME":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " project's name: [STRING]");
              projectName = input.nextLine();
              model.editProjectNameByID(chosenID, projectName);
              break;
            case "DESCRIPTION":
              System.out.print("Insert new value for " + (chosenID + 1)
                  + " project's description: [STRING]");
              projectDesc = input.nextLine();
              model.editProjectDescByID(chosenID, projectDesc);
              break;
            case "REQUIREMENTS":
              if(model.getProjectByID(chosenID).getRequirements()==null)
                System.out.println("This project has no requirements to show");
              else
                modifyRequirement(model.getRequirementsList());
              break;
            case "TEAM":
              if(model.getProjectByID(chosenID).getTeam()==null)
                System.out.println("This project has no team to show");
              else
                modifyTeam(model.getTeamList());
              break;
            case "TASKS":
              if(model.getProjectByID(chosenID).getTasks()==null)
                System.out.println("This project has no tasks to show");
              else
                modifyTask(model.getTaskList());
              break;
          }
          break;
      }
      System.out.println("Are you done modifying projects? Yes/No");
      String IO = input.nextLine();
      if (IO.equals("Yes"))
        loop = false;
    }
  }
  public void start()
  {
    Scanner input = new Scanner(System.in);
    boolean running = true;
    while(running)
    {
      System.out.println("------------------");
      System.out.println("Navigation menu:");
      System.out.println("|1| Add a Task ");
      System.out.println("|2| Add a Requirement");
      System.out.println("|3| Add a Team Member");
      System.out.println("|4| Add a Project");
      System.out.println("|5| Modify tasks");
      System.out.println("|6| Modify requirements");
      System.out.println("|7| Modify team members");
      System.out.println("|8| Modify projects");
      System.out.println("|9| Show Tasks");
      System.out.println("|10| Show Team");
      System.out.println("|11| Show Requirements");
      System.out.println("|12| Show Projects");
      System.out.println("|13| END");
      System.out.println("------------------");

      System.out.println("Enter choice: ");
      int choice = input.nextInt();
      input.nextLine();
      switch (choice)
      {
        case 1:
        {
          String taskName = "";
          String taskDesc = "";
          Time estimateTime = new Time(0);
          TeamMember teamMember = new TeamMember("No", "Name");
          Task task1 = new Task(1,taskName, taskDesc);
          System.out.println(
              "In order to add a task you need at least:\n1.Task Name\n2.Task Description");
          System.out.print("Insert task name: ");
          taskName = input.nextLine();
          System.out.print("Insert task desc: ");
          taskDesc = input.nextLine();
          boolean loop = true;
          while (loop)
          {
            System.out.println(
                "If you please to add more values to your task, state so by pressing 1 or 0 to exit");
            int btnPress = input.nextInt();
            input.nextLine();
            if (btnPress == 1)
            {
              System.out
                  .println("Do you want estimate time to your Task?: Yes/No");
              String IO = input.nextLine();
              if (IO.equals("Yes"))
              {
                System.out.println("Please input time in this format:");
                System.out.print("1. Input hours: ");
                int hours = input.nextInt();
                input.nextLine();
                System.out.print("2. Input minutes: ");
                int minutes = input.nextInt();
                input.nextLine();
                estimateTime.set(hours, minutes);
                System.out.println(estimateTime + " has been added.");
                task1.setEstimateTime(estimateTime);
              }
              else
                break;
              System.out.println(
                  "Do you want to assign team member to your Task?: Yes/No");
              IO = input.nextLine();
              if (IO.equals("Yes"))
              {
                String role = "";
                System.out.println("Please names in this format:");
                System.out.print("1. Input first name: ");
                String firstName = input.nextLine();
                System.out.print("2. Input last name: ");
                String lastName = input.nextLine();
                System.out.println(
                    "\nDo you want to place a role for your team member?: Yes/No");
                String IO2 = input.nextLine();
                if (IO2.equals("Yes"))
                {
                  System.out.print("Input [String] value for role: ");
                  role = input.nextLine();
                  teamMember.setFirstName(firstName);
                  teamMember.setLastName(lastName);
                  teamMember.setRole(role);
                  task1.setTeamMember(teamMember);
                  System.out.println(teamMember + " has been added");
                  loop = false;
                }
                else
                {
                  teamMember.setFirstName(firstName);
                  teamMember.setLastName(lastName);
                  task1.setTeamMember(teamMember);
                  System.out.println(teamMember + " has been added");
                  break;
                }
              }
              else
              {
                loop = false;
              }
            }
            else
              loop = false;
          }
          task1.setName(taskName);
          task1.setDescription(taskDesc);
          System.out.println(task1 + " has been added");
          model.addTask(task1);
          break;
        }
        case 2:
        {
          String reqName = "";
          String reqDesc = "";
          MyDate deadline = new MyDate();
          Time estimateTimeReq = new Time(0);
          TeamMember teamMemberReq = new TeamMember("No", "Name");
          Requirement requirement1 = new Requirement(1,reqName, deadline,
              estimateTimeReq);
          System.out.println(
              "In order to add a requirement you need at least:\n1.Requirement Name\n2.Requirement Deadline\n3.Estimate Time for Requirement");
          System.out.print("Insert Requirement name: ");
          reqName = input.nextLine();
          System.out
              .println("Insert requirement deadline in the stated format:");
          System.out.print("1. Day: ");
          int day = input.nextInt();
          input.nextLine();
          deadline.setDay(day);
          System.out
              .print("2. Month (if you want to insert month name type 0: ");
          int month = input.nextInt();
          input.nextLine();
          if (month == 0)
          {
            String monthString = input.nextLine();
            deadline.setMonth(monthString);
          }
          else
            deadline.setMonth(month);
          System.out.print("3. Year: ");
          int year = input.nextInt();
          input.nextLine();
          deadline.setYear(year);
          requirement1.setDeadline(deadline);
          System.out.println(
              "Insert estimate time for requirement in the stated format:");
          System.out.print("1. Input hours: ");
          int hours = input.nextInt();
          input.nextLine();
          System.out.print("2. Input minutes: ");
          int minutes = input.nextInt();
          input.nextLine();
          estimateTimeReq.set(hours, minutes);
          requirement1.setEstimateTime(estimateTimeReq);
          boolean loopReq = true;
          while (loopReq)
          {
            System.out.println(
                "If you please to add more values to your requirement, state so by pressing 1 or 0 to exit");
            int btnPress = input.nextInt();
            input.nextLine();
            if (btnPress == 1)
            {
              System.out.println(
                  "Do you want description to your Requirement?: Yes/No");
              String IO = input.nextLine();
              if (IO.equals("Yes"))
              {
                System.out.println(
                    "Please input description in the stated format [String]:");
                reqDesc = input.nextLine();
                requirement1.setDescription(reqDesc);
              }
              System.out.println(
                  "Do you want to assign team member to your Requirement?: Yes/No");
              IO = input.nextLine();
              if (IO.equals("Yes"))
              {
                String role = "";
                System.out.println("Please names in this format:");
                System.out.print("1. Input first name: ");
                String firstName = input.nextLine();
                System.out.print("2. Input last name: ");
                String lastName = input.nextLine();
                System.out.println(
                    "\nDo you want to place a role for your team member?: Yes/No");
                String IO2 = input.nextLine();
                if (IO2.equals("Yes"))
                {
                  System.out.print("Input [String] value for role: ");
                  role = input.nextLine();
                  teamMemberReq.setFirstName(firstName);
                  teamMemberReq.setLastName(lastName);
                  teamMemberReq.setRole(role);
                  requirement1.setResponsibleTM(teamMemberReq);
                  requirement1.setStatus("Started");
                  System.out.println(teamMemberReq + " has been added");
                }
                else
                {
                  teamMemberReq.setFirstName(firstName);
                  teamMemberReq.setLastName(lastName);
                  requirement1.setResponsibleTM(teamMemberReq);
                  requirement1.setStatus("Started");
                  System.out.println(teamMemberReq + " has been added");

                }
              }
              else
              {
                System.out.println(
                    "Do you want to assign team to your Requirement?: Yes/No");
                IO = input.nextLine();

                if (IO.equals("Yes"))
                {
                  requirement1.setResponsibleTeam(model.getTeamList());
                  requirement1.setStatus("Started");
                }
                else
                  loopReq = false;
              }
            }
            else
              loopReq = false;
          }
          requirement1.setName(reqName);
          requirement1.setEstimateTime(estimateTimeReq);
          requirement1.setDeadline(deadline);
          System.out.println(requirement1 + " has been added");
          model.addRequirement(requirement1);
          break;
        }
        case 3:
        {
          TeamMember teamMember1 = new TeamMember("No", "Name");
          String role = "";
          System.out.println(
              "In order to add team member please insert names in this format:");
          System.out.print("1. Input first name: ");
          String firstName = input.nextLine();
          System.out.print("2. Input last name: ");
          String lastName = input.nextLine();
          System.out.println(
              "Do you want to place a role for your team member?: Yes/No");
          String IO2 = input.nextLine();
          if (IO2.equals("Yes"))
          {
            System.out.print("Input [String] value for role: ");
            role = input.nextLine();
            teamMember1.setFirstName(firstName);
            teamMember1.setLastName(lastName);
            teamMember1.setRole(role);
          }
          else
          {
            teamMember1.setFirstName(firstName);
            teamMember1.setLastName(lastName);
          }
          model.addTeamMember(teamMember1);
          System.out.println(teamMember1 + " has been added");
          break;
        }
        case 4:
        {
          if (model.getNumberOfRequirements() == 0)
            System.out.println(
                "Warning! You need to have at least 1 requirement in the list of requirement to create a project");
          else
          {
            System.out.println(
                "In order to create a project you need at least: \n1.Project name\n2.Requirement list (Already created) with 1 requirement (at least)");
            String projectName = "";
            String projectDesc = "";
            int custID = 1;
            System.out.print("Project name [String]: ");
            projectName = input.nextLine();
            Project project1 = new Project(projectName, custID, model.getRequirementsList());
            boolean loop2 = true;
            while (loop2)
            {
              System.out.println(
                  "If you please to add more values to your project, state so by pressing 1 or 0 to exit");
              int btnPress = input.nextInt();
              input.nextLine();
              if (btnPress == 1)
              {
                System.out
                    .println("Do you have a team for your project?: Yes/No");
                String IO = input.nextLine();
                if (IO.equals("Yes"))
                {
                  if (model.getNumberOfTeamMembers() == 0)
                    System.out.println(
                        "You need at least 1 team member in the team to add this team!");
                  else
                  {
                    project1.setTeam(model.getTeamList());
                    System.out
                        .println("Your team has been added to this project");
                  }
                }
                System.out.println(
                    "Do you have a list of tasks for you project model?: Yes/No");
                IO = input.nextLine();
                if (IO.equals("Yes"))
                {
                  if (model.getNumberOfTasks() == 0)
                    System.out.println(
                        "You need at least 1 task in the list of tasks in order to add this task list!");
                  else
                  {
                    project1.setTasks(model.getTaskList());
                    System.out.println(
                        "Your task list has been added to this project");
                  }
                }
                System.out.println(
                    "Do you want to add project description to your project?: Yes/No");
                IO = input.nextLine();
                if (IO.equals("Yes"))
                {
                  System.out.print(
                      "Please input project description in the stated format [String]: ");
                  projectDesc = input.nextLine();
                  project1.setDescription(projectDesc);
                }
                else
                  loop2 = false;
              }
              else
                loop2 = false;
            }
            model.addProject(project1);
            System.out
                .println(project1 + " has been added to the list of projects");
          }
          break;
        }
        case 5:
        {
          if (model.getNumberOfTasks() == 0)
            System.out.println(
                "Warning! You need to have at least 1 task in order to modify a task");
          else
          {
            modifyTask(model.getTaskList());
          }
          break;
        }
        case 6:
        {
          if (model.getNumberOfRequirements() == 0)
            System.out.println(
                "Warning! You need to have at least 1 requirement in order to modify a requirement");
          else
          {
            modifyRequirement(model.getRequirementsList());
          }
          break;
        }
        case 7:
        {
          if (model.getNumberOfTeamMembers() == 0)
            System.out.println(
                "Warning! You need to have at least 1 team member in order to modify a team member");
          else
          {
            modifyTeam(model.getTeamList());
          }
          break;
        }
        case 8:
        {
          if (model.getNumberOfProjects() == 0)
            System.out.println(
                "Warning! You need to have at least 1 project in order to modify a project");
          else
          {
            modifyProjects(model.getProjectsList());
          }
          break;
        }
        case 9:
          System.out.println(model.getTasks());
          break;
        case 10:
          System.out.println(model.getRequirementsList());
          break;
        case 11:
          System.out.println(model.getTeam());
          break;
        case 12:
          System.out.println(model.getProjects());
          break;
        case 13:
          running=false;
          break;
      }
    }
  }
}
