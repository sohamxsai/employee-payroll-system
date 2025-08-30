package payroll;
import javax.swing.*; import java.awt.*; import java.sql.*;
public class AddEmployeeForm extends JFrame {
    private JTextField nameField, desigField, deptField, salaryField;
    public AddEmployeeForm() {
        setTitle("Add Employee"); setSize(400, 300); setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new JLabel("Name:")); nameField = new JTextField(); add(nameField);
        add(new JLabel("Designation:")); desigField = new JTextField(); add(desigField);
        add(new JLabel("Department:")); deptField = new JTextField(); add(deptField);
        add(new JLabel("Basic Salary:")); salaryField = new JTextField(); add(salaryField);
        JButton saveBtn = new JButton("Save"); add(saveBtn);
        JButton cancelBtn = new JButton("Cancel"); add(cancelBtn);
        saveBtn.addActionListener(e -> saveEmployee()); cancelBtn.addActionListener(e -> dispose());
        setVisible(true);
    }
    private void saveEmployee() {
        try(Connection conn = DatabaseHelper.getConnection()) {
            String sql = "INSERT INTO employees(name, designation, department, basic_salary, join_date) VALUES (?, ?, ?, ?, CURDATE())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nameField.getText()); ps.setString(2, desigField.getText());
            ps.setString(3, deptField.getText()); ps.setDouble(4, Double.parseDouble(salaryField.getText()));
            ps.executeUpdate(); JOptionPane.showMessageDialog(this, "Employee added successfully!"); dispose();
        } catch(Exception ex) { JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage()); }
    }
}