package me.day24.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeMoneyTest {

    @Test
    public void 손님이_선택한_물품가격을_투입금액에서_차감한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        assertEquals(350, vm.getMoney(), "손님이 선택한 물품 가격을 투입 금액에서 차감한다");
    }

    @Test
    public void 손님에게_거스름돈을_반환한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.setInputMoney(1000);
        vm.setSelectedProduct(650);
        vm.inputMoneyAndProductDeduct();

        ChangeMoney cm = new ChangeMoney();
        cm.setChangeMoney(vm.getMoney());

        // 350 => 100 * 3 + 50 * 1
        int[] money = cm.getChangeMoney();
        assertEquals(0, money[0], "손님에게 반환 할 500원의 개수");
        assertEquals(3, money[1], "손님에게 반환 할 100원의 개수");
        assertEquals(1, money[2], "손님에게 반환 할 50원의 개수");
        assertEquals(0, money[3], "손님에게 반환 할 10원의 개수");
    }
}
