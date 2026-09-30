package com.swynex.studentapp.util;

import com.swynex.studentapp.exception.ValidationException;
import com.swynex.studentapp.model.Student;

public class Validator {
    public static void validate(Student s) throws ValidationException {
        if (s.getName() == null || !s.getName().matches("[A-Za-z ]{2,50}"))
            throw new ValidationException("Name must be 2-50 letters only.");
        if (!s.getEmail().matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$"))
            throw new ValidationException("Invalid email format.");
        if (!s.getPhone().matches("\\d{10}"))
            throw new ValidationException("Phone must be exactly 10 digits.");
        if (s.getCourse() == null || s.getCourse().trim().isEmpty())
            throw new ValidationException("Course cannot be empty.");
        if (s.getMarks() < 0 || s.getMarks() > 100)
            throw new ValidationException("Marks must be between 0 and 100.");
    }
}
