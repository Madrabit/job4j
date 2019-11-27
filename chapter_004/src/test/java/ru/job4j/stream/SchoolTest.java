package ru.job4j.stream;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.*;

/**
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class SchoolTest {
    public final List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(10, "A"),
                    new Student(50, "B"),
                    new Student(70, "C"),
                    new Student(90, "D")
            )
    );

    @Test
    public void whenA10Then70to100() {
        List<Student> expected = List.of(
                new Student(70, "C"),
                new Student(90, "D")
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
                new Student(50, "B")
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
                new Student(10, "A")
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenA10Then70to100AsMap() {
        Map<String, Student> expected = new HashMap<>();
        expected.put("C", new Student(70, "C"));
        expected.put("D", new Student(90, "D"));
        School school = new School();
        Map<String, Student> result = school.collectAsMap(students,
                student -> student.getScore() < 100 && student.getScore() >= 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenDuplicateThenMap() {
        students.add(new Student(70, "C"));
        Map<String, Student> expected = new HashMap<>();
        expected.put("C", new Student(70, "C"));
        expected.put("D", new Student(90, "D"));
        School school = new School();
        Map<String, Student> result = school.collectAsMap(students,
                student -> student.getScore() < 100 && student.getScore() >= 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenBound40ThenHighScoreStudents() {
        List<Student> expected = List.of(
                new Student(10, "A"),
                new Student(50, "B")
        );
        School school = new School();
        List<Student> result = school.levelOf(students, 70);
        assertThat(result, is(expected));
    }


}
