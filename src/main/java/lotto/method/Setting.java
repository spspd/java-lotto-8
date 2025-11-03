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
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winNumbers();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusNumber();
    }

    public void winNumbers(){
        //TODO
        String a = camp.nextstep.edu.missionutils.Console.readLine();
        String[] numbers ;
        List<Integer> numbers_int = new ArrayList<>();

        try{
            numbers = a.split(",");
            for (int i = 0; i < numbers.length; i++) {
                numbers_int.add(Integer.parseInt(numbers[i]));
            }   
            validate_winNumber(numbers_int); 
        } 
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력 오류"); 
        }
        
        
        Collections.sort(numbers_int);
        winLotto = Lotto.makeLotto(numbers_int);
    }
    public static void validate_winNumber(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if(numbers.size() != new HashSet<Integer>(numbers).size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

    }

    public void bonusNumber(){
        //TODO
        int numb = 0;
        try{
            String temp =camp.nextstep.edu.missionutils.Console.readLine();
            numb = Integer.parseInt(temp);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스입력 오류(나중에 바꿈)"); 
        }
        //validate_bonusNumber(); trycatch로 대체
        bonus_numb = numb;
        
    }

}
