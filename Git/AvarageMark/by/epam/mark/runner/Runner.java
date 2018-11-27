package by.epam.mark.runner;

import java.util.Random;

import by.epam.mark.action.AvgMarkAction;
import by.epam.mark.entity.Group;
import by.epam.mark.entity.Student;
import by.epam.mark.exception.MarkException;
import by.epam.mark.view.View;

/**
 * Stub runner with hardcoded values.
 */
public class Runner {
    /**
     * number of marks generated for each person.
     */
    private static final int MARK_QUANTITY_PER_PERSON = 4;

    /**
     * Main runner method.
     *
     * @param args
     *            Console arguments.
     */
    public static void main(final String[] args) {
        Group group = new Group();
        View view = new View();
        // set students
        group.addStudent("Ivan", "Ivanov");
        group.addStudent("Peter", "Petrov");
        group.addStudent("Maksim", "Maksimov");
        final int minMark = 4;
        final int maxMark = 10;
        // set marks
        Random random = new Random();
        for (Student student : group.getStudents()) {
            for (int i = MARK_QUANTITY_PER_PERSON; i > 0; i--) {
                int mark = random.nextInt(maxMark - minMark + 1) + minMark;
                try {
                    student.addMark(mark);
                } catch (MarkException e) {
                    view.show("Wrong mark provided");
                }
            }
        }
        // avg mark per person
        AvgMarkAction avgMark = new AvgMarkAction();
        group.getStudents().stream()
                .forEach(s -> view.show(s.toString() + "\nAvg student mark:"
                        + avgMark.calcAvgStudentMark(s).getAsDouble()));
        // avg whole group mark
        view.show("\nAvg group mark:"
                + avgMark.calaAvgGroupMark(group).getAsDouble());
    }
}
