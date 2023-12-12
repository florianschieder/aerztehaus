package app.ui;

import javax.swing.JOptionPane;

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
                JOptionPane.showMessageDialog(
                    this.view,
                    e.toString(),
                    "Patientenverwaltung - Fehler",
                    JOptionPane.ERROR_MESSAGE);
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