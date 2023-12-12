package common.ui;

public abstract class MVCController
<ModelType,
ViewType extends MVCView<ModelType, ?>,
ActionType>
extends SimpleController<ViewType, ActionType>
{
    protected ModelType model;

    public MVCController(ModelType model)
    {
        super();
        this.model = model;
    }

    public ModelType getCurrentModelState()
    {
        this.model = this.view.reflectIntoModel();
        return this.model;
    }
}