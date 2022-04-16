import model.ProjectModel;
import model.ProjectModelManager;

public class Main
{
  public static void main(String[] args)
  {
    ProjectModel model = new ProjectModelManager();
    ProjectConsoleView view = new ProjectConsoleView(model);
    view.start();
  }
}
