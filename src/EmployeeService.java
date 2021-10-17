import java.util.*;

public class EmployeeService {
    Employee[] employees = getEmployees();


    Employee[] getEmployees(){
        Designer employeeAlice = new Designer(1,"Alice", 21, 5500, "Female", 450, 20);
        Designer employeeMark = new Designer(2,"Mark", 45, 7500, "Male", 450, 15);
        Designer employeeVitalik = new Designer(3,"Vitalik", 32, 7000, "Male", 450, 22);
        Manager employeeSasha = new Manager(4,"Sasha", 25, 10000, "Female");
        Manager employeeMartha = new Manager(5,"Martha", 21, 9500, "Female");
        Developer employeeDiana = new Developer(6,"Diana", 19, 9000, "Female", 9);
        Developer employeeAlica = new Developer(7,"Alice", 60, 6500, "Female", 3);
        Developer employeeDima = new Developer(8,"Dima", 23, 12000, "Male", 12);
        Developer employeeRoma = new Developer(9,"Roma", 20, 8000, "Male", 5);
        Developer employeeInna = new Developer(10,"Inna", 38, 7500, "Female", 3);

        employees = new Employee[]{employeeAlice, employeeMark, employeeVitalik, employeeSasha, employeeMartha, employeeDiana,
        employeeAlica, employeeDima, employeeRoma, employeeInna};

        return employees;
    }

    void printEmployees(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    void printEmployees(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    double calculateSalaryAndBonus(Employee[] employees){
        double generalSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            generalSalary+=employees[i].countSalary();
        }

        return generalSalary;
    }

    Employee getById(long id){
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    Employee[] getByName(String name){
        List<Employee> employeesList = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
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
            names[i] = employees[i].getName();
        }
        //Sort them in the alphabet order
        Arrays.sort(names);

        List<Employee> employeesList = new ArrayList<>();
        //Add employees to the list in the sorted order
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                if(names[i].equals(employees[j].getName())){
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
            if (i + 1 < sortedByName.length && sortedByName[i].getName().equals(sortedByName[i + 1].getName())) {
                Employee temp;
                if(sortedByName[i].getSalary() < sortedByName[i+1].getSalary()){
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
            if(employees[i].getId() == newEmployee.getId()){
                temp = employees[i];
                employees[i] = newEmployee;
            }
        }
        return temp;
    }

    Employee remove(long id) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
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

}
