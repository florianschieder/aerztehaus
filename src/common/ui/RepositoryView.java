package common.ui;

@SuppressWarnings("serial")
public abstract class RepositoryView
<ModelType,
ControllerType extends RepositoryController<?, ?, ?, ?>>
extends MVCView<ModelType, ControllerType>
{
    public RepositoryView(ControllerType controller)
    {
        super(controller);
    }

    @Override
    protected abstract void setUpListeners();
    @Override
    protected abstract void initializeControls();

    @Override
    public abstract void fillFromModel(ModelType model);
    @Override
    public abstract ModelType reflectIntoModel();

    @Override
    public void spawn()
    {
        this.setVisible(true);
    }
}