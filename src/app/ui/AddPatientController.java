package app.ui;

import javax.swing.JOptionPane;

import app.core.Patient;
import app.repository.PatientRepository;
import common.ui.MVCController;

public class AddPatientController
extends MVCController
<Patient, AddPatientView, AddPatientAction>
{
	private PatientRepository repository;
	

    public AddPatientController(PatientRepository repository)
    {
        super(null);
        this.repository = repository;
    }

    @Override
    public void performAction(AddPatientAction action)
    {
        switch (action) {
        case ADD_TO_DATABASE:
        	try {
	        	Patient patient = this.getCurrentModelState();
	            System.out.println("[DEBUG] would insert new patient: " + patient);
	            this.repository.insert(patient);
	            JOptionPane.showMessageDialog(
                    this.view,
                    String.format(
                        "Patient %s %s wurde eingefügt",
                        patient.getPrename(),
                        patient.getSurname()),
                    "Patientenverwaltung",
                    JOptionPane.INFORMATION_MESSAGE);
        	}
        	catch (Exception e) {
        		this.view.showErrorMessage(e);
        	}
            break;
        }
    }

    @Override
    protected AddPatientView constructView()
    {
        return new AddPatientView(this);
    }
}