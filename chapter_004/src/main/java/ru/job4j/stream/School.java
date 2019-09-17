package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School class
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class School {
    /**
     * Students filter
     * @param students List of students.
     * @param predict Predicate. Need for filtering.
     * @return Return a list of students matching the condition.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     *
     * @param students List of students.
     * @param predict Predicate. Need for filtering.
     * @return Return a map of students matching the condition.
     */
    public Map<String, Student> collectAsMap(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toMap(Student::getSurname,
                e -> e));
    }
}
