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
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                    break;
                } else if (i == tasks.size() - 1) {
                    tasks.add(task);
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
        for (Task task : tasks) {
            System.out.println(task.getPriority());
        }
        return this.tasks.poll();
    }
}
