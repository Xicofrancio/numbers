package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    public List<Integer> helper(){
        return Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void deduplicate() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Assertions.assertEquals(Arrays.asList(1,2,4,5), distinct);
    }
}
