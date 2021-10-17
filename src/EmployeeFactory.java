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

    int generateWorkedDays(){
        Random random = new Random();

        return random.nextInt(31);
    }

    Developer generateDeveloper(){
        Developer developer = new Developer(id++,generateName(generateGender()), generateAge(), generateSalary(), generateGender(), generateFixedBugs());
        return developer;
    }

    Designer generateDesigner(){
        Designer designer = new Designer(id++,generateName(generateGender()), generateAge(), generateSalary(), generateGender(), 450, generateWorkedDays());
        return designer;
    }

    Manager generateManager(){
        Manager manager = new Manager(id++,generateName(generateGender()), generateAge(), generateSalary(), generateGender());
        return manager;
    }

    Developer[] generateDevelopers(int size){
        Developer[] developers = new Developer[size];

        for (int i = 0; i < developers.length; i++) {
            developers[i] = generateDeveloper();
        }
        return developers;
    }

    Designer[] generateDesigners(int size){
        Designer[] designers = new Designer[size];

        for (int i = 0; i < designers.length; i++) {
            designers[i] = generateDesigner();
        }
        return designers;
    }

    Manager[] generateManagers(int size){
        Manager[] managers = new Manager[size];

        for (int i = 0; i < managers.length; i++) {
            managers[i] = generateManager();
        }
        return managers;
    }

    Employee[] generateEmployees(int size){
        Random random = new Random();
        int countDesigners = random.nextInt(size/3);
        int countDevelopers = random.nextInt(size/2);
        int countManagers = size - (countDesigners + countDevelopers);
        Designer[] designers = generateDesigners(countDesigners);
        Developer[] developers = generateDevelopers(countDevelopers);
        Manager[] managers = generateManagers(countManagers);

        Employee[] employees = new Employee[size];
        int index = 0;
        for (Designer designer : designers) {
            employees[index] = designer;
            index++;
        }

        for (Developer developer : developers) {
            employees[index] = developer;
            index++;
        }

        for (Manager manager : managers) {
            employees[index] = manager;
            index++;
        }

        return employees;
    }
}
