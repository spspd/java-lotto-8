package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = lotto.method.buy.buyLotto();
        System.out.println(amount);
        Lotto a = new lotto.Lotto(List.of(1,2,3,4,5,6));

    }
}
