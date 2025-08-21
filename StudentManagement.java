// StudentManagement.java
// A simple console-based Student Management System in Java

import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}

public class StudentManagement {
    private static Map<Integer, Student> studentDatabase = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice, try again!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, age, course);
        studentDatabase.put(id, student);

        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (studentDatabase.isEmpty()) {
            System.out.println("⚠ No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentDatabase.values()) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        if (studentDatabase.containsKey(id)) {
            System.out.println("🎓 Student Found: " + studentDatabase.get(id));
        } else {
            System.out.println("❌ Student not found!");
        }
    }
}
