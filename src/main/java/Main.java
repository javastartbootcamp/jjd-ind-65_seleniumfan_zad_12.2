import java.io.File;

public class Main {

    public static void main(String[] args) {
        String fileName = "employees.csv";
        File file = new File(fileName);
        if (file.exists()) {
            Employee[] employees = FileUtils.read(file);
            File stats = new File("stats.txt");
            String employeeStats = createStats(employees);
            FileUtils.save(stats, employeeStats);
        }
    }

    private static String createStats(Employee[] employee) {
        EmployeeUtils employeeUtils = new EmployeeUtils(employee);
        return "Średnia wypłata: " + employeeUtils.averageSalary() +
                "\nMinimalna wypłata: " + employeeUtils.minSalary() +
                "\nMaksymalna wypłata: " + employeeUtils.maxSalary() +
                "\nLiczba pracowników IT: " + employeeUtils.employeeCount(Department.IT) +
                "\nLiczba pracowników Support: " + employeeUtils.employeeCount(Department.SUPPORT) +
                "\nLiczba pracowników Management: " + employeeUtils.employeeCount(Department.MANAGEMENT);
    }
}
