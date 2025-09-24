import java.util.ArrayList;
import java.util.Scanner;

// Student class for Record Management System
class Student {
    private int id;
    private String name;
    private double marks;
    
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

// Student Management System
class StudentManagementSystem {
    private ArrayList<Student> students;
    private int nextId;
    
    public StudentManagementSystem() {
        students = new ArrayList<>();
        nextId = 1;
    }
    
    public void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();
        
        students.add(new Student(nextId++, name, marks));
        System.out.println("Student added successfully!");
    }
    
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n=== ALL STUDENTS ===");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void updateStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students to update!");
            return;
        }
        
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                
                System.out.print("Enter new marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine();
                
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }
    
    public void deleteStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students to delete!");
            return;
        }
        
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found!");
    }
}

// Calculator Class
class LoopingCalculator {
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
        return a / b;
    }
}

// Main Class
public class CombinedCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Calculator");
            System.out.println("2. Student Management System");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            
            int mainChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch (mainChoice) {
                case 1:
                    runCalculator(scanner);
                    break;
                case 2:
                    runStudentSystem(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void runCalculator(Scanner scanner) {
        System.out.println("\n==== CALCULATOR ====");
        
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice (1-5): ");
            
            int choice = scanner.nextInt();
            
            if (choice == 5) {
                System.out.println("Returning to main menu...");
                break;
            }
            
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice!");
                continue;
            }
            
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            double result;
            switch (choice) {
                case 1:
                    result = LoopingCalculator.add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = LoopingCalculator.subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = LoopingCalculator.multiply(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = LoopingCalculator.divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("Result: " + result);
                    }
                    break;
            }
        }
    }
    
    public static void runStudentSystem(Scanner scanner) {
        StudentManagementSystem system = new StudentManagementSystem();
        System.out.println("\n==== STUDENT MANAGEMENT SYSTEM ====");
        
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose option (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    system.addStudent(scanner);
                    break;
                case 2:
                    system.viewAllStudents();
                    break;
                case 3:
                    system.updateStudent(scanner);
                    break;
                case 4:
                    system.deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}