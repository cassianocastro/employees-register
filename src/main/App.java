package main;

import controller.EmployeesController;
import view.EmployeeIndexView;

/**
 *
 */
public class App
{

    public void start()
    {
        var controller = new EmployeesController();

        new EmployeeIndexView(controller);
    }
}