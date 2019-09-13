package ru.job4j.stream;

import java.util.Objects;

/**
 * Student with score
 * @author madrabit on 12.09.2019
 * @version 1$
 * @since 0.1
 */
public class Student {
    private final int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
