package lotto.method;

import java.util.ArrayList;
import java.util.List;

public class Buy {
    public static List<List<Integer>> list_lotto = new ArrayList<>(); // public 할필요는 없다.

    public static int buyLotto(){
        // TODO : 길이 넘음 - 각 함수 호출만 으로 분리필요
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;

        try{
            money = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        }
        // TODO : 오류
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력 오류(나중에 바꿈)"); 
        }
        int amount = amountLotto(money);
        System.out.println(amount + "개를 구매했습니다.");
        for(int i = 0; i < amount; i++){
            List<Integer> paid_Lotto = numbLotto();
            paid_Lotto.sort(null);
            list_lotto.add(paid_Lotto);
        }
        
        return amount;
    }
    public static int amountLotto(int money){
        int amount = money / 1000;
        return amount;
    }

    public static List<Integer> numbLotto(){
        List<Integer> paid_Lotto = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(paid_Lotto);
        return paid_Lotto;
    }


}
