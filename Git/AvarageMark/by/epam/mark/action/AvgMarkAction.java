package by.epam.mark.action;

import java.util.OptionalDouble;

import by.epam.mark.entity.Group;
import by.epam.mark.entity.Student;

/**
 * Actions to perform in this project.
 */
public class AvgMarkAction {
	/**
	 * Calculates avarage mark for a passed group.
	 */
    public OptionalDouble calaAvgGroupMark(Group group) {
        OptionalDouble avgGroupMark = OptionalDouble.empty();
        int counter = 0;
        double sum = 0;
        for(Student student : group.getStudents()) {
            OptionalDouble AvgStudentMark = calcAvgStudentMark(student);
            if(AvgStudentMark.isPresent()) {
                counter++;
                sum+=AvgStudentMark.getAsDouble();
            }
        }
        if(counter>0) {
            avgGroupMark = OptionalDouble.of(sum/counter);
        }
        return avgGroupMark;
    }

	/**
	  * Calculates avarage mark for a passed student.
	  */
    public OptionalDouble calcAvgStudentMark(Student student) {
        return student.getMarks().stream().mapToDouble(m -> m).average();
    }
}
