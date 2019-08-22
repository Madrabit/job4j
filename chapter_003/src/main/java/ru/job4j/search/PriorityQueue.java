package ru.job4j.search;

import java.util.LinkedList;

/**
 * Приоритетная очередь
 * @author madrabit on 22.08.2019
 * @version 1$
 * @since 0.1
 */
public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (Task task1 : tasks) {
                if (task1.getPriority() >= task.getPriority()) {
                    tasks.add(tasks.indexOf(task1), task);
                    break;
                }
            }
        }
    }

    /**
     * Возвращает и удаляет приоритетный элемент
     * @return Элемент с самым высоким значением приоритетности
     */
    public Task take() {
        return this.tasks.poll();
    }
}
