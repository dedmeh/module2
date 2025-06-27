import java.io.*;

public class StudentDemo {
    public static void main(String[] args) {
        try {
//            Student s1 = new Student(1, "Trung", 23);
//            writeStudent(s1);
            Student std = readStudent();
            System.out.println(std);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeStudent(Student student) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
        oos.writeObject(student);

        oos.close();
    }

    public static Student readStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
        Student student = (Student) ois.readObject();
        return student;
    }
}