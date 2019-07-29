package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;


/**
 * @author madrabit on 23.07.19
 * @version 1$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RND = new Random();
    /**
     * добавление заявок
     * @param item новая заявка
     * @return Заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
    public boolean replace(String id, Item item) {
         for (int i = 0; i < this.position; i++) {
             if (this.items[i].getId().equals(id)) {
                 this.items[i] = item;
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
            if (this.items[i].getId().equals(id)) {
                this.items[i] = null;
                System.arraycopy(this.items, i, this.items, i, this.items.length - 1);
                position--;
                return true;
            }
            return true;
        }
        return false;
    }

    /**
     * получение списка всех заявок
     * @return Список всех заявок без нулевых значений.
     */
    public Item[] findAll() {
        Item[] arr = new Item[this.items.length];
        return Arrays.copyOf(arr, position);
    }

    /**
     * получение списка по имени
     * @param key
     * @return Поиск заявки по имени.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.items.length];
        int i = 0;
        for (; i < position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                result[i] = this.items[i];
            }
        }
        return Arrays.copyOf(result, i);
    }

    /**
     * получение заявки по id
     * @param id
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
