package app.ui;

import app.core.Patient;
import common.ui.Controller;

public class AddPatientController
extends Controller<Patient, AddPatientView, AddPatientAction>
{
    public AddPatientController()
    {
        super();
    }

    public AddPatientController(Patient model)
    {
        super(model);
    }

    @Override
    public void performAction(AddPatientAction action)
    {
        switch (action) {
        case ADD_TO_DATABASE:
            Patient patient = this.getCurrentModelState();
            System.out.println("would insert new patient: " + patient);
            break;
        }
    }

    @Override
    protected AddPatientView constructView()
    {
        return new AddPatientView(this);
    }
}