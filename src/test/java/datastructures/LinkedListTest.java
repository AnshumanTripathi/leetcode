package datastructures;

import datastructures.linkedlist.IntegerList;
import datastructures.linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTest {

    @Test
    public void testLinkedListCRUD() {
        final LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("this");
        linkedList.add("is");
        linkedList.add("a");
        linkedList.add("linked");
        linkedList.add("list");

        List<String> asList = new ArrayList<>();
        linkedList.foreach(asList::add);

        Assert.assertArrayEquals(asList.toArray(), new String[]{"this", "is", "a", "linked", "list"});
        Assert.assertEquals(linkedList.length(), asList.size());

        linkedList.remove("a");
        asList.clear();
        linkedList.foreach(asList::add);

        Assert.assertArrayEquals(asList.toArray(), new String[]{"this", "is", "linked", "list"});

        linkedList.reverse();
        asList.clear();
        linkedList.foreach(asList::add);

        Assert.assertArrayEquals(asList.toArray(), new String[]{"list", "linked", "is", "this"});
    }

    @Test
    public void testLinkedListSorting() {
        IntegerList integerList = new IntegerList();
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(5);

        integerList.sort();

        List<Integer> asIntList = new ArrayList<>();
        integerList.foreach(asIntList::add);

        Assert.assertArrayEquals(asIntList.toArray(), new Integer[]{1, 2, 3, 4, 5});
    }
}
