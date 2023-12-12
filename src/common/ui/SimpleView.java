package common.ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class SimpleView
<ControllerType extends SimpleController<?, ?>>
extends JFrame
{
    protected ControllerType controller;

    public SimpleView(ControllerType controller)
    {
        this.controller = controller;
        this.initializeControls();
        this.setUpListeners();
    }

    protected abstract void setUpListeners();
    protected abstract void initializeControls();

    public void spawn()
    {
        this.setVisible(true);
    }
}