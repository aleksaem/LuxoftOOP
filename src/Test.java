
public class Test {

    public static void main(String[] args) {
         EmployeeService employeeService = new EmployeeService();

        Employee[] defaultEmployees = employeeService.getEmployees();

        System.out.println("-----------------Full list of employees-------------------------");
        employeeService.printEmployees();

        Employee employeeById = employeeService.getById(5);
        System.out.println("-----------------Employee with id 5-------------------------");
        employeeService.print(employeeById);

        System.out.println("-----------------General employees salary-------------------------");
        System.out.println("General salary: " + employeeService.calculateSalaryAndBonus(defaultEmployees));

        Employee[] employeesByName = employeeService.getByName("Alice");
        System.out.println("-----------------Employees with name Alice-------------------------");
        employeeService.printEmployees(employeesByName);

        Employee[] sortedEmployeesByName = employeeService.sortByName();
        System.out.println("-----------------Employees sorted by names-------------------------");
        employeeService.printEmployees(sortedEmployeesByName);

        Employee[] sortedEmployeesByNameAndSalary = employeeService.sortByNameAndSalary();
        System.out.println("-----------------Employees sorted by names and salary-------------------------");
        employeeService.printEmployees(sortedEmployeesByNameAndSalary);

        Employee newEmployee = new Employee(6,"Julia", 22, 7000, "Female", 1, 5);
        System.out.println("---------------------Edit employee-------------------------");
        employeeService.print(employeeService.edit(newEmployee));

        System.out.println("---------------------Delete employee-------------------");
        employeeService.print(employeeService.remove(2));

        System.out.println("-----------------Full list of employees-------------------------");
        employeeService.printEmployees();

        EmployeeFactory employeeFactory = new EmployeeFactory();
        System.out.println("---------------------Generate random emloyees-----------");
        employeeService.printEmployees(employeeFactory.generateEmployees(3));
    }


}




