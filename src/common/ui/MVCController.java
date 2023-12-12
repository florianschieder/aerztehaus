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

    public ModelType getCurrentModelState() throws Exception
    {
        try {
            this.model = this.view.reflectIntoModel();
        }
        // tie app programmers to explicit error handling.
        catch (Exception ex) {
            throw ex;
        }
        return this.model;
    }
}