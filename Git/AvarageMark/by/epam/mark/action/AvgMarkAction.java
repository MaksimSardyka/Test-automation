package by.epam.mark.action;

import java.util.OptionalDouble;

import by.epam.mark.entity.Group;
import by.epam.mark.entity.Student;

public class AvgMarkAction {
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

    public OptionalDouble calcAvgStudentMark(Student student) {
        return student.getMarks().stream().mapToDouble(m -> m).average();
    }
}
