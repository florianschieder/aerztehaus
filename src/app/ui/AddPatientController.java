package app.ui;

import app.core.Patient;
import common.db.repository.WriteRepository;
import common.ui.RepositoryController;

public class AddPatientController
extends RepositoryController
<Patient, AddPatientView, WriteRepository<Patient>, AddPatientAction>
{
    public AddPatientController(WriteRepository<Patient> repository)
    {
        super(repository);
    }

    public AddPatientController(Patient model, WriteRepository<Patient> repository)
    {
        super(model, repository);
    }

    @Override
    public void performAction(AddPatientAction action)
    {
        switch (action) {
        case ADD_TO_DATABASE:
            Patient patient = this.getCurrentModelState();
            System.out.println("would insert new patient: " + patient);
            this.repository.insert(patient);
            break;
        }
    }

    @Override
    protected AddPatientView constructView()
    {
        return new AddPatientView(this);
    }
}