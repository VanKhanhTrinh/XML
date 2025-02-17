import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BT2 {
    public static void main(String[] args) {
        List<Student> studentList = createStudentList();
        try {
            FileWriter writer = new FileWriter("student_list.xml");
            writer.write("<students>\n");
            for (Student student : studentList) {
                writer.write("<student>\n");
                writer.write("    <name>" + student.getName() + "</name>\n");
                writer.write("    <age>" + student.getAge() + "</age>\n");
                writer.write("    <gpa>" + student.getGpa() + "</gpa>\n");
                writer.write("</student>\n");
            }
            writer.write("</students>\n");
            writer.close();
            System.out.println("Đã tạo file XML thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo file XML.");
            e.printStackTrace();
        }
    }

    private static List<Student> createStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John Doe", 20, 3.8));
        studentList.add(new Student("Jane Smith", 21, 3.9));
        studentList.add(new Student("David Johnson", 19, 3.5));
        return studentList;
    }

    private static class Student {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGpa() {
            return gpa;
        }
    }
}