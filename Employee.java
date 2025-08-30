package payroll;
public class Employee {
    private int id;
    private String name;
    private String designation;
    private String department;
    private double basicSalary;
    public Employee(int id, String name, String designation, String department, double basicSalary) {
        this.id = id; this.name = name; this.designation = designation; this.department = department; this.basicSalary = basicSalary;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }
}