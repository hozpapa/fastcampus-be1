package me.day14.interfaces.uses;

public interface AmusementParkSaleAble {
    default double saleRate() {
        return 0.0;
    }
}
