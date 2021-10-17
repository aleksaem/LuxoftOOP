public class Employee {
    protected long id;
    protected String name;
    protected int age;
    protected double salary;
    protected String gender;


    public Employee(long id, String name, int age, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    double countSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee:" +
                " id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender;
    }
}
