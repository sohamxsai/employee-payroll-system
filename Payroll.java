package payroll;
public class Payroll {
    private double basicSalary;
    private double allowances;
    private double deductions;
    public Payroll(double basicSalary, double allowances, double deductions) {
        this.basicSalary = basicSalary; this.allowances = allowances; this.deductions = deductions;
    }
    public double calculateNetSalary() { return basicSalary + allowances - deductions; }
}