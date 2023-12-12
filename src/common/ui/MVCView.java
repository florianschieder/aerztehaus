package common.ui;

@SuppressWarnings("serial")
public abstract class MVCView
<ModelType, ControllerType extends MVCController<?, ?, ?>>
extends SimpleView<ControllerType>
{
    public MVCView(ControllerType controller)
    {
        super(controller);
    }

    @Override
    protected abstract void setUpListeners();
    @Override
    protected abstract void initializeControls();

    public abstract void fillFromModel(ModelType model);
    public abstract ModelType reflectIntoModel();

    @Override
    public void spawn()
    {
        this.setVisible(true);
    }
}