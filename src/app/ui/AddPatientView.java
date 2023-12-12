package app.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.core.Patient;
import common.ui.RepositoryView;

@SuppressWarnings("serial")
public class AddPatientView
extends RepositoryView<Patient, AddPatientController>
{
    private JTextField prename;
    private JTextField surname;
    private JTextField street;
    private JTextField city;
    private JTextField patientId;
    private JTextField zipCode;
    private JButton btnNewButton;

    public AddPatientView(AddPatientController controller)
    {
        super(controller);
    }

    /**
     * Initialize the contents of the frame.
     */
    @Override
    protected void initializeControls()
    {
        this.setTitle("Patientenverwaltung");
        this.setBounds(100, 100, 450, 278);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        this.getContentPane().setLayout(gridBagLayout);

        JLabel prenameLabel = new JLabel("Vorname:");
        GridBagConstraints prenameLabelGBC = new GridBagConstraints();
        prenameLabelGBC.ipady = 5;
        prenameLabelGBC.ipadx = 5;
        prenameLabelGBC.anchor = GridBagConstraints.WEST;
        prenameLabelGBC.insets = new Insets(5, 5, 5, 5);
        prenameLabelGBC.gridx = 0;
        prenameLabelGBC.gridy = 0;
        this.getContentPane().add(prenameLabel, prenameLabelGBC);

        prename = new JTextField();
        GridBagConstraints prenameGBC = new GridBagConstraints();
        prenameGBC.insets = new Insets(5, 5, 5, 5);
        prenameGBC.fill = GridBagConstraints.HORIZONTAL;
        prenameGBC.gridx = 1;
        prenameGBC.gridy = 0;
        this.getContentPane().add(prename, prenameGBC);
        prename.setColumns(10);

        JLabel surnameLabel = new JLabel("Nachname:");
        GridBagConstraints surnameLabelGBC = new GridBagConstraints();
        surnameLabelGBC.anchor = GridBagConstraints.WEST;
        surnameLabelGBC.insets = new Insets(5, 5, 5, 5);
        surnameLabelGBC.gridx = 0;
        surnameLabelGBC.gridy = 1;
        this.getContentPane().add(surnameLabel, surnameLabelGBC);

        surname = new JTextField();
        GridBagConstraints surnameFieldGBC = new GridBagConstraints();
        surnameFieldGBC.insets = new Insets(5, 5, 5, 5);
        surnameFieldGBC.fill = GridBagConstraints.HORIZONTAL;
        surnameFieldGBC.gridx = 1;
        surnameFieldGBC.gridy = 1;
        this.getContentPane().add(surname, surnameFieldGBC);
        surname.setColumns(10);

        JLabel streetLabel = new JLabel("Straße:");
        GridBagConstraints streetLabelGBC = new GridBagConstraints();
        streetLabelGBC.insets = new Insets(5, 5, 5, 5);
        streetLabelGBC.anchor = GridBagConstraints.WEST;
        streetLabelGBC.gridx = 0;
        streetLabelGBC.gridy = 2;
        this.getContentPane().add(streetLabel, streetLabelGBC);

        street = new JTextField();
        GridBagConstraints streetGBC = new GridBagConstraints();
        streetGBC.insets = new Insets(5, 5, 5, 5);
        streetGBC.fill = GridBagConstraints.HORIZONTAL;
        streetGBC.gridx = 1;
        streetGBC.gridy = 2;
        this.getContentPane().add(street, streetGBC);
        street.setColumns(10);

        JLabel cityLabel = new JLabel("Ort:");
        GridBagConstraints cityLabelGBC = new GridBagConstraints();
        cityLabelGBC.anchor = GridBagConstraints.WEST;
        cityLabelGBC.insets = new Insets(5, 5, 5, 5);
        cityLabelGBC.gridx = 0;
        cityLabelGBC.gridy = 3;
        this.getContentPane().add(cityLabel, cityLabelGBC);

        city = new JTextField();
        GridBagConstraints cityGBC = new GridBagConstraints();
        cityGBC.insets = new Insets(5, 5, 5, 5);
        cityGBC.fill = GridBagConstraints.HORIZONTAL;
        cityGBC.gridx = 1;
        cityGBC.gridy = 3;
        this.getContentPane().add(city, cityGBC);
        city.setColumns(10);

        JLabel zipCodeLabel = new JLabel("PLZ: ");
        GridBagConstraints zipCodeLabelGBC = new GridBagConstraints();
        zipCodeLabelGBC.anchor = GridBagConstraints.WEST;
        zipCodeLabelGBC.insets = new Insets(5, 5, 5, 5);
        zipCodeLabelGBC.gridx = 3;
        zipCodeLabelGBC.gridy = 3;
        this.getContentPane().add(zipCodeLabel, zipCodeLabelGBC);

        zipCode = new JTextField();
        GridBagConstraints zipCodeGBC = new GridBagConstraints();
        zipCodeGBC.anchor = GridBagConstraints.EAST;
        zipCodeGBC.insets = new Insets(5, 5, 5, 5);
        zipCodeGBC.gridx = 4;
        zipCodeGBC.gridy = 3;
        this.getContentPane().add(zipCode, zipCodeGBC);
        zipCode.setColumns(10);

        JLabel patientIdLabel = new JLabel("Patientennummer:");
        GridBagConstraints patientIdLabelGBC = new GridBagConstraints();
        patientIdLabelGBC.anchor = GridBagConstraints.WEST;
        patientIdLabelGBC.insets = new Insets(5, 5, 5, 5);
        patientIdLabelGBC.gridx = 0;
        patientIdLabelGBC.gridy = 4;
        this.getContentPane().add(patientIdLabel, patientIdLabelGBC);

        patientId = new JTextField();
        GridBagConstraints patientIdGBC = new GridBagConstraints();
        patientIdGBC.insets = new Insets(5, 5, 5, 5);
        patientIdGBC.fill = GridBagConstraints.HORIZONTAL;
        patientIdGBC.gridx = 1;
        patientIdGBC.gridy = 4;
        this.getContentPane().add(patientId, patientIdGBC);
        patientId.setColumns(10);

        btnNewButton = new JButton("Hinzufügen");
        GridBagConstraints btnNewButtonGBC = new GridBagConstraints();
        btnNewButtonGBC.gridwidth = 2;
        btnNewButtonGBC.insets = new Insets(0, 0, 0, 5);
        btnNewButtonGBC.fill = GridBagConstraints.HORIZONTAL;
        btnNewButtonGBC.gridx = 3;
        btnNewButtonGBC.gridy = 4;
        this.getContentPane().add(btnNewButton, btnNewButtonGBC);
    }

    @Override
    protected void setUpListeners()
    {
        this.btnNewButton.addActionListener(
            e -> this.controller.performAction(
                AddPatientAction.ADD_TO_DATABASE));
    }

    @Override
    public void fillFromModel(Patient model)
    {
        this.patientId.setText(String.valueOf(model.getId()));
        this.prename.setText(model.getPrename());
        this.surname.setText(model.getSurname());
        this.street.setText(model.getStreet());
        this.city.setText(model.getCity());
        this.zipCode.setText(model.getZipCode());
    }

    @Override
    public Patient reflectIntoModel() throws NumberFormatException
    {
        try {
            return new Patient(
                Integer.parseInt(this.patientId.getText()),
                this.prename.getText(),
                this.surname.getText(),
                this.street.getText(),
                this.city.getText(),
                this.zipCode.getText());
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(
                String.format(
                    "patient ID '%s' is invalid",
                    this.patientId.getText()));
        }
    }
}