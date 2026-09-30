package com.swynex.studentapp.model;

public class Student {
    private int id;
    private String name, email, phone, course;
    private double marks;

    public Student(int id, String name, String email, String phone, String course, double marks) {
        this.id = id; this.name = name; this.email = email;
        this.phone = phone; this.course = course; this.marks = marks;
    }
    public Student(String name, String email, String phone, String course, double marks) {
        this(0, name, email, phone, course, marks);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | %s | %s | %.2f",
                id, name, email, phone, course, marks);
    }
}
