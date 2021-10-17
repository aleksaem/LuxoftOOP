public class Designer extends Employee{
    int rate;
    int workedDays;

    public Designer(long id, String name, int age, double salary, String gender, int rate, int workedDays) {
        super(id, name, age, salary, gender);
        this.rate = rate;
        this.workedDays = workedDays;
    }

    @Override
    double countSalary() {
        return salary + rate * workedDays;
    }

    @Override
    public String toString() {
        return "Designer:" +
                " id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", rate=" + rate +
                ", workedDays=" + workedDays;
    }
}
