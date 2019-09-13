package ru.job4j.stream;

import java.util.List;
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
     * @param students
     * @param predict
     * @return
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}
