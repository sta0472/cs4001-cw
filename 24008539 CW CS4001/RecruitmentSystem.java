
/**
 * RecruitmentSystem: Window to add and list vacancies, and test
 *
 * @STA0472
 * @25.7.25 Resit
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecruitmentSystem extends JFrame implements ActionListener {
    private Database db = new Database();
    private JTextField vacancyField, designationField;
    private JTextField salaryField, hoursField;   // for FT
    private JTextField wagesField, shiftsField;   // for PT
    private JTextArea outputArea;
    private JButton addFTBtn, addPTBtn, listBtn;

    public RecruitmentSystem() {
        super("Staff Hire System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Input panel
        JPanel input = new JPanel(new GridLayout(5, 4));
        input.add(new JLabel("Vacancy No:")); vacancyField = new JTextField(); input.add(vacancyField);
        input.add(new JLabel("Designation:")); designationField = new JTextField(); input.add(designationField);
        input.add(new JLabel("Salary (FT):"));    salaryField = new JTextField();    input.add(salaryField);
        input.add(new JLabel("Hours (FT):"));     hoursField = new JTextField();     input.add(hoursField);
        input.add(new JLabel("Wages/Hr (PT):")); wagesField  = new JTextField();    input.add(wagesField);
        input.add(new JLabel("Shifts (PT):"));   shiftsField  = new JTextField();    input.add(shiftsField);

        addFTBtn = new JButton("Add Full-Time"); addFTBtn.addActionListener(this);
        addPTBtn = new JButton("Add Part-Time"); addPTBtn.addActionListener(this);
        listBtn  = new JButton("List All");      listBtn.addActionListener(this);
        input.add(addFTBtn);
        input.add(addPTBtn);
        input.add(listBtn);

        add(input, BorderLayout.NORTH);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int vacNo = Integer.parseInt(vacancyField.getText().trim());
            String desig = designationField.getText().trim();

            if (e.getSource() == addFTBtn) {
                double sal = Double.parseDouble(salaryField.getText().trim());
                int hrs = Integer.parseInt(hoursField.getText().trim());
                FullTimeStaffHire ft = new FullTimeStaffHire(vacNo, desig, sal, hrs);
                db.add(ft);
                outputArea.append("Added FT vacancy #" + vacNo + "\n");

            } else if (e.getSource() == addPTBtn) {
                double wage = Double.parseDouble(wagesField.getText().trim());
                int hrs = Integer.parseInt(hoursField.getText().trim());
                String shifts = shiftsField.getText().trim();
                PartTimeStaffHire pt = new PartTimeStaffHire(vacNo, desig, wage, hrs, shifts);
                db.add(pt);
                outputArea.append("Added PT vacancy #" + vacNo + "\n");

            } else if (e.getSource() == listBtn) {
                outputArea.setText("");
                for (StaffHire s : db.getStaffList()){
                    outputArea.append("Vacancy #" + s.getVacancyNumber()
                            + " - " + s.getDesignation()
                            + " (" + s.getJobType() + ")\n");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Input error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecruitmentSystem());
    }
}