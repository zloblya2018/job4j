package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для показа всех заявок.
     */
    private static final String GETALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String REPLACE = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";
    /**
     * Константа меню для поска заявки по уникальному номеру.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поска заявки по имени.
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
    private Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param /input ввод данных.
     * @param /tracker хранилище заявок.
     */
    public StartUI(Input input) {
        this.input = input;
    }

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
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (GETALL.equals(answer)) {
                this.getAllItem();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DEL.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
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
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует вывод на экран списка всех заявок.
     */
    private void getAllItem() {
        System.out.println("------------ Начало списка всех заявок ------------ ");
        for (Item item : tracker.getAll()) {
            System.out.println(item);
        }
        System.out.println("------------ Конец списка всех заявок ------------ ");
    }
    /**
     * Метод реализует внесение изменения в заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки ------------ ");
        String id = this.input.ask("Введите id заявки, которая подлежит изменению: ");
        String name = this.input.ask(
                "Введите имя заявки, которая подлежит изменению: ");
        String desc = this.input.ask("Введите новое описание измененной заявки :");
        for (Item item : tracker.getAll()) {
            if (id.equals(item.getId())) {
                tracker.replace(id, new Item(name, desc));
                break;
            }
        }
        System.out.println("------------ Ваши изменения успешно внесены ------------ ");
    }
    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки ------------ ");
        String id = this.input.ask("Введите id заявки, которая подлежит удалению: ");
        tracker.delete(id);
        System.out.println("------------ Ваши изменения успешно внесены ------------ ");
    }
    /**
     * Метод реализует поиск заявки по id.
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по id ------------ ");
        String id = this.input.ask("Введите уникальный номер заявки, которую нужно найти: ");
        for (Item item : tracker.getAll()) {
            if (item.getId().equals(tracker.findById(id))) {
                System.out.println(item);
                break;
            }
            System.out.println("------------ Конец списка всех заявок ------------ ");
        }
    }
    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени ------------ ");
        String name = this.input.ask("Введите имя заявки, которую нужно найти: ");
        for (Item item : tracker.getAll()) {
            if (item.getName().equals(tracker.findByName(name))) {
                System.out.println(item);
            }
            System.out.println("------------ Конец списка всех заявок ------------ ");
        }
    }
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Показать все заявки.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по уникальному номеру.");
        System.out.println("5. Найти заявку по названию.");
        System.out.println("6. Выйти из программы.");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        //Input input = new ConsoleInput();
        //new StartUI(input).init();
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}