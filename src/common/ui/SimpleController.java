package common.ui;

/**
 * A simple UI controller handling user interactions.
 *
 * @param <ViewType> The view class.
 * @param <ActionType> Instances of that action represent
 * possible user interactions. Can e.g. be a enum representing
 * "user clicked close button", "user clicked button A", "user
 * typed a character into a text field" and so on.
 */
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