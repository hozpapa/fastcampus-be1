package me.day24.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InputMoneyTest {

    @Test
    public void 손님이_구매하기위해_넣은금액을_확인한다() throws Exception {
        VendingMachine vm = new VendingMachine();
        int money = vm.getMoney();

        assertNotNull(money);
    }

    @Test
    public void 손님이_넣은_금액이_0이하일수없다() throws Exception {
        VendingMachine vm = new VendingMachine();
      vm.setInputMoney(-1);
//        vm.setInputMoney(1000);

        assertTrue(vm.getMoney() > 0, "투입 금액은 0이하 일수 없다");
    }
}
