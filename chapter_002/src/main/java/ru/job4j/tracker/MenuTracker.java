package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madrabit on 01.08.2019
 * @version 1$
 * @since 0.1
 */
public class MenuTracker {
    /**
     * param хранит ссылку на объект .
     */
    private final Input input;
    /**
     * хранит ссылку на объект .
     */
    private final Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private final List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        actions.add(new AddItem(0, "Add new Item."));
        actions.add(new ShowItems(1, "Show All Items."));
        actions.add(new UpdateItem(2, "Update Item"));
        actions.add(new DeleteItem(3, "Delete Item"));
        actions.add(new FindItemById(4, "Find Item by ID"));
        actions.add(new FindItemsByName(5, "Find Items by Name"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.infoMenu());
            }
        }
    }

    /**
     * Класс реализует добавленяи новый заявки в хранилище.
     */
    private static class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }
    }

    /**
     * Класс получения списка всех заявок.
     */
    private static class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Получение списка заявок --------------");
            List<Item> items = tracker.findAll();
            System.out.println("------------ Список заявок: ");
            for (Item element : items) {
                System.out.println(element.getId()
                        + " " + element.getName()
                        + " " + element.getDesc()
                        + " " + element.getTime());
            }
        }
    }

    /**
     * Класс редактирования заявки.
     */
    private static class UpdateItem extends BaseAction {
        public UpdateItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите ID заявки, которую хотите отредактировать: ");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            boolean result = tracker.replace(id, item);
            if (result) {
                System.out.println("------------ Отредактированная заявка с новыми данными : "
                        + item.getName()
                        + " " + item.getDesc());
            } else {
                System.out.println("Не удалось отредактировать заявку.");
            }
        }
    }

    /**
     * Удаление заявки.
     */
    private static class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки, которую хотите удалить: ");
            boolean result = tracker.delete(id);
            if (result) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Заявка не удалилась.");
            }
        }
    }

    /**
     * Поиск заявки по ID.
     */
    private static class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки, которую хотите найти: ");
            Item item =  tracker.findById(id);
            if (item != null) {
                System.out.println("------------ Найденная заявка: " + item.getName()
                        + "-----------"
                        + item.getDesc()
                );
            } else {
                System.out.println("-------------- Такой заявки не существует --------------");
            }
        }
    }

    /**
     * Поиск заявки по имени.
     */
    private static class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки, которую хотите найти: ");
            List<Item> items =  tracker.findByName(name);
            for (Item el : items) {
                if (el != null) {
                    System.out.println("------------ Найденная заявка: " + el.getName()
                            + "-----------"
                            + el.getDesc()
                    );
                }
            }
        }
    }
}
