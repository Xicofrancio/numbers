package com.aor.numbers;

public class PositiveFilter implements GenericListFilter {
    public PositiveFilter(GenericListFilter filter) {

    }

    @Override
    public boolean accept(Integer number) {
        if (number >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
