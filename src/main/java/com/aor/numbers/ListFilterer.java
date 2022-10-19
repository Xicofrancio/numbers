package com.aor.numbers;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class ListFilterer implements GenericListFilter{
    public List<Integer> filter(List<Integer> list){
        
        return list;
    }

    public ListFilterer(GenericListFilter filter) {
    }

    @Override
    public boolean accept(Integer number) {
        return false;
    }
}
