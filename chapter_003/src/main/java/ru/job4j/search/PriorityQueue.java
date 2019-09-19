package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

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
            ListIterator<Task> iterator = tasks.listIterator();
            var count = 0;
            while (iterator.hasNext()) {
                if (task.getPriority() <= iterator.next().getPriority()) {
                    iterator.previous();
                    iterator.add(task);
                    break;
                }
                count++;
            }
            if (count == tasks.size()) {
                tasks.add(task);
            }
        }
    }
    /**
     * Возвращает и удаляет приоритетный элемент
     * @return Элемент с самым высоким значением приоритетности
     */
    public Task take() {
        for (var task : tasks) {
            System.out.println(task.getPriority());
        }
        return this.tasks.poll();
    }
}
