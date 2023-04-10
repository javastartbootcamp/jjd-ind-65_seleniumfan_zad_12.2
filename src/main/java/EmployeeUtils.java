public class EmployeeUtils {
    private Employee[] employees;

    public EmployeeUtils(Employee[] employees) {
        this.employees = employees;
    }

    public double averageSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.length;
    }

    public double minSalary() {
        double minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public double maxSalary() {
        double maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public int employeeCount(Department department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department.getName())) {
                count++;
            }
        }
        return count;
    }
}
