package ru.job4j.tracker;

import com.sun.tools.javac.jvm.Items;
import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {

    @Test
    public void whenAddingAnItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        assertThat(tracker.getAll()[0], is(firstItem));
    }

    @Test
    public void whenEditingTheItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "secondTestDescription", 444);
        secondItem.setId(firstItem.getId());
        tracker.replace(secondItem);
        assertThat(tracker.findById(firstItem.getId()).getName(), is("secondItem"));

    }

    @Test
    public void whenDeleteItemThenItemsHasNoItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        tracker.delete((firstItem));
        assertThat(tracker.findById(firstItem.getId()), is((Item) null));
    }

    @Test
    public void whenSearchingForAnItemById() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        assertThat(tracker.findById(firstItem.getId()), is(firstItem));
    }

    @Test
    public void whenSearchingForItemByName() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        assertThat(tracker.findByName("firstItem"), is(firstItem));
    }

    @Test
    public void whenRequestingAllItems() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        Item[] expected  = {firstItem, secondItem};
        assertThat(tracker.getAll(), is(expected));
    }
}