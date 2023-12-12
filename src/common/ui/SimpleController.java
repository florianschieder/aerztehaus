package common.ui;

public abstract class SimpleController
<ViewType extends SimpleView<?>, ActionType>
{
    protected ViewType view;

    public SimpleController()
    {
        this.view = this.constructView();
    }

    protected abstract ViewType constructView();

    public abstract void performAction(ActionType action);

    public void run()
    {
        this.view.spawn();
    }
}