package lotto.method;

import lotto.Lotto;

public class Play {
    public static int[] result = new int[6];
    public enum PRIZE {
        ZERO(0),
        ONE(2_000_000_000),
        TWO(30_000_000),
        THREE(1_500_000),
        FOUR(50_000),
        FIVE(5_000);
        private final int money;
        public int getMoney() {
            return money;
        }   
        private PRIZE(int money) {
            this.money = money;
        }
    }    

    public void play(){
        for (int i = 0; i < lotto.method.Buy.list_lotto.size(); i++) {
            PRIZE prize = check_same(lotto.method.Buy.list_lotto.get(i)); 
            result[prize.ordinal()]++;
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

    public void print_result(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");  
        System.out.println("3개 일치 (5,000원) - " + result[PRIZE.FIVE.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " + result[PRIZE.FOUR.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[PRIZE.THREE.ordinal()] + "개"); 
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[PRIZE.TWO.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[PRIZE.ONE.ordinal()] + "개");
        // 이것도 enum에 넣고싶은데
        print_rate();

    }
    public static void print_rate(){
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i]* PRIZE.values()[i].getMoney();
        }
        System.out.println("총 수익률은 " +Math.round(sum*100.0/lotto.method.Buy.list_lotto.size()/100)/10.0 + "%입니다.");
    } 

}
