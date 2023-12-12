package app.ui;

import app.App;
import common.ui.SimpleController;

public class HomeController
extends SimpleController<HomeView, HomeAction>
{
    private App app;

    public HomeController(App app)
    {
        this.app = app;
    }

    @Override
    protected HomeView constructView()
    {
        return new HomeView(this);
    }

    @Override
    public void performAction(HomeAction action)
    {
        switch (action) {
        case ADD_PATIENT:
            this.app.runAddPatientController();
            break;
        case EXPORT_RECORDS:
            throw new RuntimeException("gibts noch nicht.");
        case QUIT:
            System.exit(0);
            break;
        }

    }

}