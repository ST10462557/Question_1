/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abc_college;
import java.util.ArrayList;

/**
 *
 * @author dudle
 */
public class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters and setter methods
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    // override method 
    @Override
    public String toString() {
        return "STUDENT ID: " + id + "\n" +
               "STUDENT NAME: " + name + "\n" +
               "STUDENT AGE: " + age + "\n" +
               "STUDENT EMAIL: " + email + "\n" +
               "STUDENT COURSE: " + course;
    }

    // Required static methods
    public static void saveStudent(ArrayList<Student> students, Student student) {
        students.add(student);
    }

    public static Student searchStudent(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void deleteStudent(ArrayList<Student> students, String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public static void studentReport(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("STUDENT " + (i + 1));
            System.out.println("------------------------------------------");
            System.out.println(students.get(i));
            System.out.println("------------------------------------------");
        }
    }
}
