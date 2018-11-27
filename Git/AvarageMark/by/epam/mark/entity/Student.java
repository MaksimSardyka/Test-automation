package by.epam.mark.entity;

import java.util.ArrayList;
import java.util.List;

import by.epam.mark.exception.MarkException;

/**
 * Student person class.
 */
public class Student {
    /**
     * Min possible mark allowed.
     */
    private static final int MIN_MARK = 4;
    /**
     * Max possible mark allowed.
     */
    private static final int MAX_MARK = 10;
    /**
     * Surname of the student.
     */
    private String surname;
    /**
     * Name of the student.
     */
    private String name;
    /**
     * Marks of the student.
     */
    private List<Integer> marks;

    /**
     * Constructor for Student entity.
     * 
     * @param name
     *            Name of the student.
     * @param surname
     *            surname of the student.
     */
    Student(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
        marks = new ArrayList<>();
    }

    /**
     * Return marks of the student.
     * 
     * @return List of marks of this student.
     */
    public List<Integer> getMarks() {
        return marks;
    }

    /**
     * Add mark for this student.
     * 
     * @param mark
     *            mark to add for this student.
     * @throws MarkException
     *             If wrong mark provided.
     */
    public void addMark(final Integer mark) throws MarkException {
        if (MIN_MARK <= mark && mark <= MAX_MARK) {
            marks.add(mark);
        } else {
            throw new MarkException("Wrong mark provided" + mark);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Name:").append(this.name)
                .append("\nSurname:").append(this.surname);
        marks.stream().forEach(mark -> sb.append("\nMark: ").append(mark));
        return sb.toString();
    }
}
