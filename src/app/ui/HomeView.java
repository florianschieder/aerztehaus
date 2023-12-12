package app.ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.ui.SimpleView;

public class HomeView extends SimpleView<HomeController> {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JButton btnNewPatient;
    private JButton btnExportRecords;
    private JButton btnExit;

    /**
     * Create the frame.
     */
    public HomeView(HomeController controller)
    {
        super(controller);
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void setUpListeners()
    {
        btnNewPatient.addActionListener(
            e -> this.controller.performAction(HomeAction.ADD_PATIENT));
        btnExportRecords.addActionListener(
            e -> this.controller.performAction(HomeAction.EXPORT_RECORDS));
        btnExit.addActionListener(
            e -> this.controller.performAction(HomeAction.QUIT));
    }

    @Override
    protected void initializeControls()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 1, 0, 0));

        JLabel lblHeading = new JLabel("Patientenverwaltung");
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeading.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(lblHeading);

        JLabel lblFunctions = new JLabel("Funktionsauswahl");
        contentPane.add(lblFunctions);

        btnNewPatient = new JButton("Neuen Patienten anlegen");
        contentPane.add(btnNewPatient);

        btnExportRecords = new JButton("Buchungssätze exportieren");
        contentPane.add(btnExportRecords);

        btnExit = new JButton("Schließen");
        contentPane.add(btnExit);
    }
}