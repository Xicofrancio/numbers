package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    Integer numero;

    public DivisibleByFilter(GenericListFilter filter, Integer number) {
        numero = number;
    }
    private int divider;

    public DivisibleByFilter(int divider) {
        this.divider = divider;
    }

    @Override
    public boolean accept(Integer number) {
        return number % divider == 0;
    }
}
