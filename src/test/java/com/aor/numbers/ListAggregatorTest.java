package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListAggregatorTest {
    public List<Integer> helper(){
        return Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);
        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        int distinct = aggregator.distinct(list, deduplicator);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));
    }

    @Test
    public void max_bug_7263(){
        List<Integer> list = Arrays.asList(-1,-4,-5);
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        Assertions.assertEquals(-1,max);
    }

    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        List<Integer> distinct = deduplicator.deduplicate(list);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

    }


}
