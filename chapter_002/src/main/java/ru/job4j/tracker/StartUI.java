package ru.job4j.tracker;

/**
 * Точка входа в программу.
 * @author madrabit on 29.07.2019
 * @version 1$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String FINDALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по Id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска зявки по названию.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FINDALL.equals((answer))) {
                this.findAll();
            } else if (EDIT.equals((answer))) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод получения списка всех заявок
     */
    private void findAll() {
        System.out.println("------------ Получение списка заявок --------------");
        Item[] items = this.tracker.findAll();
        System.out.println("------------ Список заявок: ");
        for (Item element : items) {
            System.out.println(element.getId()
                    + " " + element.getName()
                    + " " + element.getDecs()
                    + " " + element.getTime());
        }
    }

    /**
     * Метод редактирования заявки.
     */
    private void edit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки, которую хотите отредактировать: ");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.replace(id, item);
        System.out.println("------------ Отредактированная заявка с новыми данными : "
                + item.getName()
                + " " + item.getDecs());
    }

    /**
     * Метод удаления заявки.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки, которую хотите удалить: ");
        this.tracker.delete(id);
    }

    /**
     * Поиск заявки по ID.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки, которую хотите найти: ");
        Item item =  this.tracker.findById(id);
        System.out.println("------------ Найденная заявка: " + item.getName()
                + "-----------"
                + item.getDecs()
        );
    }
    /**
     * Поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки, которую хотите найти: ");
        Item[] items =  this.tracker.findByName(name);
        for (Item el : items) {
            System.out.println("------------ Найденная заявка: " + el.getName()
                    + "-----------"
                    + el.getDecs()
            );
        }
    }
    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
    }

    /**
     * Запускт программы.
     * @param args args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
