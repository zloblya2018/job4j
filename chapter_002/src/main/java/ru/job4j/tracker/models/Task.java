package ru.job4j.tracker.models;

public class Task extends Item {
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String calculatePrice() {
        return "100%";
    }
}
