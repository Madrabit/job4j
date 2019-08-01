package ru.job4j.tracker;

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
    private final UserAction[] actions = new UserAction[6];

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
        return this.actions.length;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new UpdateItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemsByName();
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс реализует добавленяи новый заявки в хранилище.
     */
    private static class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "Add new Item.";
        }
    }

    /**
     * Класс получения списка всех заявок.
     */
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Получение списка заявок --------------");
            Item[] items = tracker.findAll();
            System.out.println("------------ Список заявок: ");
            for (Item element : items) {
                System.out.println(element.getId()
                        + " " + element.getName()
                        + " " + element.getDesc()
                        + " " + element.getTime());
            }
        }

        @Override
        public String info() {
            return "Show All Items.";
        }
    }

    /**
     * Класс редактирования заявки.
     */
    private static class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "Update Item";
        }
    }

    /**
     * Удаление заявки.
     */
    private static class DeleteItem implements  UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "Delete Item";
        }
    }

    /**
     * Поиск заявки по ID.
     */
    private static class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return "Find Item by ID";
        }
    }

    /**
     * Поиск заявки по имени.
     */
    private static class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки, которую хотите найти: ");
            Item[] items =  tracker.findByName(name);
            for (Item el : items) {
                if (el != null) {
                    System.out.println("------------ Найденная заявка: " + el.getName()
                            + "-----------"
                            + el.getDesc()
                    );
                }
            }
        }

        @Override
        public String info() {
            return "Find Items by Name";
        }
    }
}
