package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * School class
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("SameParameterValue")
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
     * Map of students matching the condition.
     * @param students List of student ts.
     * @param predict Predicate. Need for filtering.
     * @return Return a map of students matching the condition.
     */
    public Map<String, Student> collectAsMap(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toMap(Student::getSurname,
                e -> e, (oldKey, newKey) -> newKey));
    }

    /**
     * Students selected by score.
     * @param students List of students.
     * @param bound Bound of score.
     * @return List of high score students.
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.comparing(Student::getScore))
                .flatMap(Stream::ofNullable)
                .takeWhile(e -> e.getScore() != bound)
                .collect(Collectors.toList());
    }
}
