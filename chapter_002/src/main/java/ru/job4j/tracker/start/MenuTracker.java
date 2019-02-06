package ru.job4j.tracker.start;

import com.sun.xml.internal.rngom.parse.host.Base;
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
        this.userActions.add(new AddItem(0,"Добавить новую заявку."));
        this.userActions.add(new GetAllItem(1,  "Показать все заявки."));
        this.userActions.add(new ReplaceItem(2,"Редактировать заявку."));
        this.userActions.add(new DeleteItem(3,"Удалить заявку."));
        this.userActions.add(new FindByIdItem(4,"Найти заявку по уникальному номеру."));
        this.userActions.add(new FindByNameItem(5,"Найти заявку по имени."));
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

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Task(name, desc));
        }
    }

    private class GetAllItem extends BaseAction {
        public GetAllItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(item);
            }
        }
    }

    private class ReplaceItem extends BaseAction {
        public ReplaceItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            tracker.replace(id, new Item(name, desc));
            System.out.println("Изменения внесены успешно.");
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        }
    }

    private class FindByIdItem extends BaseAction {
        public FindByIdItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            System.out.println(tracker.findById(id));
        }
    }

    private class FindByNameItem extends BaseAction {
        public FindByNameItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки: ");
            for (Item item : tracker.findByName(name)) {
                    System.out.println(item);
            }
        }
    }
}
