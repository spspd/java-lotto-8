package lotto.method;

import lotto.Lotto;
import lotto.method.Setting;

public class Play {
    public enum PRIZE {
        ZERO(0),
        FIVE(5_000),
        FOUR(50_000),
        THREE(1_500_000),
        TWO(30_000_000),
        ONE(2_000_000_000);
        private final int money;
        public int getMoney() {
            return money;
        }   
        private PRIZE(int money) {
            this.money = money;
        }
    }    


    public static PRIZE check_same(Lotto paid){

        int count = 0;
        boolean bonus = false;
        count = check_num(paid, Setting.winLotto);
        bonus = check_Lotto(paid, Setting.bonus_numb);
        return check_prize(count, bonus);
        
    }
    public static int check_num(Lotto target, Lotto win){
        int count = 0;
        for (int i = 0; i < 6; i++) {
            int check_num = win.getNumbers().get(i);
            if (check_Lotto(target, check_num)) {
                count++;
            }
        }
        return count;
    }
    public static boolean check_Lotto(Lotto target,int num){
        for (int i = 0; i < 6; i++) {
            if (target.getNumbers().get(i) == num) {
                return true;
            }
        }
        return false;
    }
    public static PRIZE check_prize(int count, boolean bonus){
        if (count == 6 && !bonus) { return PRIZE.ONE; }
        if (count == 5 && bonus) { return PRIZE.TWO; }
        if (count == 5 ) { return PRIZE.THREE; }
        if (count == 4 ) { return PRIZE.FOUR; }
        if (count == 3 ) { return PRIZE.FIVE; }
        return PRIZE.ZERO;
    }


}
