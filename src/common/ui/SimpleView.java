package common.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A simple abstract view based on Swing.
 *
 * @param <ControllerType> the controller which handles
 * the interactions with a simple view.
 */
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
    
    public void showErrorMessage(Exception e)
    {
    	JOptionPane.showMessageDialog(
            this,
            e.toString(),
            "Patientenverwaltung - Fehler",
            JOptionPane.ERROR_MESSAGE);
    }
}