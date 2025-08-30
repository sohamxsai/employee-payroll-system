package payroll;
import javax.swing.*;
import java.awt.*;
public class PayrollGUI extends JFrame {
    public PayrollGUI() {
        setTitle("Employee Payroll System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton addBtn = new JButton("Add Employee");
        JButton viewBtn = new JButton("View Employees");
        JButton payrollBtn = new JButton("Generate Payroll");
        JButton exitBtn = new JButton("Exit");
        setLayout(new GridLayout(4, 1, 10, 10));
        add(addBtn); add(viewBtn); add(payrollBtn); add(exitBtn);
        addBtn.addActionListener(e -> new AddEmployeeForm());
        viewBtn.addActionListener(e -> new ViewEmployeesForm());
        payrollBtn.addActionListener(e -> new PayrollForm());
        exitBtn.addActionListener(e -> System.exit(0));
        setVisible(true);
    }
    public static void main(String[] args) { new PayrollGUI(); }
}