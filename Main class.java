package com.swynex.studentapp;

import com.swynex.studentapp.dao.StudentDAO;
import com.swynex.studentapp.exception.ValidationException;
import com.swynex.studentapp.model.Student;
import com.swynex.studentapp.util.Validator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add  2. View All  3. Search  4. Update  5. Delete  6. Exit");
            System.out.print("Choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> {
                        Student s = readStudent(sc);
                        Validator.validate(s);
                        dao.addStudent(s);
                        System.out.println("Student added.");
                    }
                    case 2 -> dao.getAllStudents().forEach(System.out::println);
                    case 3 -> {
                        System.out.print("Enter ID: ");
                        Student s = dao.searchById(Integer.parseInt(sc.nextLine()));
                        System.out.println(s != null ? s : "Not found.");
                    }
                    case 4 -> {
                        System.out.print("Enter ID to update: ");
                        int id = Integer.parseInt(sc.nextLine());
                        Student s = readStudent(sc);
                        Validator.validate(s);
                        dao.updateStudent(id, s);
                        System.out.println("Updated.");
                    }
                    case 5 -> {
                        System.out.print("Enter ID to delete: ");
                        dao.deleteStudent(Integer.parseInt(sc.nextLine()));
                        System.out.println("Deleted.");
                    }
                    case 6 -> { System.out.println("Goodbye!"); return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (ValidationException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static Student readStudent(Scanner sc) {
        System.out.print("Name: ");   String name = sc.nextLine();
        System.out.print("Email: ");  String email = sc.nextLine();
        System.out.print("Phone: ");  String phone = sc.nextLine();
        System.out.print("Course: "); String course = sc.nextLine();
        System.out.print("Marks: ");  double marks = Double.parseDouble(sc.nextLine());
        return new Student(name, email, phone, course, marks);
    }
}
