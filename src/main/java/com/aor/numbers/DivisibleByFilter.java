package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    Integer numero;

    public DivisibleByFilter(GenericListFilter filter, Integer number) {
        numero = number;
    }
    @Override
    public boolean accept(Integer number) {
        if(number%numero==0){
            return true;
        }else{
            return false;
        }
    }
}
