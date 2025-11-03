package lotto.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;

import lotto.Lotto;

public class Setting {
    public static Lotto winLotto ;
    public static int bonus_numb ;
    public void setting_play(){
       
        while(winLotto == null){
             System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                winNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        while(bonus_numb == 0){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                bonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void winNumbers(){
        String a = camp.nextstep.edu.missionutils.Console.readLine();
        String[] numbers ;
        List<Integer> numbers_int = new ArrayList<>();

           
        
        try {
            numbers = a.split(",");
            for (int i = 0; i < numbers.length; i++) {
                numbers_int.add(Integer.parseInt(numbers[i]));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력이 잘못 되었습니다.");
        }
        
        
        validate_winNumber(numbers_int);
        
        Collections.sort(numbers_int);
        winLotto = Lotto.makeLotto(numbers_int);
        return ;
    }
    public static void validate_winNumber(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(numbers.size() != new HashSet<Integer>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) < 1 || numbers.get(i) > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다");
            }
        }

    }

    public void bonusNumber(){
        int numb = 0;
        try{
            String temp =camp.nextstep.edu.missionutils.Console.readLine();
            numb = Integer.parseInt(temp);

        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자 입력이 잘못 되었습니다."); 
        }   
        if(numb < 1 || numb > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1 ~ 45 사이의 숫자여야 합니다");
        }
        if(numb_inrange(winLotto, numb)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
        }        
        
        bonus_numb = numb;
        
    }
    public boolean numb_inrange(Lotto target, int a){
        List<Integer> temp = target.getNumbers();
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) == a){
                return true;
            }
        }
        return false;

    }
}
