package common.ui;

import common.db.repository.Repository;

public abstract class RepositoryController
<ModelType,
ViewType extends RepositoryView<ModelType, ?>,
RepositoryType extends Repository<ModelType>,
ActionType>
extends MVCController<ModelType, ViewType, ActionType>
{
    protected RepositoryType repository;

    public RepositoryController(RepositoryType repository)
    {
        this(null, repository);
    }

    public RepositoryController(ModelType model, RepositoryType repository)
    {
        super(model);
        this.repository = repository;
    }
}