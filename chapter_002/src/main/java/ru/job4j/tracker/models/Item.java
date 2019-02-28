package ru.job4j.tracker.models;;

import java.util.*;

public class Item {
    public String name;
    public String description;
    private long create;
    private String id;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreate() {
        return this.create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\'' + ", description='" + description + '\'' + ", create="
                + create + ", id='" + id + '\'' + ", comments=" + Arrays.toString(comments) + '}';
    }
    /*
    public enum TrackerSingle {
        INSTANCE;

        public Item add(Item model) {
            return model;
        }
    }*/

    /*
    public static class TrackerSingle {
        private static TrackerSingle instance;

        private TrackerSingle() {
        }

        public static TrackerSingle getInstance() {
            if (instance == null) {
                instance = new TrackerSingle();
            }
            return instance;
        }

        public Item add(Item model) {
            return model;
        }
    }
    */
    /*
    public static class TrackerSingle {
        private static TrackerSingle INSTANCE = new TrackerSingle();

        private TrackerSingle() {
        }

        public static TrackerSingle getInstance() {
            return INSTANCE;
        }

        public Item add(Item model) {
            return model;
        }
    }
    */
    public static class TrackerSingle {

        private TrackerSingle() {
        }

        public static TrackerSingle getInstance() {
            return Holder.INSTANCE;
        }

        public Item add(Item model) {
            return model;
        }

        private static class Holder {
            private static final TrackerSingle INSTANCE = new TrackerSingle();
        }
    }

}
