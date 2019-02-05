package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> userActions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionMenuLength() {
        return this.userActions.size();
    }

    public void fillAction() {
        this.userActions.add(new AddItem());
        this.userActions.add(new GetAllItem());
        this.userActions.add(new ReplaceItem());
        this.userActions.add(new DeleteItem());
        this.userActions.add(new FindByIdItem());
        this.userActions.add(new FindByNameItem());
    }

    public void select(int key) {
        this.userActions.get(key).execute(this.input, tracker);
    }

    public void showMenu() {
        for (UserAction action : this.userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Task(name, desc));
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Добавить новую заявку.");
        }
    }

    private class GetAllItem implements UserAction {
        @Override
        public int key() {
            return 1;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(item);
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Показать все заявки.");
        }
    }

    private class ReplaceItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            tracker.replace(id, new Item(name, desc));
            System.out.println("Изменения внесены успешно.");
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Редактировать заявку.");
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Удалить заявку.");
        }
    }

    private class FindByIdItem implements UserAction {
        @Override
        public int key() {
            return 4;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            System.out.println(tracker.findById(id));
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Найти заявку по уникальному номеру.");
        }
    }

    private class FindByNameItem implements UserAction {
        @Override
        public int key() {
            return 5;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            for (Item item : tracker.findByName(name)) {
                    System.out.println(item);
            }
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), " Найти заявку по имени.");
        }
    }
}
