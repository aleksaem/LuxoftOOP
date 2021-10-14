import java.util.Random;

public class EmployeeFactory {

    private static long id = 1;

    String generateName(String gender) {
        String[] maleNames = {"Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander"};
        String[] femaleNames = {"Olivia", "Emma", "Ava", "Charlotte", "Sophia", "Amelia", "Isabella", "Mia", "Evelyn", "Harper"};

        Random random = new Random();
        int index = random.nextInt(10);

        String name = "";

        if (gender.equals("Male")) {
            name = maleNames[index];
        } else {
            name = femaleNames[index];
        }
        return name;
    }

    String generateGender() {
        String[] genders = {"Male", "Female"};
        Random random = new Random();
        int index = random.nextInt(2);

        return genders[index];
    }

    int generateAge() {
        int minAge = 18;
        int maxAge = 70;

        return minAge + (int) (Math.random() * maxAge);
    }

    double generateSalary() {
        int minSalary = 6000;
        int maxSalary = 15000;
        double salary = minSalary + (Math.random() * maxSalary);
        return salary - salary % 100 + (salary%100==0? 0 : 100);
    }

    int generateFixedBugs(){
        Random random = new Random();

        return random.nextInt(10);
    }

    Employee generateEmployee(){
        Employee employee = new Employee(id++,generateName(generateGender()), generateAge(), generateSalary(), generateGender(), generateFixedBugs(), 5);
        return employee;
    }

    Employee[] generateEmployees(int size){
        Employee[] employees = new Employee[size];

        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }
        return employees;
    }
}
