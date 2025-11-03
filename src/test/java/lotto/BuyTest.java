package lotto;

import org.junit.jupiter.api.Test;

import lotto.method.Buy;

import static org.assertj.core.api.Assertions.assertThat;


class BuyTest {
    @Test
    void 구입금액_입력_테스트() {
        int amount = Buy.amountLotto(5500);
        assertThat(amount).isEqualTo(5);
    }
    

}