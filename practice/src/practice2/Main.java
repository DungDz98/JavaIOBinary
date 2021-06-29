package practice2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void ghiFile(String path, List<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vu Kieu Anh", "Ha Noi"));
        students.add(new Student(2, "Nguyen Minh Quan", "Ha Noi"));
        students.add(new Student(3, "Dang Huy Hoa", "Da Nang"));
        students.add(new Student(4, "Nguyen Khanh Tung", "Ha Noi"));
        students.add(new Student(5, "Nguyen Khac Nhat", "Ha Noi"));
        ghiFile("./src/practice2/student.txt", students);
        List<Student> studentDataFromFile = docFile("./src/practice2/student.txt");
        for (Student s : studentDataFromFile) {
            System.out.println(s);
        }
    }

    public static List<Student> docFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            students = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
