package me.day14.interfaces.uses;

public interface BabySaleAble extends AmusementParkSaleAble {
    default double saleRate() {
        return 1.0;
    }
}
