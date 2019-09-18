package ru.job4j.stream;

import java.util.Comparator;
import java.util.Objects;

/**
 * Student with score
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class Student implements Comparator<Student> {
    private final int score;
    private final String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public int compare(Student student, Student t1) {
        if (student.getScore() > t1.getScore()) {
            return 1;
        } else if (student.getScore() < t1.getScore()) {
            return -1;
        }
        return 0;
    }
}
