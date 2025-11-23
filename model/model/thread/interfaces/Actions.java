package interfaces;

import model.Student;

public interface Actions {
    void addStudent(Student s);
    void updateStudent(int roll, double marks) throws Exception;
    void deleteStudent(int roll) throws Exception;
    Student searchStudent(int roll) throws Exception;
    void viewStudents();
}
