package lotto.method;

public class buy {
    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        int amount = amountLotto(money);
        return amount;
    }
    public static int amountLotto(int money){
        int amount = money / 1000;
        return amount;
    }
}
