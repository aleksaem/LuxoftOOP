public class Employee {
    long id;
    String name;
    int age;
    double salary;
    String gender;
    int fixedBugs;
    int defaultBugRate;

    public Employee(long id, String name, int age, double salary, String gender, int fixedBugs, int defaultBugRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.fixedBugs = fixedBugs;
        this.defaultBugRate = defaultBugRate;
    }

}
