package payroll;
import javax.swing.*; import java.awt.*; import java.sql.*;
public class PayrollForm extends JFrame {
    private JTextField empIdField, monthField, allowanceField, deductionField;
    public PayrollForm() {
        setTitle("Generate Payroll"); setSize(400, 300); setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new JLabel("Employee ID:")); empIdField = new JTextField(); add(empIdField);
        add(new JLabel("Month:")); monthField = new JTextField(); add(monthField);
        add(new JLabel("Allowances:")); allowanceField = new JTextField(); add(allowanceField);
        add(new JLabel("Deductions:")); deductionField = new JTextField(); add(deductionField);
        JButton generateBtn = new JButton("Generate"); add(generateBtn);
        JButton cancelBtn = new JButton("Cancel"); add(cancelBtn);
        generateBtn.addActionListener(e -> generatePayroll()); cancelBtn.addActionListener(e -> dispose());
        setVisible(true);
    }
    private void generatePayroll() {
        try(Connection conn = DatabaseHelper.getConnection()) {
            int empId = Integer.parseInt(empIdField.getText());
            String month = monthField.getText();
            double allowances = Double.parseDouble(allowanceField.getText());
            double deductions = Double.parseDouble(deductionField.getText());
            String sql = "SELECT basic_salary FROM employees WHERE emp_id=?";
            PreparedStatement ps = conn.prepareStatement(sql); ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                double basic = rs.getDouble("basic_salary");
                Payroll payroll = new Payroll(basic, allowances, deductions);
                double net = payroll.calculateNetSalary();
                sql = "INSERT INTO payroll(emp_id, month, allowances, deductions, net_salary) VALUES (?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, empId); ps.setString(2, month); ps.setDouble(3, allowances); ps.setDouble(4, deductions); ps.setDouble(5, net);
                ps.executeUpdate(); JOptionPane.showMessageDialog(this, "Payroll Generated! Net Salary = " + net); dispose();
            } else { JOptionPane.showMessageDialog(this, "Employee not found!"); }
        } catch(Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }
}