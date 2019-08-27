package ru.job4j.tracker;

import java.util.*;


/**
 * @author madrabit on 23.07.19
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings({"LoopStatementThatDoesntLoop", "UnusedReturnValue", "UnusedAssignment"})
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    public int getPosition() {
        return position;
    }

    private static final Random RND = new Random();
    /**
     * добавление заявок
     * @param item новая заявка
     * @return Заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        position++;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return RND.nextInt() + String.valueOf(System.currentTimeMillis());
    }
    /**
     * редактирование заявок
     * @param id  Идентификатор записи.
     * @param item Запись.
     * @return Результат произошла ли замена
     */
    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public boolean replace(String id, Item item) {
         for (int i = 0; i < this.position; i++) {
             if (this.items.get(i).getId().equals(id)) {
                 this.items.set(i, item);
                 item.setId(id);
             }
             return true;
         }
        return false;
    }
    /**
     * удаление заявок
     * @param id Идентификатор записи
     * @return Рузльтат. Получилось ли удалить.
     */
    public boolean delete(String id) {
        for (int i = 0; i < this.position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                position--;
                return true;
            }
        }
        return false;
    }

    /**
     * получение списка всех заявок
     * @return Список всех заявок без нулевых значений.
     */
    public List<Item> findAll() {
        return new ArrayList<>(this.items);
    }

    /**
     * получение списка по имени
     * @param key Название заявки.
     * @return Поиск заявки по имени.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int i = 0;
        for (; i < position; i++) {
            if (this.items.get(i) != null && this.items.get(i).getName().equals(key)) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }

    /**
     * получение заявки по id
     * @param id Id заявки.
     * @return поиск заявки по id.
     */
    public Item findById(String id) {
        for (Item element : this.items) {
            if (element != null && element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
}
