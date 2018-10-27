
package Worker;

public class Worker {
    private String ID;
    private String name;
    private int age;
    private double salary;
    private String location;

    public Worker() {
    }

    public Worker(String ID, String name, int age, double salary, String location) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}
