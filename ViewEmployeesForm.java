package payroll;
import javax.swing.*; import javax.swing.table.*; import java.awt.*; import java.sql.*;
public class ViewEmployeesForm extends JFrame {
    public ViewEmployeesForm() {
        setTitle("View Employees"); setSize(600, 400); setLocationRelativeTo(null);
        String[] columns = {"ID", "Name", "Designation", "Department", "Salary"};
        JTable table = new JTable(); DefaultTableModel model = new DefaultTableModel(columns, 0); table.setModel(model);
        try(Connection conn = DatabaseHelper.getConnection()) {
            Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM employees");
            while(rs.next()) model.addRow(new Object[]{ rs.getInt("emp_id"), rs.getString("name"), rs.getString("designation"), rs.getString("department"), rs.getDouble("basic_salary") });
        } catch(Exception e) { e.printStackTrace(); }
        add(new JScrollPane(table), BorderLayout.CENTER); setVisible(true);
    }
}