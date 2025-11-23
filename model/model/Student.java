package model;

public class Student extends Person {
    public int rollNo;
    public double marks;

    public Student(int rollNo, String name, String email, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public void display() {
        System.out.println(rollNo + " | " + name + " | " + email + " | " + marks);
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + marks;
    }
}
