package by.epam.mark.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Group of students.
 */
public class Group {
    /**
     * List of students.
     */
    private List<Student> students = new ArrayList<>();

    /**
     * Adds new student this group.
     *
     * @param name
     *            Name of this student.
     * @param surname
     *            Surname of this student.
     */
    public void addStudent(final String name, final String surname) {
        students.add(new Student(name, surname));
    }

    /**
     * Return students from this group.
     *
     * @return List of students of this group.
     */
    public List<Student> getStudents() {
        return students;
    }
}
