import java.util.Random;

public class Developer extends Employee{
    int fixedBugs;

    public Developer(long id, String name, int age, double salary, String gender, int fixedBugs) {
        super(id, name, age, salary, gender);
        this.fixedBugs = fixedBugs;
    }

    @Override
    double countSalary() {
        return (salary + fixedBugs * 15) * (new Random().nextBoolean() ? 2 : 0);
    }

    @Override
    public String toString() {
        return "Developer:" +
                " id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", fixedBugs=" + fixedBugs;
    }
}
