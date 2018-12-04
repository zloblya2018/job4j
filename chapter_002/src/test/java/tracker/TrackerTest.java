package tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.Tracker;

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
        tracker.replace(firstItem.getId(), secondItem);
        assertThat(tracker.findById(firstItem.getId()).getName(), is("secondItem"));
    }

    @Test
    public void whenDeleteItemThenItemsHasNoItem() {
        Tracker tracker = new Tracker();
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
        Item[] expected = {firstItem};
        assertThat(tracker.findByName(firstItem.getName()), is(expected));
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