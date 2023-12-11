package common.ui;

import common.db.repository.Repository;

public abstract class BaseController
<ModelType,
ViewType extends View<ModelType, ?>,
RepositoryType extends Repository<ModelType>,
ActionType>
{
    private ViewType view;
    private ModelType model;

    protected RepositoryType repository;

    public BaseController(RepositoryType repository)
    {
        this(null, repository);
    }

    public BaseController(ModelType model, RepositoryType repository)
    {
        this.view = this.constructView();
        this.model = model;
        this.repository = repository;
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