package me.day14.interfaces.uses;

public interface StudentSaleAble extends AmusementParkSaleAble {
    default double saleRate() {
        return 0.3;
    }
}
