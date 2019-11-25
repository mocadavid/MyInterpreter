package View;

import Controller.Controller;
import Model.exceptions.MyException;

public class RunExampleCommand extends Command {
    private Controller controller;
    public RunExampleCommand(String key, String description, Controller ctrl){ super(key,description); controller=ctrl; }
    @Override
    public void execute() {
        try{ controller.completeExecution(); }
        catch (MyException exception){ System.out.println(exception.getMessage()); }
    }
}
