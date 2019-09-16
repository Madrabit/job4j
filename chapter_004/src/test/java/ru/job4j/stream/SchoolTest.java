package ru.job4j.stream;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class SchoolTest {
    final List<Student> students = Arrays.asList(
            new Student(10),
            new Student(50),
            new Student(70),
            new Student(90)
    );

    @Test
    public void whenA10Then70to100() {
        List<Student> expected = List.of(
                new Student(70),
                new Student(90)
        );
       School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() < 100 && student.getScore() >= 70);
       assertThat(result, is(expected));
    }

    @Test
    public void whenB10Then50to70() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() < 70 && student.getScore() >= 50
        );
        List<Student> expected = List.of(
                new Student(50)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenC10Then0to50() {
        School school = new School();
        List<Student> result = school.collect(students,
                student -> student.getScore() < 50 && student.getScore() >= 0
        );
        List<Student> expected = List.of(
                new Student(10)
        );
        assertThat(result, is(expected));
    }


}
