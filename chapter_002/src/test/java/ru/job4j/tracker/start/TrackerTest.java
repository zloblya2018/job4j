package ru.job4j.tracker.start;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
    private final Tracker tracker = new Tracker();

    @Test
    public void whenAddingAnItem() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        assertThat(tracker.getAll()[0], is(firstItem));
    }

    @Test
    public void whenEditingTheItem() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "secondTestDescription", 444);
        secondItem.setId(firstItem.getId());
        tracker.replace(firstItem.getId(), secondItem);
        assertThat(tracker.findById(firstItem.getId()).getName(), is("secondItem"));
    }

    @Test
    public void whenDeleteItemThenItemsHasNoItem() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        Item[] expected = {null, secondItem};
        tracker.delete(("firstItem"));
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenSearchingForAnItemById() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        assertThat(tracker.findById(firstItem.getId()), is(firstItem));
    }

    @Test
    public void whenSearchingForItemByName() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        Item[] expected = {firstItem};
        assertThat(tracker.findByName(firstItem.getName()), is(expected));
    }

    @Test
    public void whenRequestingAllItems() {
        Item firstItem = new Item("firstItem", "testDescription", 333);
        tracker.add(firstItem);
        Item secondItem = new Item("secondItem", "testDescription", 333);
        tracker.add(secondItem);
        Item[] expected  = {firstItem, secondItem};
        assertThat(tracker.getAll(), is(expected));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        StubInput stubInput = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(stubInput, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[] {"2", item.getId(),
                "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

}