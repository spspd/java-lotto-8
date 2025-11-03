package lotto.method;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;



public class Buy {
    public static List<Lotto> list_lotto = new ArrayList<Lotto>(); // public 할필요는 없다.

    public static int buyLotto(){
        list_lotto.clear(); // static test error
        int money = -1 ; int attempts = 0;
        while(money == -1 && attempts < 6){
            try {
                money = input_money();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        int amount = amountLotto(money);
        payLotto(amount);
        return amount;
    }
    public static int input_money(){
        System.out.println("\n" + "구입금액을 입력해 주세요.");
        int money = 0;
        try{
            money = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        }
        catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구입금액 입력 오류"); 
        }
        return money;
    }

    public static int amountLotto(int money){
        int amount = money / 1000;
        return amount;
    }
    public static int payLotto(int amount){
        System.out.println("\n" +amount + "개를 구매했습니다.");
        for(int i = 0; i < amount; i++){
            list_lotto.add(Lotto.makeLotto());
        }
        return amount;
    }





}
