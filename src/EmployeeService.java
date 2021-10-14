import java.util.*;

public class EmployeeService {
    Employee[] employees = getEmployees();

    Employee[] getEmployees(){
        Employee employeeAlice = new Employee(1,"Alice", 21, 5500, "Female", 3, 5);
        Employee employeeMark = new Employee(2,"Mark", 45, 7500, "Male", 6, 5);
        Employee employeeVitalik = new Employee(3,"Vitalik", 32, 7000, "Male", 1, 5);
        Employee employeeSasha = new Employee(4,"Sasha", 25, 10000, "Female", 7, 5);
        Employee employeeMartha = new Employee(5,"Martha", 21, 9500, "Female", 1, 5);
        Employee employeeDiana = new Employee(6,"Diana", 19, 9000, "Female", 0, 5);
        Employee employeeAlica = new Employee(7,"Alice", 60, 6500, "Female", 3, 5);
        Employee employeeDima = new Employee(8,"Dima", 23, 12000, "Male", 2, 5);
        Employee employeeRoma = new Employee(9,"Roma", 20, 8000, "Male", 5, 5);
        Employee employeeInna = new Employee(10,"Inna", 38, 7500, "Female", 3, 5);

        employees = new Employee[]{employeeAlice, employeeMark, employeeVitalik, employeeSasha, employeeMartha, employeeDiana,
        employeeAlica, employeeDima, employeeRoma, employeeInna};

        return employees;
    }

    void printEmployees(){
        for (int i = 0; i < employees.length; i++) {
            print(employees[i]);
        }
    }

    void printEmployees(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                print(employees[i]);
            }
        }
    }

    double calculateSalaryAndBonus(Employee[] employees){
        double generalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            generalSalary+=employees[i].salary + (employees[i].salary*employees[i].fixedBugs*employees[i].defaultBugRate/100);
        }

        return generalSalary;
    }

    Employee getById(long id){
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }

    Employee[] getByName(String name){
        List<Employee> employeesList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].name.equals(name)) {
                employeesList.add(employees[i]);
            }
        }
        Employee[] employeesWithIdenticalNames = new Employee[employeesList.size()];
        employeesWithIdenticalNames = employeesList.toArray(employeesWithIdenticalNames);
        return employeesWithIdenticalNames;
    }

    Employee[] sortByName(){
        String[] names = new String[employees.length];
        //Add employees' names to the array
        for (int i = 0; i < employees.length; i++) {
            names[i] = employees[i].name;
        }
        //Sort them in the alphabet order
        Arrays.sort(names);

        List<Employee> employeesList = new ArrayList<>();
        //Add employees to the list in the sorted order
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                if(names[i].equals(employees[j].name)){
                    employeesList.add(employees[j]);
                }
            }
        }
        //Create LinkedHashSet to delete duplicates
        Set<Employee> set = new LinkedHashSet<>(employeesList);
        employeesList.clear();
        employeesList.addAll(set);
        //Convert list to array
        Employee[] sortedByNameEmployees = new Employee[employeesList.size()];
        sortedByNameEmployees = employeesList.toArray(sortedByNameEmployees);
        return sortedByNameEmployees;
    }

    Employee[] sortByNameAndSalary(){
        Employee[] sortedByName = sortByName();
        for (int i = 0; i < sortedByName.length; i++) {
            if (i + 1 < sortedByName.length && sortedByName[i].name.equals(sortedByName[i + 1].name)) {
                Employee temp;
                if(sortedByName[i].salary < sortedByName[i+1].salary){
                    temp = sortedByName[i];
                    sortedByName[i] = sortedByName[i+1];
                    sortedByName[i+1] = temp;
                }
            }
        }
        return sortedByName;
    }

    Employee edit(Employee newEmployee){
        Employee temp = null;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].id == newEmployee.id){
                temp = employees[i];
                employees[i] = newEmployee;
            }
        }
        return temp;
    }

    Employee remove(long id) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == id) {
                index = i;
            }
        }

        Employee[] updatedEmployees = new Employee[employees.length-1];
        int index2 = 0;
        for (int i = 0; i < index; i++) {
            updatedEmployees[index2] = employees[i];
            index2++;
        }

        for (int i = index+1; i < employees.length; i++) {
            updatedEmployees[index2] = employees[i];
            index2++;
        }

        employees = updatedEmployees;
        Employee deletedEmployee = employees[index];
        return deletedEmployee;
    }

    void print(Employee employee) {
        System.out.println( "Employee{" +
                "id=" + employee.id +
                ", name='" + employee.name + '\'' +
                ", age=" + employee.age +
                ", salary=" + employee.salary +
                ", gender='" + employee.gender + '\'' +
                ", fixedBugs=" + employee.fixedBugs +
                ", defaultBugRate=" + employee.defaultBugRate +
                '}');
    }
}
