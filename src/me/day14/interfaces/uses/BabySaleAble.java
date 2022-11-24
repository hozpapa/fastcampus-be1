package me.day14.interfaces.uses;

public interface BabySaleAble extends AmusementParkSaleAble {
    @Override
    default double saleRate() {
        return 1.0; // 100%
    }
}
