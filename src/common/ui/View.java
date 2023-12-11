package common.ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class View
<ModelType,
ControllerType extends BaseController<?, ?, ?, ?>>
extends JFrame
{
    protected ControllerType controller;

    public View(ControllerType controller)
    {
        this.controller = controller;
        this.initializeControls();
        this.setUpListeners();
    }

    protected abstract void setUpListeners();
    protected abstract void initializeControls();

    public abstract void fillFromModel(ModelType model);
    public abstract ModelType reflectIntoModel();

    public void spawn()
    {
        this.setVisible(true);
    }
}