package me.day14.interfaces.uses;

// 클래스 extends 클래스 (클래스의 상속)
// 인터페이스 extends 인터페이스 (인터페이스의 상속)
// 클래스 implements 인터페이스 (인터페이스의 구현)

public interface StudentSaleAble extends AmusementParkSaleAble {
    @Override
    default double saleRate() {
        return 0.3; // 30%
    }
}
