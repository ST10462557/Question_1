/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author dudle
 */
public class StudentTest {
    
    private ArrayList<Student> students;
    
    public StudentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    void TestSaveStudent() {
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Computer Science");
        Student.saveStudent(students, student);

        assertEquals(1, students.size());
        assertEquals("1", students.get(0).getId());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals(20, students.get(0).getAge());
        assertEquals("john@example.com", students.get(0).getEmail());
        assertEquals("Computer Science", students.get(0).getCourse());
    }

    @Test
    void TestSearchStudent() {
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Computer Science");
        students.add(student);

        Student foundStudent = Student.searchStudent(students, "1");
        assertNotNull(foundStudent);
        assertEquals("1", foundStudent.getId());
    }

    @Test
    void TestSearchStudent_StudentNotFound() {
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Computer Science");
        students.add(student);

        Student foundStudent = Student.searchStudent(students, "2");
        assertNull(foundStudent);
    }

    @Test
    void TestDeleteStudent() {
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Computer Science");
        students.add(student);

        Student.deleteStudent(students, "1");
        assertEquals(0, students.size());
    }

    @Test
    void TestDeleteStudent_StudentNotFound() {
        Student student = new Student("1", "John Doe", 20, "john@example.com", "Computer Science");
        students.add(student);

        Student.deleteStudent(students, "2");
        assertEquals(1, students.size());
    }

    @Test
    void TestStudentAge_StudentAgeValid() {
        int validAge = StudentManager.getValidAge("20");
        assertEquals(20, validAge);
    }

    @Test
    void TestStudentAge_StudentAgeInvalid() {
        int invalidAge = StudentManager.getValidAge("15");
        assertEquals(-1, invalidAge);
    }

    @Test
    void TestStudentAge_StudentAgeInvalidCharacter() {
        int invalidAge = StudentManager.getValidAge("abc");
        assertEquals(-2, invalidAge);
    }
}
