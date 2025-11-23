package manager;

import java.io.*;
import java.util.*;
import interfaces.Actions;
import model.Student;

public class StudentManager implements Actions {

    ArrayList<Student> list = new ArrayList<>();
    File file = new File("students.txt");

    public void loadData() {
        try {
            if (!file.exists()) file.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] p = line.split(",");
                list.add(new Student(Integer.parseInt(p[0]), p[1], p[2], Double.parseDouble(p[3])));
            }

            br.close();
            System.out.println("Data loaded successfully.\n");

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }

    public void saveData() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (Student s : list) pw.println(s);
            pw.close();
            System.out.println("Data saved.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    @Override
    public void addStudent(Student s) {
        list.add(s);
        System.out.println("Student Added.");
    }

    @Override
    public void updateStudent(int roll, double marks) throws Exception {
        Student s = searchStudent(roll);
        s.marks = marks;
        System.out.println("Record Updated.");
    }

    @Override
    public void deleteStudent(int roll) throws Exception {
        Student s = searchStudent(roll);
        list.remove(s);
        System.out.println("Record Deleted.");
    }

    @Override
    public Student searchStudent(int roll) throws Exception {
        for (Student s : list) {
            if (s.rollNo == roll) return s;
        }
        throw new Exception("Student Not Found.");
    }

    public void sortByMarks() {
        Collections.sort(list, Comparator.comparingDouble(st -> -st.marks));
        System.out.println("\nSorted by marks (high → low):\n");
    }

    @Override
    public void viewStudents() {
        if (list.isEmpty()) System.out.println("No Records.");
        else for (Student s : list) s.display();
    }
}
