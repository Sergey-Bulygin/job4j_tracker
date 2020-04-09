package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    /**
     * The test tracker field.
     */
    private Tracker tracker;

    /**
     * The first item field.
     */
    private Item first;

    /**
     * The second item field.
     */
    private Item second;

    /**
     * The third item field.
     */
    private Item third;

    /**
     * First index array field.
     */
    private int firstIndex = 0;

    /**
     * Information method to test.
     */
    @Before
    public void infoForTest() {
        tracker = new Tracker();
        first = new Item("test1");
        second = new Item("test2");
        third = new Item("test3");
    }

    /**
     * Test method add.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {

        tracker.add(first);
        Item result = tracker.findById(first.getId());
        assertThat(result.getName(), is(first.getName()));
    }

    /**
     * Test method findByName.
     */
    @Test
    public void whenGetNameThenReturnThisName() {
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findByName(first.getName())[firstIndex];
        Item resultSecond = tracker.findByName(second.getName())[firstIndex];
        assertThat((result), is(first));
        assertThat((resultSecond), is(second));

    }

    /**
     * Test method findAll.
     */
    @Test
    public void whenFindAllThenReturnAll() {
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        Item[] result = tracker.findAll();
        assertThat((result), arrayContainingInAnyOrder(first, second, third));
    }
}