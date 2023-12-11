package common.ui;

public abstract class Controller
<ModelType, ViewType extends View<ModelType, ?>, ActionType>
{
    private ViewType view;
    private ModelType model;

    public Controller()
    {
        this(null);
    }

    public Controller(ModelType model)
    {
        this.view = this.constructView();
        this.model = model;
    }

    protected abstract ViewType constructView();

    public abstract void performAction(ActionType action);

    public ModelType getCurrentModelState()
    {
        this.model = this.view.reflectIntoModel();
        return this.model;
    }

    public void run()
    {
        this.view.spawn();
    }
}